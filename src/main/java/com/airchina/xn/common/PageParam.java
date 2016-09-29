/**
 * 
 */
package com.airchina.xn.common;

import java.io.Serializable;

/**
 * @author augus
 *
 */
public class PageParam implements Serializable {

	/**
	 * 目前 offsetStart 并未使用上。
	 * countPerPage 每页记录数
	 * currentPage  当前页数
	 * 
	 */
	private static final long serialVersionUID = -8051314263192041723L;

	private Integer offsetStart;
	private Integer offsetStop;
	private Integer countPerPage;
	private Integer currentPage;
	
	public Integer getOffsetStart() {
		return offsetStart;
	}
	public void setOffsetStart(Integer offsetStart) {
		this.offsetStart = offsetStart;
	}
	public Integer getOffsetStop() {
		return offsetStop;
	}
	public void setOffsetStop(Integer offsetStop) {
		this.offsetStop = offsetStop;
	}
	public Integer getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(Integer countPerPage) {
		this.countPerPage = countPerPage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public PageParam(Integer offsetStart, Integer countPerPage, Integer currentPage){
		this.countPerPage = countPerPage;
		this.offsetStart = offsetStart;
		this.currentPage = currentPage;
	}
	
}
