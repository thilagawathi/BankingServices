/**
 * {@link BranchServiceRepository}
 */
package com.bank.service.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bank.service.entity.BranchServiceEntity;



@Repository
public interface BranchServiceRepository extends JpaRepository<BranchServiceEntity, Long> {

	@Query("select b from BranchServiceEntity b where b.branch like %?1%"
			+ "OR b.ifsc like %?1%"
			+ "OR b.address like %?1%"
			+ "OR b.city like %?1%"
			+ "OR b.district like %?1%"
			+ "OR b.state like %?1% order by b.ifsc")
	public List<BranchServiceEntity> findKey(@Param("name") String q, Pageable pageable);

	 
	@Query("select b from BranchServiceEntity b where b.branch like %?1% order by b.ifsc")
	public List<BranchServiceEntity> findByBranch(@Param("branch") String q,Pageable pageable);

	@Query("select b from BranchServiceEntity b where b.city like %?1%")
	List<BranchServiceEntity> findByCity(@Param("city") String c,Pageable pageable);

}
