package com.ApplicationJ.config;

public class Request {

	private Integer pageNo;
	private Integer pageSize;
	private Boolean sortOrder;
	private Object searchString;
	private String sortFieldName;
	private Object requestPayLoad;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortFieldName() {
		return sortFieldName;
	}

	public void setSortFieldName(String sortFieldName) {
		this.sortFieldName = sortFieldName;
	}

	public Boolean getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Object getSearchString() {
		return searchString;
	}

	public void setSearchString(Object searchString) {
		this.searchString = searchString;
	}

	public Object getRequestPayLoad() {
		return requestPayLoad;
	}

	public void setRequestPayLoad(Object requestPayLoad) {
		this.requestPayLoad = requestPayLoad;
	}

}
