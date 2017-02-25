package com.zwb.beans;

import java.util.List;

public class PageBean {
	@SuppressWarnings("rawtypes")
	private List list;  //返回某一页的结果
	private int allRows; //总记录数
	private int pageSize;
	private int currentPage;
	private int allPages;
	@SuppressWarnings("unused")
	private boolean isFirstPage;
	@SuppressWarnings("unused")
	private boolean isLastPage;
		
	
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	public int getAllRows() {
		return allRows;
	}

	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getAllPages() {
		return allPages;
	}

	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public void init(){
		isFirstPage=isFirstPage();
		isLastPage = isLastPage();
	}
	
	public boolean isFirstPage(){
		return this.currentPage==1;
	}
	
	public boolean isLastPage(){
		return this.currentPage==this.allPages;
	}
	
	public static int countTotalPage(final int pageSize,final int allRow){
		   int totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1;
		   return totalPage;
	}
	
	public static int countOffset(final int pageSize,final int currentPage){
		   final int offset = pageSize*(currentPage-1);
		   return offset;
	}
	
	public static int countCurrentPage(int page){
		   final int curPage = (page==0?1:page);
		   return curPage;
	}
}
