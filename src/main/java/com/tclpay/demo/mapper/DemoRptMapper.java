/** 
 * Project Name:tclpay-demo 
 * File Name:DemoRptInfoMapper.java 
 * Package Name:com.tclpay.demo.mapper 
 * Date:2016年11月8日上午11:09:10 
 * Copyright (c) 2016, TCL Pay All Rights Reserved. 
 * 
*/  
  
package com.tclpay.demo.mapper;

import java.util.Map;

import com.github.pagehelper.Page;
import com.tclpay.demo.pojo.DemoRptInfo;

/** 
 * ClassName:DemoRptInfoMapper <br/> 
 * Function: DemoRpt 数据库操作mabatis接口
 * Date:     2016年11月8日 上午11:09:10 <br/> 
 * @author   mingzhong.zheng 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface DemoRptMapper {
	int deleteByPrimaryKey(String rptCode);

    int insert(DemoRptInfo record);

    DemoRptInfo selectByPrimaryKey(String rptCode);

    int updateByPrimaryKey(DemoRptInfo record);
    
    Page<DemoRptInfo> findDemoRptInfo(Map<String,String> queryObj);
}
