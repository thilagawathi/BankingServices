package com.bank.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bank.service.constants.ColumnConstants;
import com.bank.service.constants.TableConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name=TableConstants.BRANCHSERVICE)
@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
public class BranchServiceEntity implements Serializable{


	private static final long serialVersionUID = -1013535652375469569L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=ColumnConstants.ID)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="bankServiceEntity")
    private BankServiceEntity bankServiceEntity;
	
	@Column(name=ColumnConstants.BRANCH)
	private String branch;
	
	@Column(name=ColumnConstants.IFSC_CODE)
	private String ifsc;
	
	@Column(name=ColumnConstants.ADDRESS)
	private String address;
	
	@Column(name=ColumnConstants.CITY)
	private String city;
	
	@Column(name=ColumnConstants.DISTRICT)
	private String district;
	
	@Column(name=ColumnConstants.STATE)
	private String state;
	
}
