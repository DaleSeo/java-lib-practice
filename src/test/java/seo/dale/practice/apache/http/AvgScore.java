package seo.dale.practice.apache.http;

public class AvgScore {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 평점.
	 */
	private String avgScore;

	/**
	 * 평점 퍼센트.
	 */
	private String avgScorePct;
	/**
	 * 참여수.
	 */
	private String paticpersCnt;

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
	public String getAvgScorePct() {
		return this.avgScorePct;
	}

	/**
	 * @param avgScorePct
	 *            avgScorePct
	 */
	public void setAvgScorePct(String avgScorePct) {
		this.avgScorePct = avgScorePct;
	}

	/**
	 * @return String
	 */
	public String getPaticpersCnt() {
		return this.paticpersCnt;
	}

	/**
	 * @param paticpersCnt
	 *            paticpersCnt
	 */
	public void setPaticpersCnt(String paticpersCnt) {
		this.paticpersCnt = paticpersCnt;
	}

}
