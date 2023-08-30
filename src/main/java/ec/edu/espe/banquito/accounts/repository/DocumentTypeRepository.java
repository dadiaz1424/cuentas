package ec.edu.espe.banquito.accounts.repository;

import ec.edu.espe.banquito.accounts.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType,Integer> {
}
