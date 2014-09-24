package com.zliang.mybatch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_A")
public class CustomerA implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 572489469848977035L;

	@Id
	@Column(name="ID")
	@SequenceGenerator(name="CustomerA_Gen",sequenceName="CUSTOMERA_SEQ")
	@GeneratedValue(generator="CustomerA_Gen")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CREDIT")
	private Float credit;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getCredit() {
		return credit;
	}
	public void setCredit(Float credit) {
		this.credit = credit;
	}
}
