package nubank.service.wallet.service;

import nubank.service.wallet.domain.Wallet;
import nubank.service.wallet.dto.IncomeDTO;
import nubank.service.wallet.dto.WalletDTO;
import nubank.service.wallet.exception.InvalidRequest;
import nubank.service.wallet.repository.WalletRepository;
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
        var currenWallet = walletRepository.findById(walletDTO.getId());
        var newValue = currenWallet.get().getValue() + walletDTO.getValue();

        walletDTO.setValue(newValue);

        var entity = walletDTO.toEntity();
        return walletRepository.save(entity);
    }

    @Autowired
    RestTemplate restTemplate;

    public IncomeDTO getIncome(String cdi) {
        return restTemplate.getForObject("http://income:8080/income/get/" + cdi, IncomeDTO.class);
    }

}
