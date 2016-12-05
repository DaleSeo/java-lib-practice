package seo.dale.practice.apache.http;

public class ModifyFeedbackSacReq {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 상품 ID.
	 */
	private String prodId;
	/**
	 * 사용자 Key.
	 */
	private String userKey;
	/**
	 * 사용자 ID.
	 */
	private String userId;
	/**
	 * 사용후기 번호.
	 */
	private String notiSeq;
	/**
	 * 채널 ID.
	 */
	private String chnlId;
	/**
	 * 사용후기 제목.
	 */
	private String notiTitle;
	/**
	 * 사용후기 내용.
	 */
	private String notiDscr;
	/**
	 * 평점.
	 */
	private String avgScore;
	/**
	 * 패키지 버전 코드.
	 */
	private String pkgVer;

	/**
	 * 페이스북 전송 여부.
	 */
	private String fbPostYn;

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
	public String getUserKey() {
		return this.userKey;
	}

	/**
	 * @param userKey
	 *            userKey
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	/**
	 * @return String
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * @param userId
	 *            userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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

	/**
	 * @return String
	 */
	public String getChnlId() {
		return this.chnlId;
	}

	/**
	 * @param chnlId
	 *            chnlId
	 */
	public void setChnlId(String chnlId) {
		this.chnlId = chnlId;
	}

	/**
	 * @return String
	 */
	public String getNotiTitle() {
		return this.notiTitle;
	}

	/**
	 * @param notiTitle
	 *            notiTitle
	 */
	public void setNotiTitle(String notiTitle) {
		this.notiTitle = notiTitle;
	}

	/**
	 * @return String
	 */
	public String getNotiDscr() {
		return this.notiDscr;
	}

	/**
	 * @param notiDscr
	 *            notiDscr
	 */
	public void setNotiDscr(String notiDscr) {
		this.notiDscr = notiDscr;
	}

	/**
	 * @return String
	 */
	public String getAvgScore() {
		return this.avgScore;
	}

	/**
	 * @param avgScore
	 *            avgScore
	 */
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	/**
	 * @return String
	 */
	public String getPkgVer() {
		return this.pkgVer;
	}

	/**
	 * @param pkgVer
	 *            pkgVer
	 */
	public void setPkgVer(String pkgVer) {
		this.pkgVer = pkgVer;
	}

	/**
	 * @return the fbPostYn
	 */
	public String getFbPostYn() {
		return this.fbPostYn;
	}

	/**
	 * @param fbPostYn
	 *            the fbPostYn to set
	 */
	public void setFbPostYn(String fbPostYn) {
		this.fbPostYn = fbPostYn;
	}
}
