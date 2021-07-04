/**
 * {@link BankSeviceEntity}
 */
package com.bank.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bank.service.constants.ColumnConstants;
import com.bank.service.constants.TableConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name=TableConstants.BANKS)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankServiceEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name=ColumnConstants.BANKNAME)
	private String name;


}
