package org.order.po;

import java.math.BigDecimal;

public class Order {
	public Order(Integer orderId, String goodName, BigDecimal goodPrice, String goodMainUrl, Integer goodNum, String name, String depart, String nickName) {
		this.orderId = orderId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodMainUrl = goodMainUrl;
		this.goodNum = goodNum;
		this.name = name;
		this.depart = depart;
		this.nickName = nickName;
	}

	String goodName;

	BigDecimal goodPrice;
	String goodMainUrl;
	Integer orderId;
	Integer goodNum;
	String name;
	String depart;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	String nickName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodMainUrl() {
		return goodMainUrl;
	}
	public void setGoodMainUrl(String goodMainUrl) {
		this.goodMainUrl = goodMainUrl;
	}
	public Integer getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}
	public Order(Integer orderId, String goodName, BigDecimal goodPrice, String goodMainUrl, Integer goodNum,String nickName) {
		super();
		this.orderId = orderId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodMainUrl = goodMainUrl;
		this.goodNum = goodNum;
		this.nickName=nickName;
	}
	public Order(Integer orderId, String goodName, BigDecimal goodPrice, String goodMainUrl, Integer goodNum, String name,String depart) {
		super();
		this.orderId = orderId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodMainUrl = goodMainUrl;
		this.goodNum = goodNum;
		this.name=name;
		this.depart=depart;
	}
	public Order( String goodName, String goodMainUrl, Integer goodNum, String name,String depart,String nickName) {
		super();
		this.goodName = goodName;
		this.goodMainUrl = goodMainUrl;
		this.goodNum = goodNum;
		this.name=name;
		this.depart=depart;
		this.nickName=nickName;
	}
}
