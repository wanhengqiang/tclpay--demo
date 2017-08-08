/** 
 * Project Name:tclpay-demo 
 * File Name:DemoRptInfo.java 
 * Package Name:com.tclpay.demo.pojo 
 * Date:2016年11月8日下午6:28:32 
 * Copyright (c) 2016, TCL Pay All Rights Reserved. 
 * 
*/

package com.tclpay.demo.pojo;

import java.util.Date;

/**
 * ClassName:DemoRptInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月8日 下午6:28:32 <br/>
 * 
 * @author mingzhong.zheng
 * @version
 * @since JDK 1.7
 * @see
 */
public class DemoRptInfo implements java.io.Serializable {

	private static final long serialVersionUID = -4694901677312996709L;

	private String rptCode;
	private String rptName;
	private String rptDesc;

	private Date updatedDate;

	private String updatedBy;

	public String getRptCode() {
		return rptCode;
	}

	public void setRptCode(String rptCode) {
		this.rptCode = rptCode;
	}

	public String getRptName() {
		return rptName;
	}

	public void setRptName(String rptName) {
		this.rptName = rptName;
	}

	public String getRptDesc() {
		return rptDesc;
	}

	public void setRptDesc(String rptDesc) {
		this.rptDesc = rptDesc;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy == null ? null : updatedBy.trim();
	}
}
