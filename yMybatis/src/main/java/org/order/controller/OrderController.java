package org.order.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.order.po.Cart;
import org.order.po.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.order.dao.OrderOperation;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/yMybatis/orders")
public class OrderController {
	@Autowired
	OrderOperation orderOperation;
	
	@RequestMapping(value="/get_all",produces = "application/json; charset=utf-8",method= RequestMethod.POST)
	@ResponseBody
	public Object getAll(ModelMap modelMap, @RequestBody Map<String,String> order) throws IOException {

		List<Object> results=orderOperation.getAll(order.get("nickName"));
		ObjectMapper mapper=new ObjectMapper();
		String ret=mapper.writeValueAsString(results);
		System.out.println("/order/get_all:ORDER:"+ret);
		return ret;
	}
	
	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8", method = {RequestMethod.POST })
	@ResponseBody//警告: No mapping found for HTTP request with URI [/yMybatis/WEB-INF/jsp/cart/add.jsp] in DispatcherServlet with name 'springmvc'
	//这个警告无关紧要: No mapping found for HTTP request with URI [/yMybatis/] in DispatcherServlet with name 'springmvc'
	public String add(ModelMap modelMap, @RequestBody Map<String,String> order) throws IOException {
		String resq=null;
		String id=order.get("orderId");
		String price=order.get("goodPrice");
		String goodName=order.get("goodName");
		String name=order.get("name");
		String url=order.get("goodMainUrl");
		String depart=order.get("depart");

		if(!StringUtils.isEmpty(id)){
			Integer goodId = Integer.valueOf(id);
		}
		if(!StringUtils.isEmpty(price)){
			BigDecimal goodPrice = new BigDecimal(order.get("goodPrice"));
		}
		if(StringUtils.isEmpty(name)){
			return resq="姓名不能为空";
		}
		if(StringUtils.isEmpty(depart)){
			return resq="部门不能为空";
		}
		Order orders=new Order(goodName,url,1,name,depart,order.get("nickName"));
		orderOperation.insert(orders);
		return resq="预订成功";
	}

	@RequestMapping(value = "/del", produces = "application/json; charset=utf-8", method = {RequestMethod.DELETE })
	@ResponseBody//警告: No mapping found for HTTP request with URI [/yMybatis/WEB-INF/jsp/cart/add.jsp] in DispatcherServlet with name 'springmvc'
	//这个警告无关紧要: No mapping found for HTTP request with URI [/yMybatis/] in DispatcherServlet with name 'springmvc'
	public String del(ModelMap modelMap, @RequestBody Map<String,String> order) throws IOException {
		String resq=null;
		Integer orderId=0;
		if(!StringUtils.isEmpty(order.get("orderId"))){
			orderId = Integer.valueOf(order.get("orderId"));
		}
		orderOperation.deleteById(orderId);
		return resq="退订成功";
	}
}
