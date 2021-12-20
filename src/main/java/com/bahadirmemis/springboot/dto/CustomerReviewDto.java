package com.bahadirmemis.springboot.dto;

import java.util.Date;
import lombok.Data;

@Data
public class CustomerReviewDto {

  private Long id;

  private String review;

  private Date reviewDate;

  private Long customerId;

  private Long productId;

}
