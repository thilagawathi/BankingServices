/**
 * {@link BankSevice}
 */
package com.bank.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.service.customException.EmptyInputException;
import com.bank.service.customException.ResourceNotFoundException;
import com.bank.service.entity.BankServiceEntity;
import com.bank.service.repository.BankServiceRepository;

@Transactional
@Service
public class BankService {
	
	/**
	 * Create bank service
	 * Throw EmptyInput exception
	 */
	@Autowired
	private BankServiceRepository bankServiceRepository;
	
	public BankServiceEntity create(BankServiceEntity bankServiceEntity) {
		if(!bankServiceEntity.getName().isEmpty() && bankServiceEntity.getName().length()>0) {
			return bankServiceRepository.save(bankServiceEntity);
		}else {
			throw new EmptyInputException("608","Please fill bank name");
		}
		
	}

	/**
	 * Get all bank details
	 * Throws ResourceNotFound exception
	 */
	public List<BankServiceEntity> getAllBank() {
		
		List<BankServiceEntity> getAllBank = bankServiceRepository.findAll();
		if(getAllBank.isEmpty())
			throw new ResourceNotFoundException("609", "No Records Found");
		return getAllBank;
	}
	
	/**
	 * 
	 * @param bankid
	 * Throws ResourceNotFound exception
	 */
	public BankServiceEntity getBankById(Long bankid) {
		if(bankServiceRepository.findById(bankid).isEmpty()) {
		throw new ResourceNotFoundException("610", "Bank id not found");
		}else {
	    return bankServiceRepository.findById(bankid).get();
		}
	}
    
	/**
	 * 
	 * @param bankServiceEntity
	 * @throws NoSuchElementException
	 */
	public BankServiceEntity updateBankId(BankServiceEntity bankServiceEntity) throws NoSuchElementException{
		Optional<BankServiceEntity> updateBankId=bankServiceRepository.findById(bankServiceEntity.getId());
		if(updateBankId.isPresent()) {
			BankServiceEntity bank=updateBankId.get();
			bank.setName(bank.getName());
			bank=bankServiceRepository.save(bankServiceEntity);
			return bank;
		}else {
			return bankServiceEntity=bankServiceRepository.save(bankServiceEntity);
		}
	}

	/**
	 * 
	 * @param bankId
	 * Throws ResourceNotFound exception
	 */
	public void deleteById(Long bankId) {
		Optional<BankServiceEntity> deleteById=bankServiceRepository.findById(bankId);
		if(deleteById.isEmpty()) {
			throw new ResourceNotFoundException("611", "Given bank id not found");
		}
		bankServiceRepository.deleteById(bankId);
	}

}
