package ec.edu.espe.banquito.accounts.repository;

import ec.edu.espe.banquito.accounts.model.AccountInterestAccrued;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInterestAccruedRepository extends JpaRepository<AccountInterestAccrued,Integer> {
}
