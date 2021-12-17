package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.CustomerDto;
import com.bahadirmemis.springboot.dto.CustomerReviewDto;
import com.bahadirmemis.springboot.entity.Customer;
import com.bahadirmemis.springboot.entity.CustomerReview;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerReviewConvertor extends BaseConvertor<CustomerReview,CustomerReviewDto> {

  CustomerReviewDto toDto(CustomerReview customer);

  @Mapping(source = "customerId" , target = "customer.id")
  @Mapping(source = "productId" , target = "product.id")
  CustomerReview toEntity(CustomerReviewDto customerReviewDto);

  List<CustomerReview> toEntity(List<CustomerReviewDto> dtoList);

  List<CustomerReviewDto> toDto(List<CustomerReview> entityList);


}
