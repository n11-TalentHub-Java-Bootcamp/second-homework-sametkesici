package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.converter.CustomerConvertor;
import com.bahadirmemis.springboot.dto.CustomerDto;
import com.bahadirmemis.springboot.entity.Customer;
import com.bahadirmemis.springboot.service.entityservice.CustomerService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class CustomerController {

  private final CustomerService customerService;

  private final CustomerConvertor customerConvertor;

  @GetMapping("")
  public List<CustomerDto> findAllCustomers(){
    return customerConvertor.toDto(customerService.findAllCustomers());
  }

  @GetMapping("/{userName}")
  public CustomerDto findCustomerByUserName(@PathVariable String userName){
    return customerConvertor.toDto(customerService.findCustomerByUserName(userName));
  }

  @GetMapping("/{phoneNumber}")
  public CustomerDto findCustomerByPhoneNumber(@PathVariable String phoneNumber){
    return customerConvertor.toDto(customerService.findCustomerByPhoneNumber(phoneNumber));
  }

  @PostMapping("")
  public ResponseEntity<Object> saveCustomer(@RequestBody CustomerDto customerDto){

    customerService.saveCustomer(customerConvertor.toEntity(customerDto));

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("{id}")
        .buildAndExpand(customerDto.getId())
        .toUri();

    return ResponseEntity.created(uri).build();


  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable String userName , String phoneNumber) throws Exception {

      customerService.deleteCustomer(userName,phoneNumber);
  }

  @PutMapping("/{id}")
  public void updateCustomer(@RequestBody CustomerDto customerDto){
      customerService.updateCustomer(customerConvertor.toEntity(customerDto));
  }



}
