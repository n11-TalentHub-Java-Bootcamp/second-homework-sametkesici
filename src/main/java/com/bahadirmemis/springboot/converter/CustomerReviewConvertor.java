package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.CustomerDto;
import com.bahadirmemis.springboot.dto.CustomerReviewDto;
import com.bahadirmemis.springboot.entity.Customer;
import com.bahadirmemis.springboot.entity.CustomerReview;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerReviewConvertor extends BaseConvertor<CustomerReview,CustomerReviewDto> {

  CustomerReviewDto toDto(CustomerReview customer);

  CustomerReview toEntity(CustomerReviewDto customerReviewDto);

  List<CustomerReview> toEntity(List<CustomerReviewDto> dtoList);

  List<CustomerReviewDto> toDto(List<CustomerReview> entityList);


}
