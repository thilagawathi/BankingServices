package com.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.service.customException.EmptyInputException;
import com.bank.service.customException.ResourceNotFoundException;
import com.bank.service.entity.BranchServiceEntity;
import com.bank.service.page.OffsetLimitRequest;
import com.bank.service.repository.BranchServiceRepository;




@Service
@Transactional
public class BranchService {

	@Autowired
	private BranchServiceRepository branchServiceDao;
	
	/**
	 * 
	 * @param bankServiceEntity
	 * @return entity
	 * @throws EmptyInputException
	 */
	public BranchServiceEntity addBranch(BranchServiceEntity bankServiceEntity) {
		if(bankServiceEntity.getBranch().length()> 0 && bankServiceEntity.getIfsc().length()>0) {
		BranchServiceEntity entity=branchServiceDao.save(bankServiceEntity);
		return entity;
		}else {
			throw new EmptyInputException("601","Input field is empty");
		}
	}
	
	/**
	 * throw ResourceNotFoundException
	 * return allBranch
	 */
	public List<BranchServiceEntity> getAllBranch(){
		List<BranchServiceEntity> allBranch=branchServiceDao.findAll();
		if(allBranch.isEmpty()) 
			throw new ResourceNotFoundException("603","No records found");
		return allBranch;
	}
	
	/**
	 * 
	 * @param bankId
	 * @return bank
	 * @throws ResourceNotFoundException
	 */
	public BranchServiceEntity getBranchById(Long branchId) {
		if(branchServiceDao.findById(branchId).isEmpty()) {
			throw new ResourceNotFoundException("604","Given branchId is not found");
		}
		return branchServiceDao.findById(branchId).get();
	}

	public void deleteById(Long branchId){
		{
			Optional<BranchServiceEntity> branch = branchServiceDao.findById(branchId);

			if(branch.isPresent()) 
			{
				branchServiceDao.deleteById(branchId);
			} else {
				throw new ResourceNotFoundException("605", "Given branchId is not found");
			}
		} 
	}
	
	/**
	 * 
	 * @param keyword
	 * throw ResourceNotFoundException();
	 */
	public List<BranchServiceEntity> listAll(String q, int limit, int offset) {
		Pageable pageable = new OffsetLimitRequest(limit, offset);
		List<BranchServiceEntity> key = branchServiceDao.findKey(q,pageable);
		if(!key.isEmpty()) {
			return branchServiceDao.findKey(q,pageable);
		}else {
			throw new ResourceNotFoundException("606","Search not found");
		}
	}
	
	/**
	 * 
	 * @param branch
	 * throw ResourceNotFoundException();
	 */
	public List<BranchServiceEntity> findByBranch(String q, int limit, int offset) {
		   Pageable pageable = new OffsetLimitRequest(limit, offset);
		List<BranchServiceEntity> branchName = branchServiceDao.findByBranch(q,pageable);
		if(!branchName.isEmpty()) {
			return branchServiceDao.findByBranch(q,pageable);
		}else {
		   throw new ResourceNotFoundException("607","branch not found");
		}

	}

	/**
	 * 
	 * @param bankServiceEntity
	 * @return bank
	 * @throws NoSuchElementException
	 */
	public BranchServiceEntity update(BranchServiceEntity branchServiceEntity) throws NoSuchElementException {

		Optional<BranchServiceEntity> updateBranchServiceEntity= branchServiceDao.findById(branchServiceEntity.getId());

		if(updateBranchServiceEntity.isPresent()) {
			BranchServiceEntity branch=updateBranchServiceEntity.get();
			branch.setBranch(branch.getBranch());
			branch.setIfsc(branch.getIfsc());
			branch.setAddress(branch.getAddress());
			branch.setCity(branch.getCity());
			branch.setDistrict(branch.getDistrict());
			branch.setState(branch.getState());
			branch=branchServiceDao.save(branchServiceEntity);
			return branch;
		}else {
			branchServiceEntity = branchServiceDao.save(branchServiceEntity);

			return branchServiceEntity;
		}
	}
	
	/**
	 * 
	 * @param city
	 * throw ResourceNotFoundException();
	 */

	public List<BranchServiceEntity> findByCity(String c, int limit, int offset) {
	
		Pageable pageable=new OffsetLimitRequest(limit, offset);
		List<BranchServiceEntity> city= branchServiceDao.findByCity(c,pageable);
		if(city !=null) {
		     return branchServiceDao.findByCity(c, pageable);
	}else {
		throw new ResourceNotFoundException("612","city not found");
		}
	}

	/**
	 * 
	 * @param pageno, pagesize
	 * throw ResourceNotFoundException();
	 */
	public List<BranchServiceEntity> pages(Integer pageNo, Integer pageSize) {
	
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		  Page<BranchServiceEntity> pagedResult = branchServiceDao.findAll(paging);
		  
		  if(pagedResult.hasContent()) {
			  return pagedResult.getContent();
		  }else {
			  return new ArrayList<BranchServiceEntity>();
		  }
		
	}

	
}
