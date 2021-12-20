package com.bahadirmemis.springboot.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
    name = "CUSTOMER_REVIEW"
)
public class CustomerReview {

  @Id
  @GeneratedValue(generator = "generator")
  @SequenceGenerator(name = "generator", sequenceName = "CUSTOMER_REVIEW_ID_SEQ" )
  @Column(nullable = false , name = "ID")
  private Long id;

  @Column(length = 500)
  private String review;

  @Temporal(TemporalType.TIMESTAMP)
  private Date reviewDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      foreignKey = @ForeignKey(name = "FK_CustomerReview_User_Id")
  )
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      foreignKey = @ForeignKey(name = "FK_CustomerReview_Product_Id")
  )
  private Urun product;

}
