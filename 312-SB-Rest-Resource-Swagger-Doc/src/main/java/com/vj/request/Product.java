package com.vj.request;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement		//mandate to mention if we support XML response format
public class Product {

	private Integer prodId;
	private String prodName;
	private Integer quantity;
	private String prodSize;
	private String prodColor;
	private String paymentType;
	private Long pinCode;;
}
