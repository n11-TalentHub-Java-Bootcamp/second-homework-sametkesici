package com.bahadirmemis.springboot.entity;

import java.util.Date;
import java.util.UUID;
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
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerReview {

  @Id
  @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
  @GeneratedValue(generator = "UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

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
