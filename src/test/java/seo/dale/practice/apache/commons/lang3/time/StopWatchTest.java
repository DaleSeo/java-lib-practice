package seo.dale.practice.apache.commons.lang3.time;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class StopWatchTest {

	@Test
	public void test() throws InterruptedException {
		StopWatch stopWatch = new StopWatch();

		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		stopWatch.split();
		System.out.println(stopWatch);
		
		Thread.sleep(3000);
		stopWatch.stop();
		System.out.println(stopWatch);
		
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(1000);
		stopWatch.stop();
		System.out.println(stopWatch);
	}

}
