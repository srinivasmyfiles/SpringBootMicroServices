package com.vj.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK_STR")
public class BookEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "")
	@GeneratedValue
	@Column(name="BOOK_ID")
	private Integer bookId;
	
	@Column(name="BOOK_NAME")
	private String bookName;
	
	@Column(name="AUTHOR_NAME")
	private String authorName;
	
	@Column(name="BOOK_PRICE")
	private String bookPrice;
	
}
