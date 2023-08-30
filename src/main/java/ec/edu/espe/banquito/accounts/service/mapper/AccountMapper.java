package ec.edu.espe.banquito.accounts.service.mapper;

import ec.edu.espe.banquito.accounts.controller.req.AccountReqDto;
import ec.edu.espe.banquito.accounts.controller.res.AccountResDto;
import ec.edu.espe.banquito.accounts.model.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountResDto toRes(Account account);
    List<AccountResDto> toRes(List<Account> accounts);
    Account toReq(AccountReqDto account);
}
