package edu.handong.csee.java.datamodel;

public class Summary {
	
	private String topicS;
	private String summaryS;
	private String wordS;
	private String dateS;
	private String linkS;
	private String fromS;
	
	public String getTopicS() {
		return topicS;
	}

	public void setTopicS(String topicS) {
		this.topicS = topicS;
	}

	public String getSummaryS() {
		return summaryS;
	}

	public void setSummaryS(String summaryS) {
		this.summaryS = summaryS;
	}

	public String getWordS() {
		return wordS;
	}

	public void setWordS(String wordS) {
		this.wordS = wordS;
	}

	public String getDateS() {
		return dateS;
	}

	public void setDateS(String dateS) {
		this.dateS = dateS;
	}

	public String getLinkS() {
		return linkS;
	}

	public void setLinkS(String linkS) {
		this.linkS = linkS;
	}

	public String getFromS() {
		return fromS;
	}

	public void setFromS(String fromS) {
		this.fromS = fromS;
	}

	@Override
	public String toString() {
		return "Summary [topicS=" + topicS + ", summaryS=" + summaryS + ", wordS=" + wordS + ", dateS=" + dateS
				+ ", linkS=" + linkS + ", fromS=" + fromS + "]";
	}
	
}
