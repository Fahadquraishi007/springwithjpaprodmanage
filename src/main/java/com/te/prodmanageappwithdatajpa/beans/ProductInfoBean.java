package com.te.prodmanageappwithdatajpa.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
@Data
@Entity
@Table(name="product_info")
@XmlRootElement(name="product-info")
@JsonRootName("productInfo")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductInfoBean implements Serializable{
	@Id
	@Column
	@XmlElement
	@JsonProperty
	private int pid;
	
	@Column
	@XmlElement
	@JsonProperty
	private String pname;
	
	@Column
	@XmlElement
	@JsonProperty
	private Date mgDate;
	
	@Column
	@XmlElement
	@JsonProperty
	private Date exDate;
	
	@Column
	@XmlElement
	@JsonProperty
	private int price;
	
	@Column
	@XmlElement
	@JsonProperty
	private int quantity;
	
	@Column
	@XmlElement
	@JsonProperty
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Date getMgDate() {
		return mgDate;
	}

	public void setMgDate(Date mgDate) {
		this.mgDate = mgDate;
	}

	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
