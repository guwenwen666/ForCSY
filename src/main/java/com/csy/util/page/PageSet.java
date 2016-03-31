package com.csy.util.page;

import java.io.Serializable;
import java.util.List;

public class PageSet<E> implements Serializable{

	private static final long serialVersionUID = 1L;
	private int totalRows;
	private int pageSize;
	private int currPageNum;
	private int totalPages;
	private int startRow;
	private int endRow;
	private List<E> pageData;

	public PageSet(int totalRows, int currPageNum, int pageSize){
		this.totalRows = totalRows;
		this.pageSize = pageSize;
		this.currPageNum = currPageNum;
		totalPages = totalRows / pageSize;
		if (totalRows % pageSize != 0)
			totalPages++;
		if (currPageNum <= 0)
			this.currPageNum = 1;
		if (totalPages < currPageNum)
			this.currPageNum = totalPages;
		startRow = (this.currPageNum - 1) * this.pageSize;
		endRow = startRow + this.pageSize;
		if (this.totalRows < endRow)
			endRow = this.totalRows;
	}

	public int getTotalRows(){
		return totalRows;
	}

	public int getPageSize(){
		return pageSize;
	}

	public int getCurrPageNum(){
		return currPageNum;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public int getStartRow(){
		return startRow;
	}

	public int getEndRow(){
		return endRow;
	}

	public List<E> getPageData(){
		return pageData;
	}

	public void setPageData(List<E> pageData){
		this.pageData = pageData;
	}

}
