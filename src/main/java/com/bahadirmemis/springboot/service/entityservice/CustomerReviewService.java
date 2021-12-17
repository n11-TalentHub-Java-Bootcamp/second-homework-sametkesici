package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.CustomerDao;
import com.bahadirmemis.springboot.dao.CustomerReviewDao;
import com.bahadirmemis.springboot.entity.Customer;
import com.bahadirmemis.springboot.entity.CustomerReview;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerReviewService {

  private final CustomerReviewDao customerReviewDao;


  public List<CustomerReview> findReviewByCustomerId(Long customerId) throws Exception {

    List<CustomerReview> reviewsByUserId = customerReviewDao.findByCustomerId(customerId);

    if(reviewsByUserId.isEmpty()){
      throw new Exception("kullanıcının yorumu bulunmamaktadır.");
    }else{
      return reviewsByUserId;
    }
  }


  public List<CustomerReview> findReviewByProductId(Long productId) throws Exception {
      List<CustomerReview> reviewsByProductId = customerReviewDao.findByProductId(productId);
      if(reviewsByProductId.isEmpty()){
        throw new Exception("ürün yorumu bulunmamaktadır");
      }else{
        return reviewsByProductId;
      }
  }

  public CustomerReview saveCustomerReview(CustomerReview customerReview){
      return customerReviewDao.save(customerReview);
  }

  public void deleteCustomerReview(Long customerReviewId){
      customerReviewDao.deleteById(customerReviewId);
  }



}
