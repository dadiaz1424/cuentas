package ec.edu.espe.banquito.accounts.service.mapper;

import ec.edu.espe.banquito.accounts.controller.res.AccountTransactionResDto;
import ec.edu.espe.banquito.accounts.model.AccountTransaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-30T10:42:21-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230721-1147, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class AccountTransactionMapperImpl implements AccountTransactionMapper {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<AccountTransactionResDto> toRes(List<AccountTransaction> accountTransactions) {
        if ( accountTransactions == null ) {
            return null;
        }

        List<AccountTransactionResDto> list = new ArrayList<AccountTransactionResDto>( accountTransactions.size() );
        for ( AccountTransaction accountTransaction : accountTransactions ) {
            list.add( toRes( accountTransaction ) );
        }

        return list;
    }

    @Override
    public AccountTransactionResDto toRes(AccountTransaction accountTransaction) {
        if ( accountTransaction == null ) {
            return null;
        }

        AccountTransactionResDto.AccountTransactionResDtoBuilder accountTransactionResDto = AccountTransactionResDto.builder();

        accountTransactionResDto.account( accountMapper.toRes( accountTransaction.getAccount() ) );
        accountTransactionResDto.ammount( accountTransaction.getAmmount() );
        accountTransactionResDto.applyTax( accountTransaction.getApplyTax() );
        accountTransactionResDto.balanceAfterTransaction( accountTransaction.getBalanceAfterTransaction() );
        accountTransactionResDto.bookingDate( accountTransaction.getBookingDate() );
        accountTransactionResDto.creationDate( accountTransaction.getCreationDate() );
        accountTransactionResDto.creditorAccount( accountTransaction.getCreditorAccount() );
        accountTransactionResDto.creditorBankCode( accountTransaction.getCreditorBankCode() );
        accountTransactionResDto.debtorAccount( accountTransaction.getDebtorAccount() );
        accountTransactionResDto.debtorBankCode( accountTransaction.getDebtorBankCode() );
        accountTransactionResDto.id( accountTransaction.getId() );
        accountTransactionResDto.notes( accountTransaction.getNotes() );
        accountTransactionResDto.reference( accountTransaction.getReference() );
        if ( accountTransaction.getState() != null ) {
            accountTransactionResDto.state( accountTransaction.getState().name() );
        }
        if ( accountTransaction.getTransactionType() != null ) {
            accountTransactionResDto.transactionType( accountTransaction.getTransactionType().name() );
        }
        accountTransactionResDto.uniqueKey( accountTransaction.getUniqueKey() );
        accountTransactionResDto.valueDate( accountTransaction.getValueDate() );

        return accountTransactionResDto.build();
    }
}
