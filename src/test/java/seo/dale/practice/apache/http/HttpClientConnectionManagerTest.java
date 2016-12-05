package seo.dale.practice.apache.http;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * http://www.baeldung.com/httpclient-connection-management
 * @author Dale Seo
 */
public class HttpClientConnectionManagerTest {

	/**
	 * mange a single connection
	 */
	@Test
	public void testBasicHttpClientConnectionManager() {
		BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager();
		HttpRoute route = new HttpRoute(new HttpHost("www.baeldung.com", 80));
		ConnectionRequest request = connManager.requestConnection(route, null);
		System.out.println(request);
	}

	@Test(expected = IllegalStateException.class)
	public void testThrowIllegalStateException() throws InterruptedException, ExecutionException, IOException, HttpException {
		BasicHttpClientConnectionManager basicConnManager =  new BasicHttpClientConnectionManager();
		HttpClientContext context = HttpClientContext.create();

		HttpGet get = new HttpGet("http://www.baeldung.com");

		// low level
		HttpRoute route = new HttpRoute(new HttpHost("www.baeldung.com", 80));
		ConnectionRequest connRequest = basicConnManager.requestConnection(route, null);
		HttpClientConnection conn = connRequest.get(10, TimeUnit.SECONDS);
		basicConnManager.connect(conn, route, 1000, context);
		basicConnManager.routeComplete(conn, route, context);

		HttpRequestExecutor exeRequest = new HttpRequestExecutor();
		context.setTargetHost((new HttpHost("www.baeldung.com", 80)));
		HttpResponse response = exeRequest.execute(get, conn, context);
		EntityUtils.consume(response.getEntity());

		// basicConnManager.releaseConnection(conn, null, 1, TimeUnit.SECONDS);

		// high level
		CloseableHttpClient client = HttpClients.custom()
				.setConnectionManager(basicConnManager)
				.build();
		client.execute(get); // java.lang.IllegalStateException: Connection is still allocated
		fail();
	}

	@Test
	public void test1() throws InterruptedException {
		HttpGet get = new HttpGet("www.baeldung.com");
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setDefaultMaxPerRoute(5);
		connManager.setMaxTotal(5);
		CloseableHttpClient client = HttpClients.custom()
				.setConnectionManager(connManager)
				.build();
		MultiHttpClientConnThread[] threads = new  MultiHttpClientConnThread[10];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new MultiHttpClientConnThread(client, get, connManager);
		}
		for (MultiHttpClientConnThread thread: threads) {
			thread.start();
		}
		for (MultiHttpClientConnThread thread: threads) {
			thread.join(1000);
		}
	}

	/**
	 * manage multi connections in a pool
	 */
	@Test
	public void testPoolingHttpClientConnectionManager() throws IOException {
		PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
		poolingConnManager.setMaxTotal(10);
		poolingConnManager.setDefaultMaxPerRoute(2);
		HttpHost host = new HttpHost("http://www.baeldung.com");
		poolingConnManager.setMaxPerRoute(new HttpRoute(host), 5);
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(poolingConnManager).build();
		CloseableHttpResponse response = client.execute(new HttpGet("http://www.baeldung.com"));
		System.out.println(response);
		System.out.println(poolingConnManager);
		Assert.assertEquals(1, poolingConnManager.getTotalStats().getLeased());
	}

	@Test
	public void testUsingTwoHttpClientsToConnectToOneTargetHostEach() throws InterruptedException {
		HttpGet get1 = new HttpGet("http://www.baeldung.com/");
		HttpGet get2 = new HttpGet("http://google.com");
		PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient client1 = HttpClients.custom().setConnectionManager(poolingConnManager).build();
		CloseableHttpClient client2 = HttpClients.custom().setConnectionManager(poolingConnManager).build();

		MultiHttpClientConnThread thread1 = new MultiHttpClientConnThread(client1, get1);
		MultiHttpClientConnThread thread2 = new MultiHttpClientConnThread(client2, get2);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}

	@Test
	public void testDefaultMax2() throws InterruptedException {
		HttpGet get = new HttpGet("http://www.baeldung.com");
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
		MultiHttpClientConnThread thread1 = new MultiHttpClientConnThread(client, get);
		MultiHttpClientConnThread thread2 = new MultiHttpClientConnThread(client, get);
		MultiHttpClientConnThread thread3 = new MultiHttpClientConnThread(client, get);
		thread1.start();
		thread2.start();
		thread3.start();
		thread1.join();
		thread2.join();
		thread3.join();
	}

	@Test
	public void test() {
		ConnectionKeepAliveStrategy myStrategy = (response, context) -> {
			HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
			while (it.hasNext()) {
				HeaderElement he = it.nextElement();
				String param = he.getName();
				String value = he.getValue();
				if (value != null && param.equalsIgnoreCase("timeout")) {
					return Long.parseLong(value) * 1000;
				}
			}
			return 5 * 1000;
		};

		PoolingHttpClientConnectionManager connManager
				= new PoolingHttpClientConnectionManager();
		CloseableHttpClient client = HttpClients.custom()
				.setKeepAliveStrategy(myStrategy)
				.setConnectionManager(connManager)
				.build();
	}

	public class MultiHttpClientConnThread extends Thread {
		private CloseableHttpClient client;
		private HttpGet get;
		private PoolingHttpClientConnectionManager connManager;

		public MultiHttpClientConnThread(CloseableHttpClient client, HttpGet get) {
			this.client = client;
			this.get = get;
		}
		public MultiHttpClientConnThread(CloseableHttpClient client, HttpGet get, PoolingHttpClientConnectionManager connManager) {
			this.client = client;
			this.get = get;
			this.connManager = connManager;
		}
		public void run(){
			try {
				if (connManager != null) {
					System.out.println(connManager.getTotalStats());
				}
				HttpResponse response = client.execute(get);
				EntityUtils.consume(response.getEntity());
			} catch (ClientProtocolException ex) {
			} catch (IOException ex) {
			}
		}
	}

}