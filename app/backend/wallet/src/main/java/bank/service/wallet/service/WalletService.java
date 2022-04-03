package bank.service.wallet.service;

import bank.service.wallet.domain.Wallet;
import bank.service.wallet.dto.IncomeDTO;
import bank.service.wallet.dto.WalletDTO;
import bank.service.wallet.exception.InvalidRequest;
import bank.service.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public Wallet create(WalletDTO walletDTO) throws InvalidRequest {
        var found = walletRepository.findByName(walletDTO.getName());

        // validaçao
        if(found != null) throw new InvalidRequest("Nome " + walletDTO.getName() + " já cadastrado");

        var incomeDTO = getIncome(walletDTO.getCdi());
        walletDTO.setDueDate(incomeDTO.getDueDate());
        walletDTO.setCdiPercentage(incomeDTO.getCdiPercentage());

        return walletRepository.insert(walletDTO.toEntity());
    }

    public List<Wallet> getAll(){
        return walletRepository.findAll();
    }

    public void delete(String id){
        walletRepository.deleteById(id);
    }

    public Wallet update(WalletDTO walletDTO){
        var currentWallet = walletRepository.findById(walletDTO.getId()).get();
        var newValue = currentWallet.getValue() + walletDTO.getValue();
        currentWallet.setValue(newValue);
        return walletRepository.save(currentWallet);
    }

    @Autowired
    RestTemplate restTemplate;

    public IncomeDTO getIncome(String cdi) {
        return restTemplate.getForObject("http://income:8080/get/" + cdi, IncomeDTO.class);
    }

}
