package com.bahadirmemis.springboot.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(nullable = false , updatable = false)
  private Long id;

  @Column(length = 50)
  private String name;

  @Column(length = 50)
  private String lastName;

  @Column(length = 50)
  private String mail;

  @Column(length = 15)
  private String phoneNumber;

  @Column(length = 20)
  private String userName;

  @OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
  private List<CustomerReview> customerReviews;



}
