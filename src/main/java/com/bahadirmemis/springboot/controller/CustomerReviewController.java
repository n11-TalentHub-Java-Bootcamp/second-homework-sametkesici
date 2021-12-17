package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.converter.CustomerReviewConvertor;
import com.bahadirmemis.springboot.dto.CustomerReviewDto;
import com.bahadirmemis.springboot.service.entityservice.CustomerReviewService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class CustomerReviewController {

  private final CustomerReviewService customerReviewService;

  private final CustomerReviewConvertor customerReviewConvertor;

  @GetMapping("/{customerId}")
  public List<CustomerReviewDto> findCustomerReviewsByCustomerId(@PathVariable Long customerId) throws Exception {
      return customerReviewConvertor.toDto(customerReviewService.findReviewByCustomerId(customerId));
  }

  @GetMapping("/{productId}")
  public List<CustomerReviewDto> findCustomerReviewByProductId(@PathVariable Long productId) throws Exception {
    return customerReviewConvertor.toDto(customerReviewService.findReviewByProductId(productId));
  }

  @PostMapping("")
  public ResponseEntity<Object> saveCustomerReview(@RequestBody CustomerReviewDto customerReviewDto){

    customerReviewService.saveCustomerReview(customerReviewConvertor.toEntity(customerReviewDto));

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("{id}")
        .buildAndExpand(customerReviewDto.getId())
        .toUri();

    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/{id}")
  public void deleteResponse(@PathVariable Long id){
    customerReviewService.deleteCustomerReview(id);
  }


}
