package bank.service.account.service;

import bank.service.account.exception.InvalidRequest;
import bank.service.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.service.account.domain.Customer;
import bank.service.account.dto.CustomerDTO;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  public Customer create(CustomerDTO dto) throws InvalidRequest {

    var found = customerRepository.findByEmail(dto.getEmail());

    if (found != null)
      throw new InvalidRequest("Email " + dto.getEmail() + "Já cadastrado!");

    return customerRepository.insert(dto.toEntity());

  }

}
