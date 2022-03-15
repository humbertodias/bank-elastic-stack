package bank.service.income.service;

import bank.service.income.exception.InvalidRequest;
import bank.service.income.domain.Income;
import bank.service.income.dto.IncomeDTO;
import bank.service.income.repository.IncomeRepository;
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
