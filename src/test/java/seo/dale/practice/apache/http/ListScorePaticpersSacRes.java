package seo.dale.practice.apache.http;

import java.util.List;

public class ListScorePaticpersSacRes {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 평점별 리스트.
	 */
	private List<AvgScore> avgScoreList;

	/**
	 * @return List<AvgScore>
	 */
	public List<AvgScore> getAvgScoreList() {
		return this.avgScoreList;
	}

	/**
	 * @param avgScoreList
	 *            avgScoreList
	 */
	public void setAvgScoreList(List<AvgScore> avgScoreList) {
		this.avgScoreList = avgScoreList;
	}

}
