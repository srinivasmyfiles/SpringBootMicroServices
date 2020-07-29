package com.vj.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vj.request.Product;
import com.vj.response.Order;

@RestController
public class OrderRestController {

	/**
	 > We need to add Swagger2, Swagger UI dependencies.
	 > We have to configure a Swagger Class to generate our resource class Documentation.
	 > we can access swagger ui using
	 	- server:portno/url/swagger-ui.html
	 	ex : localhost:2525/swagger-ui.html
	 > Default url for documentation in JSON format 
	 	- http://localhost:2525/v2/api-docs ( Check docs-api.json file in this Project)
	 
	 * @param pid
	 * @return
	 */
	@GetMapping(value = { "/getOrder/{prodId}" }, produces = { "application/xml", "application/json" })
	public ResponseEntity<Order> getOrderDetails(@PathVariable("prodId") Integer pid) {
		Product p1 = new Product();
		p1.setProdId(111);
		p1.setProdName("OnePlus-9Pro");
		p1.setProdColor("Matt-Black");
		p1.setQuantity(2);
		p1.setProdSize("5.5 inches");
		p1.setPinCode(500015l);
		p1.setPaymentType("COD");

		Product p2 = new Product();
		p2.setProdId(222);
		p2.setProdName("iPhone12 Pro max");
		p2.setProdColor("Matt-Blue");
		p2.setQuantity(1);
		p2.setProdSize("5.7 inches");
		p2.setPinCode(500015l);
		p2.setPaymentType("COD");

		Order order = new Order();

		if (pid == 111) {
			order.setOrderId("918Q8ZR");
			order.setProdId(p1.getProdId());
			order.setProdName(p1.getProdName());
			order.setQuantity(p1.getQuantity());
			order.setSize(p1.getProdSize());
			order.setColor(p1.getProdColor());
			order.setDeliveryAreaCode(p1.getPinCode());
			order.setOrderStatus("Confirmed-Shipping");
			order.setPayment(p1.getPaymentType());
			return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
		} else if (pid == 222) {
			order.setOrderId("354Q7ZR");
			order.setProdId(p2.getProdId());
			order.setProdName(p2.getProdName());
			order.setQuantity(p2.getQuantity());
			order.setSize(p2.getProdSize());
			order.setColor(p2.getProdColor());
			order.setDeliveryAreaCode(p2.getPinCode());
			order.setOrderStatus("Confirmed-Shipping");
			order.setPayment(p2.getPaymentType());
			return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Order>(order, HttpStatus.EXPECTATION_FAILED);
	}
	
	@PostMapping(value = {"/placeOrder"},
			produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"}
			)
	public ResponseEntity<Order> placeOrderForProduct(@RequestBody Product prod){
		Order order = new Order();
		if(prod.getProdId()!=null) {
			order.setOrderId("354Q7ZR");
			order.setProdId(prod.getProdId());
			order.setProdName(prod.getProdName());
			order.setQuantity(prod.getQuantity());
			order.setSize(prod.getProdSize());
			order.setColor(prod.getProdColor());
			order.setDeliveryAreaCode(prod.getPinCode());
			order.setOrderStatus("Confirmed-Shipping");
			order.setPayment(prod.getPaymentType());
			return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
		}else
			return new ResponseEntity<Order>(order, HttpStatus.EXPECTATION_FAILED);
	}
}
