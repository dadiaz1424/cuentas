package ec.edu.espe.banquito.accounts.controller.res;

import ec.edu.espe.banquito.accounts.model.Account;
import ec.edu.espe.banquito.accounts.model.AccountTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountTransactionResDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String uniqueKey;
    private String transactionType;
    private String reference;
    private BigDecimal ammount;
    private BigDecimal balanceAfterTransaction;
    private String creditorBankCode;
    private String creditorAccount;
    private String debtorBankCode;
    private String debtorAccount;
    private Date creationDate;
    private Date bookingDate;
    private Date valueDate;
    private Boolean applyTax;
    private String state;
    private String notes;

    private AccountResDto account;

}
