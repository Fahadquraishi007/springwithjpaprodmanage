package com.te.prodmanageappwithdatajpa.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.te.prodmanageappwithdatajpa.beans.ProductInfoBean;

import lombok.Data;

@Data
@XmlRootElement(name = "response")
@JsonRootName("productResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable {

	@XmlElement
	@JsonProperty
	private int statusCode;
	
	@XmlElement
	@JsonProperty
	private String msg;
	

	@XmlElement
	@JsonProperty
	private String description;
	

	@XmlElement
	@JsonProperty
	private ProductInfoBean productInfoBean;
	
	@XmlElement
	@JsonProperty
	private List<ProductInfoBean> productInfoBeans;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductInfoBean getProductInfoBean() {
		return productInfoBean;
	}

	public void setProductInfoBean(ProductInfoBean productInfoBean) {
		this.productInfoBean = productInfoBean;
	}

	public List<ProductInfoBean> getProductInfoBeans() {
		return productInfoBeans;
	}

	public void setProductInfoBeans(List<ProductInfoBean> productInfoBeans) {
		this.productInfoBeans = productInfoBeans;
	}
	
}
