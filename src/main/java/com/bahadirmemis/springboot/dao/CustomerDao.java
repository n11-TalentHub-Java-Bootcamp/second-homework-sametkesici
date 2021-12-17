package com.bahadirmemis.springboot.dao;

import com.bahadirmemis.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

  Customer findByUserName(String userName);

  Customer findByPhoneNumber(String phoneNumber);

}
