package com.bahadirmemis.springboot.dao;

import com.bahadirmemis.springboot.entity.CustomerReview;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReviewDao extends JpaRepository<CustomerReview,Long> {

  public List<CustomerReview> findByCustomerId(Long customerId);

  public List<CustomerReview> findByProductId(Long productId);

}
