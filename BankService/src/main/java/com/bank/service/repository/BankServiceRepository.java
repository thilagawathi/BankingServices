/**
 * {@link BranchServiceRepository}
 */
package com.bank.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.service.entity.BankServiceEntity;

@Repository
public interface BankServiceRepository extends JpaRepository<BankServiceEntity, Long>{

}
