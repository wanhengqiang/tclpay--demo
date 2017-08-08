/** 
 * Project Name:tclpay-demo 
 * File Name:DemoController.java 
 * Package Name:com.tclpay.demo.web 
 * Date:2016年11月8日下午5:51:34 
 * Copyright (c) 2016, TCL Pay All Rights Reserved. 
 * 
*/  
  
package com.tclpay.demo.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.tclpay.demo.pojo.DemoRptInfo;
import com.tclpay.demo.service.DemoRptService;
import com.tclpay.tpf.Const;
import com.tclpay.tpf.TpfException;
import com.tclpay.tpf.TpfExceptionDefinition;
import com.tclpay.tpf.mapper.util.PaginationContext;
import com.tclpay.tpf.pojo.TpfUser;
import com.tclpay.tpf.security.FireAuthority;
import com.tclpay.tpf.security.UserContext;
import com.tclpay.tpf.util.StringUtil;

/** 
 * ClassName:DemoController <br/> 
 * Function: 演示对demo_rpt_info表的增删改查
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月8日 下午5:51:34 <br/> 
 * @author   mingzhong.zheng 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@FireAuthority(authorityTypes=Const.AUTH_PUBLIC)
@Controller
@RequestMapping(value = "demo")
public class DemoController {
	@Autowired
	private DemoRptService service;
	
	@RequestMapping(value = "/getRpt/{rptCode}", method = RequestMethod.GET)
	public ModelAndView getRpt(@PathVariable("rptCode") String rptCode) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(StringUtil.isBlank(rptCode)){
			throw new TpfException(TpfExceptionDefinition.ERR_TPF_COMM_PARAM);
		}
		DemoRptInfo demoRptInfo = service.getDemoRptInfo(rptCode);
		mav.addObject(demoRptInfo);
		return mav;
	}
	
	@RequestMapping(value="/getRptPage", method = RequestMethod.GET)
	public ModelAndView queryRptPage(HttpServletRequest  request ,
			@RequestParam( defaultValue=Const.REQUEST_PAGE_CURRENT)Integer curPage,
			@RequestParam( defaultValue=Const.REQUEST_PAGE__SIZE)Integer pageSize) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		PaginationContext.setPageNum(curPage);
		PaginationContext.setPageSize(pageSize);
		String reptName = request.getParameter("reptName");
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("reptName", reptName);
		Page<DemoRptInfo> page = service.getDemoRptInfoListPage( paramMap);
		mav.addObject(Const.RESPONSE_JASON_DATA, page.getResult());
		mav.addObject(Const.RESPONSE_PAGE_TOTAL, page.getTotal());
		return mav;
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public void addDemoRptInfo(DemoRptInfo demoRptInfo) throws Exception{
		TpfUser tpfUser = UserContext.getCurrentUser();
		if(tpfUser != null){
			demoRptInfo.setUpdatedBy(tpfUser.getUserId());
			demoRptInfo.setUpdatedDate(new Date());
		}
		service.addDemoRptInfo(demoRptInfo);;
	}
	
	@RequestMapping(value = "/delete/{rptCode}",method = RequestMethod.DELETE)
	public void delDemoRptInfo(@PathVariable("rptCode")String rptCode) throws Exception{	
		service.delDemoRptInfo(rptCode);	
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
    public void updateDemoRptInfo(DemoRptInfo demoRptInfo) throws Exception{
		TpfUser tpfUser = UserContext.getCurrentUser();
		if(tpfUser != null){
			demoRptInfo.setUpdatedBy(tpfUser.getUserId());
			demoRptInfo.setUpdatedDate(new Date());
		}
    	service.saveDemoRptInfo(demoRptInfo);;
    }
	
	
}
