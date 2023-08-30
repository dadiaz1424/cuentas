package ec.edu.espe.banquito.accounts.controller.res;

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
public class AccountResDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String uniqueKey;
    private String codeInternalAccount;
    private String name;
    private BigDecimal totalBalance;
    private BigDecimal availableBalance;
    private BigDecimal blockedBalance;
    private Date lastInterestCalculationDate;
    private Boolean allowOverdraft;
    private BigDecimal maxOverdraft;

    private String clientUk;

    private String groupUk;
    private String productUk;

}
