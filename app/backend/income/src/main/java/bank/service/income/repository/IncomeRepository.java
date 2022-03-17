package bank.service.income.repository;

import bank.service.income.domain.Income;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends MongoRepository<Income,String> {
    Income findByName(String name);
}
