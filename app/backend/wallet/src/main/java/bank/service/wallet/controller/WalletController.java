package bank.service.wallet.controller;

import bank.service.wallet.dto.WalletDTO;
import bank.service.wallet.service.WalletService;
import bank.service.wallet.exception.InvalidRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
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
    public List<WalletDTO> getAll() {
        return walletService.getAll().stream().map(WalletDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity delete(@PathVariable String id) {
        walletService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="update", method={RequestMethod.OPTIONS})
    public ResponseEntity options(@RequestBody WalletDTO walletDTO) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="update")
    public ResponseEntity put(@RequestBody WalletDTO walletDTO) {
        var updated = walletService.update(walletDTO);
        return (updated != null) ?
                ResponseEntity.status(200).build() :
                ResponseEntity.badRequest().build();
    }

}
