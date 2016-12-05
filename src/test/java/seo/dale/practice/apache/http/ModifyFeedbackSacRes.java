package seo.dale.practice.apache.http;

public class ModifyFeedbackSacRes {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 상품 ID.
	 */
	private String prodId;

	/**
	 * 사용후기 번호.
	 */
	private String notiSeq;

	/**
	 * @return String
	 */
	public String getProdId() {
		return this.prodId;
	}

	/**
	 * @param prodId
	 *            prodId
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	/**
	 * @return String
	 */
	public String getNotiSeq() {
		return this.notiSeq;
	}

	/**
	 * @param notiSeq
	 *            notiSeq
	 */
	public void setNotiSeq(String notiSeq) {
		this.notiSeq = notiSeq;
	}

}
