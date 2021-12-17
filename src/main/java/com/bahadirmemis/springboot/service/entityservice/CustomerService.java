package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.CustomerDao;
import com.bahadirmemis.springboot.dto.CustomerDto;
import com.bahadirmemis.springboot.entity.Customer;
import com.bahadirmemis.springboot.exception.UserNameAndPhoneNumberIsNotMatchException;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerDao customerDao;


  public List<Customer> findAllCustomers() {
    return customerDao.findAll();
  }

  public Customer findCustomerByUserName(String userName){
    return customerDao.findByUserName(userName);
  }

  public Customer findCustomerById(Long id){

    return  customerDao.findById(id).orElseThrow(EntityNotFoundException::new);

  }

  public Customer findCustomerByPhoneNumber(String phoneNumber)
  {
    return customerDao.findByPhoneNumber(phoneNumber);
  }

  public Customer saveCustomer(Customer customer)
  {
    return customerDao.save(customer);
  }

  public void deleteCustomer(String userName, String phoneNumber) throws Exception {
     Customer customerByUsername = findCustomerByUserName(userName);
     Customer customerByPhoneNumber = findCustomerByPhoneNumber(phoneNumber);

     if(customerByUsername.getId().equals(customerByPhoneNumber.getId())){
       customerDao.delete(customerByUsername);
       System.out.println("Kullanıcı silindi");
     }else{
       throw new UserNameAndPhoneNumberIsNotMatchException(userName + " kullanıcı adi ile " + phoneNumber + " telefon numarası uyuşmamaktadır");
     }
  }

  public Customer updateCustomer(Customer customer){
    return saveCustomer(customer);
  };




}
