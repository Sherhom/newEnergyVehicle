package edu.domain;

public class SelectDriveEventBean {
	private String startDate;
	private String endDate;
	private String keyword;
	public SelectDriveEventBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SelectDriveEventBean(String startDate, String endDate, String keyword) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SelectDriveEventBean [startDate=" + startDate + ", endDate=" + endDate + ", keyword=" + keyword + "]";
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
