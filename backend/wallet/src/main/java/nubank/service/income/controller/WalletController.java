package nubank.service.income.controller;

import nubank.service.income.domain.Wallet;
import nubank.service.income.dto.WalletDTO;
import nubank.service.income.exception.InvalidRequest;
import nubank.service.income.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping(path = "create-new")
    public ResponseEntity post(@RequestBody WalletDTO walletDTO) throws InvalidRequest {
        var inserted = walletService.create(walletDTO);
        return (inserted != null) ?
                ResponseEntity.status(204).build() :
                ResponseEntity.badRequest().build();

    }

    @GetMapping(path = "get-all")
    public List<WalletDTO> get() {
        return walletService.getAll().stream().map(WalletDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        walletService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity put(@RequestBody WalletDTO walletDTO) {
        var updated = walletService.update(walletDTO);
        return (updated != null) ?
                ResponseEntity.status(200).build() :
                ResponseEntity.badRequest().build();
    }


}
