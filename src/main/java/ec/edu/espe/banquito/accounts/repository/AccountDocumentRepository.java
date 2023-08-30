package ec.edu.espe.banquito.accounts.repository;

import ec.edu.espe.banquito.accounts.model.AccountDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDocumentRepository extends JpaRepository<AccountDocument,Integer> {
}
