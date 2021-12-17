package com.bahadirmemis.springboot.dto;

import com.bahadirmemis.springboot.entity.Customer;
import com.bahadirmemis.springboot.entity.Urun;
import java.util.Date;
import lombok.Data;

@Data
public class CustomerReviewDto {

  private Long id;

  private String review;

  private Date reviewDate;

  private Customer customer;

  private Urun product;

}
