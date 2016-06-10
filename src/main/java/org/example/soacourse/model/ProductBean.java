package org.example.soacourse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductBean", description = "This is a product entity model")
public class ProductBean {
	@ApiModelProperty(value = "product identifier", required = false)
	long id;
	@ApiModelProperty(value = "product name", required = true)
	String name;
	@ApiModelProperty(value = "product price", required = true)
	double price;
	@ApiModelProperty(value = "product status in the warehouse", 
			allowableValues = "available,pending,sold")
	String status;
	
	public ProductBean() {
		super();
	}
	
	public ProductBean(String name, 
			double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
