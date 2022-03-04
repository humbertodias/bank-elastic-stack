package nubank.service.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nubank.service.account.domain.Customer;
import nubank.service.account.dto.CustomerDTO;
import nubank.service.account.exception.InvalidRequest;
import nubank.service.account.repository.CustomerRepository;

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
