package ec.edu.espe.banquito.accounts.service.mapper;

import ec.edu.espe.banquito.accounts.controller.res.AccountTransactionResDto;
import ec.edu.espe.banquito.accounts.model.AccountTransaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        AccountMapper.class
})
public interface AccountTransactionMapper {
    List<AccountTransactionResDto> toRes(List<AccountTransaction> accountTransactions);
    AccountTransactionResDto toRes(AccountTransaction accountTransaction);
}
