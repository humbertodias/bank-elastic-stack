package bank.service.account.controller;

import bank.service.account.exception.InvalidRequest;
import bank.service.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bank.service.account.dto.CustomerDTO;

@RestController
@RequestMapping("customer")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @PostMapping(path = "create-new")
  public ResponseEntity<?> post(@RequestBody CustomerDTO dto) throws InvalidRequest {

    var inserted = customerService.create(dto);
    return (inserted != null) ? ResponseEntity.status(204).build() : ResponseEntity.badRequest().build();

  }

}
