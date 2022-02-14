package nubank.service.wallet.controller;

import nubank.service.wallet.dto.IncomeDTO;
import nubank.service.wallet.exception.InvalidRequest;
import nubank.service.wallet.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @PostMapping(path = "create-new")
    public ResponseEntity post(@RequestBody IncomeDTO incomeDTO) throws InvalidRequest {
        var inserted = incomeService.create(incomeDTO);
        return (inserted != null) ?
                ResponseEntity.status(204).build() :
                ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "get-all")
    public List<IncomeDTO> getAll() {
        return incomeService.getAll().stream().map(IncomeDTO::new).collect(Collectors.toList());
    }

    @GetMapping(path = "get/{id}")
    public ResponseEntity<IncomeDTO> get(@PathVariable String id) {
        var opt = incomeService.get(id);
        if (opt.isPresent()) return ResponseEntity.ok(new IncomeDTO(opt.get()));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        incomeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "update")
    public ResponseEntity put(@RequestBody IncomeDTO incomeDTO) {
        var updated = incomeService.update(incomeDTO);
        return (updated != null) ?
                ResponseEntity.status(200).build() :
                ResponseEntity.badRequest().build();
    }


}
