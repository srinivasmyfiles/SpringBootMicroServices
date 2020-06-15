package com.vj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACTSBOOK")
public class ContactsBookEntity {

	@Id
	@Column(name = "CONT_ID")
	private Integer contactId;

	@Column(name = "CONT_NAME")
	private String contactName;

	@Column(name = "CONT_NUMBER")
	private Long contactNumber;

	@Column(name = "CONT_AGE")
	private Integer contactAge;

	@Column(name = "ACTIVE_SWITCH")
	private String activeSwitch;

}
