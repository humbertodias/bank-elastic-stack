package bank.service.account.repository;

import bank.service.account.domain.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDocumentRepository extends MongoRepository<CustomerDocument,String> {
}
