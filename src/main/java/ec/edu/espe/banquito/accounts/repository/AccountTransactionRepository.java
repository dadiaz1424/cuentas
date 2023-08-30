package ec.edu.espe.banquito.accounts.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.edu.espe.banquito.accounts.model.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Integer> {
    @Query("select act from AccountTransaction act " +
            "where (act.valid=true) and act.account.uniqueKey=:accountUK")
    List<AccountTransaction> findValidByAccountUniqueKeyOrderByBookingDateDesc(@Param("accountUK") String accountUK);

    List<AccountTransaction> findValidByAccountUniqueKeyAndBookingDateBetweenOrderByBookingDateDesc(String accountUK, Date startDate, Date endDate);

}
