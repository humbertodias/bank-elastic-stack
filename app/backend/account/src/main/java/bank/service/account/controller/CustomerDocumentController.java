package bank.service.account.controller;

import bank.service.account.dto.CustomerDocumentDTO;
import bank.service.account.exception.InvalidRequest;
import bank.service.account.service.CustomerDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customer-document")
public class CustomerDocumentController {

    @Autowired
    CustomerDocumentService customerDocumentService;

    @PostMapping(path = "create-new")
    public ResponseEntity post(@RequestBody CustomerDocumentDTO dto) throws InvalidRequest {
        var inserted = customerDocumentService.create(dto);
        return (inserted != null) ?
                ResponseEntity.status(204).build() :
                ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "get-all")
    public List<CustomerDocumentDTO> getAll() {
        return customerDocumentService.getAll().stream().map(CustomerDocumentDTO::new).collect(Collectors.toList());
    }

    @GetMapping(path = "get/{id}")
    public ResponseEntity<CustomerDocumentDTO> get(@PathVariable String id) {
        var opt = customerDocumentService.get(id);
        if (opt.isPresent()) return ResponseEntity.ok(new CustomerDocumentDTO(opt.get()));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        customerDocumentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "update")
    public ResponseEntity put(@RequestBody CustomerDocumentDTO incomeDTO) {
        var updated = customerDocumentService.update(incomeDTO);
        return (updated != null) ?
                ResponseEntity.status(200).build() :
                ResponseEntity.badRequest().build();
    }


}
