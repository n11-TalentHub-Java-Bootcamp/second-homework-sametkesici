package com.bahadirmemis.springboot.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(
    name = "CUSTOMER"
)
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @GeneratedValue(generator = "generator")
  @SequenceGenerator(name = "generator", sequenceName = "CUSTOMER_ID_SEQ" )
  @Id
  @Column(nullable = false , name = "ID")
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
