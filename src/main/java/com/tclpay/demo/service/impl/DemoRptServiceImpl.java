/** 
 * Project Name:tclpay-demo 
 * File Name:DemoRptServiceImpl.java 
 * Package Name:com.tclpay.demo.service.impl 
 * Date:2016年11月9日上午10:03:50 
 * Copyright (c) 2016, TCL Pay All Rights Reserved. 
 * 
*/  
  
package com.tclpay.demo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tclpay.demo.mapper.DemoRptMapper;
import com.tclpay.demo.pojo.DemoRptInfo;
import com.tclpay.demo.service.DemoRptService;
import com.tclpay.tpf.mapper.util.PaginationContext;

/** 
 * ClassName:DemoRptServiceImpl <br/> 
 * Function: Demo 报表服务基本信息配置接口实现类 
 * Date:     2016年11月9日 上午10:03:50 <br/> 
 * @author   mingzhong.zheng 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Service
public class DemoRptServiceImpl implements DemoRptService {

	@Autowired
	private DemoRptMapper demoRptMapper;
	
	public DemoRptInfo getDemoRptInfo(String rptCode) throws Exception {
		return demoRptMapper.selectByPrimaryKey(rptCode);
	}

	public void delDemoRptInfo(String rptCode) throws Exception {
		demoRptMapper.deleteByPrimaryKey(rptCode);
	}

	public void addDemoRptInfo(DemoRptInfo record) throws Exception {
		demoRptMapper.insert(record);
	}

	public void saveDemoRptInfo(DemoRptInfo record) throws Exception {
		demoRptMapper.updateByPrimaryKey(record);
	}

	public Page<DemoRptInfo> getDemoRptInfoListPage(Map<String,String> queryObj) throws Exception {
		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
		return demoRptMapper.findDemoRptInfo(queryObj);
	}

}
