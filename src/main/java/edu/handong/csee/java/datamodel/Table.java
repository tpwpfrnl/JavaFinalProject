package edu.handong.csee.java.datamodel;

public class Table {
	
	private String topic;
	private String serialNumber;
	private String type;
	private String info;
	private String page;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	

	@Override
	public String toString() {
		return "Table [topic=" + topic + ", serialNumber=" + serialNumber + ", type=" + type + ", info=" + info
				+ ", page=" + page + "]";
	}

}
