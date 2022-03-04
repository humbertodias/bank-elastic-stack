package nubank.service.account.controller;

import nubank.service.account.exception.InvalidRequest;
import nubank.service.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nubank.service.account.dto.CustomerDTO;

@RestController
@RequestMapping("/account/customer")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @PostMapping(path = "create-new")
  public ResponseEntity<?> post(@RequestBody CustomerDTO dto) throws InvalidRequest {

    var inserted = customerService.create(dto);
    return (inserted != null) ? ResponseEntity.status(204).build() : ResponseEntity.badRequest().build();

  }

}
