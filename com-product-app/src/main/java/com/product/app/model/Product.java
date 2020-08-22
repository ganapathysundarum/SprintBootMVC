package com.product.app.model;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min=5, message="Enter at least 5 characters ..!")
	private String name;	
	private String type;
	private String brand;
	
	@Digits(fraction = 2, integer = 10, message="Enter valid number !")
	private double retailPrice;
	private double weight;
	private String size;
		
	private Date manufactured;
	
	private Date expiry;
	
	protected Product() {		
	}
	
	public Product(String name, String type, String brand, double retailPrice, double weight, String size,
			Date manufactured, Date expiry) {
		super();
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.retailPrice = retailPrice;
		this.weight = weight;
		this.size = size;
		this.manufactured = manufactured;
		this.expiry = expiry;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Date getManufactured() {
		return manufactured;
	}
	public void setManufactured(Date manufactured) {
		this.manufactured = manufactured;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	@Override
	public int hashCode() {
		return Objects.hash(brand, expiry, id, manufactured, name, retailPrice, size, type, weight);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if(!Objects.equals(id, other.id)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", brand=" + brand + ", retailPrice="
				+ retailPrice + ", weight=" + weight + ", size=" + size + ", manufactured=" + manufactured + ", expiry="
				+ expiry + "]";
	}	
	
	
	
}
