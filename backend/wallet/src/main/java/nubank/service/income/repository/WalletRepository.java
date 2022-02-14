package nubank.service.income.repository;

import nubank.service.income.domain.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends MongoRepository<Wallet,String> {
    Wallet findByName(String name);
}
