package nubank.service.income.service;

import nubank.service.income.domain.Wallet;
import nubank.service.income.dto.WalletDTO;
import nubank.service.income.exception.InvalidRequest;
import nubank.service.income.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public Wallet create(WalletDTO walletDTO) throws InvalidRequest {
        var found = walletRepository.findByName(walletDTO.getName());

        // validaçao
        if(found != null) throw new InvalidRequest("Nome " + walletDTO.getName() + " já cadastrado");

        return walletRepository.insert(walletDTO.toEntity());
    }

    public List<Wallet> getAll(){
        return walletRepository.findAll();
    }

    public void delete(String id){
        walletRepository.deleteById(id);
    }

    public Wallet update(WalletDTO walletDTO){
        var entity = walletDTO.toEntity();
        return walletRepository.save(entity);
    }

}
