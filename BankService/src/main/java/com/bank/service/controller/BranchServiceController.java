/**
 * {@link BranchSeviceController}
 */
package com.bank.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.BranchService;
import com.bank.service.entity.BranchServiceEntity;



@RestController
@RequestMapping("/branches")
public class BranchServiceController {

	@Autowired
	private BranchService branchService;


	/**
	 * @param branchServiceEntity
	 * @return branchServiceEntity1
	 */
	@PostMapping("/")
	public ResponseEntity<?> addBranch(@RequestBody BranchServiceEntity branchServiceEntity) {
		branchServiceEntity=branchService.addBranch(branchServiceEntity);
		return new ResponseEntity<BranchServiceEntity>(branchServiceEntity,HttpStatus.CREATED);
	}

	/**
	 * @return listOfBranch
	 */
	@GetMapping("/")
	public ResponseEntity<List<BranchServiceEntity>> getAllBranch(){
		List<BranchServiceEntity> listOfBranch=branchService.getAllBranch();
		return new ResponseEntity<List<BranchServiceEntity>>(listOfBranch, HttpStatus.OK);
	}

	/**
	 * @param bankId
	 * @return getBankById
	 */
	@GetMapping("/{branchId}")
	public ResponseEntity<?> getBranchById(@PathVariable("branchId") Long branchId){
		BranchServiceEntity getBranchById=branchService.getBranchById(branchId);
		return new ResponseEntity<BranchServiceEntity>(getBranchById, HttpStatus.OK);
	}

	/**
	 * @param bankId
	 */
	@DeleteMapping("/{branchId}")
	public ResponseEntity<Void> deleteById(@PathVariable("branchId") Long branchId){
		branchService.deleteById(branchId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param branchServiceEntity
	 * @return branchServiceEntity1
	 */
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody BranchServiceEntity branchServiceEntity) {
		 branchServiceEntity=branchService.update(branchServiceEntity);
		return new ResponseEntity<BranchServiceEntity>(branchServiceEntity,HttpStatus.OK);

	}

	/**
	 * @param keyword
	 * @return listAllKeyword
	 */
	@GetMapping 
	public  ResponseEntity<?> listAll(@Param("keyword") String q,
			                          @Param("limit") int limit,
			                          @Param("offset") int offset){
		List<BranchServiceEntity> listAllKeyword=branchService.listAll(q,limit,offset);
		System.out.println(listAllKeyword);
		return new ResponseEntity<List<BranchServiceEntity>>(listAllKeyword,HttpStatus.OK);

	}
	
	/**
	 * @param branch
	 * @return branch
	 */
	@GetMapping("/autocomplete") 
	public  ResponseEntity<?> findByBranch(@Param("branch") String q,
			                               @Param("limit") int limit,
			                               @Param("offset") int offset){
		List<BranchServiceEntity> branchName=branchService.findByBranch(q,limit,offset);
		System.out.println(branchName);
		return new ResponseEntity<List<BranchServiceEntity>>(branchName,HttpStatus.OK);

	}
	
	/**
	 * @param city
	 * @return city
	 */
	@GetMapping("/city")
	public ResponseEntity<?> findByCity(@Param("city") String c, 
			                            @Param("limit") int limit,
			                            @Param("offset") int offset){
		List<BranchServiceEntity>  city=branchService.findByCity(c,limit,offset);
		System.out.println(city);
		return new ResponseEntity<List<BranchServiceEntity>>(city,HttpStatus.OK);
	}
	
	/**
	 * @param pagesize, pageno
	 * @return pages
	 */
	@GetMapping("/pages")
	public ResponseEntity<?> pages(@RequestParam(defaultValue="0") Integer pageNo,
			                       @RequestParam(defaultValue="2") Integer pageSize){
		
		 List<BranchServiceEntity> pages = branchService.pages(pageNo, pageSize);
		
		return new ResponseEntity<List<BranchServiceEntity>>(pages,HttpStatus.OK);
}

	
}
