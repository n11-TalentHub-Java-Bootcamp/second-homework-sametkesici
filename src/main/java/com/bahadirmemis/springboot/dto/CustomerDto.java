package com.bahadirmemis.springboot.dto;

import lombok.Data;


@Data
public class CustomerDto {

  private Long id;

  private String name;

  private String lastName;

  private String mail;

  private String phoneNumber;

  private String userName;

}
