package com.company.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProductVo {

	private int number; // �ѹ�
	private String productName; // ��ǰ �̸�
	private String brandName; // �귣�� �̸�
	private int category;  // ��ǰ ī�װ�
	private int price; // ��ǰ ����
	private String material; // ��ǰ ����
	private Date registerDate; // ��ǰ �����
	private Map<String,Integer> sizeAndStock = new HashMap<>();;
	//private List<Integer> stock = new ArrayList<>();;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Map<String, Integer> getSizeAndStock() {
		return sizeAndStock;
	}
	public void setSizeAndStock(Map<String, Integer> sizeAndStock) {
		this.sizeAndStock = sizeAndStock;
	}/*
	public List<Integer> getStock() {
		return stock;
	}
	public void setStock(List<Integer> stock) {
		this.stock = stock;
	} */
	
}
