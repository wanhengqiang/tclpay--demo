/** 
 * Project Name:tclpay-demo 
 * File Name:DemoRptService.java 
 * Package Name:com.tclpay.demo.service 
 * Date:2016年11月8日下午6:25:14 
 * Copyright (c) 2016, TCL Pay All Rights Reserved. 
 * 
*/  
  
package com.tclpay.demo.service;

import java.util.Map;

import com.github.pagehelper.Page;
import com.tclpay.demo.pojo.DemoRptInfo;

/** 
 * ClassName:DemoRptService <br/> 
 * Function: Demo 报表服务基本信息配置接口类
 * Date:     2016年11月8日 下午6:25:14 <br/> 
 * @author   mingzhong.zheng 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface DemoRptService {
	
	/**
	 * 
	 * getDemoRptInfo 根据报表编码查询对应的报表记录
	 * @param rptCode 报表编码
	 * @return
	 * @throws Exception 
	 * DemoRptInfo
	 * @exception 
	 * @since  1.0.0
	 */
	public DemoRptInfo getDemoRptInfo(String rptCode) throws Exception;
	/**
	 * 
	 * delDemoRptInfo 根据主键值报表编码删除对应的记录
	 * @param rptCode 报表
	 * @throws Exception 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void delDemoRptInfo(String rptCode) throws Exception;
	/**
	 * 
	 * addDemoRptInfo新增一条新报表记录
	 * @param record
	 * @throws Exception 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addDemoRptInfo(DemoRptInfo record) throws Exception;
	/**
	 * 
	 * saveDemoRptInfo更新一条报表记录
	 * @param record
	 * @throws Exception 若原有记录不存在可抛出异常
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void saveDemoRptInfo(DemoRptInfo record) throws Exception; 
	/**
	 * 
	 * getDemoRptInfoListPage根据查询条件获取报表记录带分页
	 * @param queryObj
	 * @return
	 * @throws Exception 
	 * Page<DemoRptInfo>
	 * @exception 
	 * @since  1.0.0
	 */
	public Page<DemoRptInfo> getDemoRptInfoListPage(Map<String,String> queryObj) throws Exception; 
}
