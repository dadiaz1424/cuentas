package ec.edu.espe.banquito.accounts.controller.res;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResDto {
    private ProductAccountType productAccountType;
    private String name;
    private String temporalityAccountStatement;
    private Boolean useCheckbook;
    private Boolean allowOverdraft;
    private Boolean allowTransferences;
    private BigDecimal maxOverdraft;
    private String clientType;
    private BigDecimal minOpeningBalance;
    private BigDecimal minInterest;
    private BigDecimal maxInterest;
    private String state;
    private Boolean valid;
}
