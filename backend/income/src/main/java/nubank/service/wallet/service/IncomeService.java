package nubank.service.wallet.service;

import nubank.service.wallet.domain.Income;
import nubank.service.wallet.dto.IncomeDTO;
import nubank.service.wallet.exception.InvalidRequest;
import nubank.service.wallet.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    public Income create(IncomeDTO incomeDTO) throws InvalidRequest {
        var found = incomeRepository.findByName(incomeDTO.getName());

        // validaçao
        if(found != null) throw new InvalidRequest("Nome " + incomeDTO.getName() + " já cadastrado");

        return incomeRepository.insert(incomeDTO.toEntity());
    }

    public List<Income> getAll(){
        return incomeRepository.findAll();
    }
    public Optional<Income> get(String id){
        return incomeRepository.findById(id);
    }

    public void delete(String id){
        incomeRepository.deleteById(id);
    }

    public Income update(IncomeDTO incomeDTO){
        var entity = incomeDTO.toEntity();
        return incomeRepository.save(entity);
    }

}
