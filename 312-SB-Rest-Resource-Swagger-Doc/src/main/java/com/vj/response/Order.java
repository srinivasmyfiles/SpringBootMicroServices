package com.vj.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement		//mandate to mention if we support XML response format
public class Order {

	private String orderId;
	private String orderStatus;
	private Integer prodId;
	private String prodName;
	private Integer quantity;
	private String color;
	private String size;
	private String Payment;
	private Long deliveryAreaCode;
}
