
/**
 * {@link BankServiceController}
 */
package com.bank.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.BankService;
import com.bank.service.entity.BankServiceEntity;

@RestController
@RequestMapping("/Banks")
public class BankServiceController {

	@Autowired
	private BankService bankService;

	/**
	 * 
	 * Create Bank name
	 * @param bankServiceEntity
	 */
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody BankServiceEntity bankServiceEntity){
		bankServiceEntity = bankService.create(bankServiceEntity);
		return new ResponseEntity<BankServiceEntity>(bankServiceEntity,HttpStatus.CREATED);
	}

	/**
	 * 
	 * Get all bank names
	 * @return All bank
	 */
	@GetMapping("/")
	public ResponseEntity<List<BankServiceEntity>> getAllBank(){
		List<BankServiceEntity> listOfBank=bankService.getAllBank();
		return new ResponseEntity<List<BankServiceEntity>>(listOfBank,HttpStatus.OK);
	}

	/**
	 * 
	 * @param bankid
	 * @return getBankById
	 */
	@GetMapping("/{bankid}")
	public ResponseEntity<?> getBankById(@PathVariable("bankid") Long bankid){
		BankServiceEntity getBankById=bankService.getBankById(bankid);
		return new ResponseEntity<BankServiceEntity>(getBankById,HttpStatus.OK);

	}

	/**
	 * 
	 * Update Bank name
	 * @param bankServiceEntity
	 */
	@PutMapping("/")
	public ResponseEntity<?> updateBankId(@RequestBody BankServiceEntity bankServiceEntity){
		bankServiceEntity = bankService.updateBankId(bankServiceEntity);
		return new ResponseEntity<BankServiceEntity>(bankServiceEntity,HttpStatus.OK);
	}

	/**
	 * 
	 * Delete Bank name
	 * @param bankId
	 */
	@DeleteMapping("/{bankId}")
	public ResponseEntity<Void> deleteById(@PathVariable("bankId") Long bankId){
		bankService.deleteById(bankId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}








}
