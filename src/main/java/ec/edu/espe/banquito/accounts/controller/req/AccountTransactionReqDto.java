package ec.edu.espe.banquito.accounts.controller.req;

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
public class AccountTransactionReqDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;


    private String reference;
    private BigDecimal ammount;
    private BigDecimal balanceAfterTransaction;
    private String creditorBankCode;
    private String creditorAccount;
    private String debtorBankCode;
    private String debtorAccount;
    private String transactionType;
    private String notes;


}
