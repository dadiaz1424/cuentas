package ec.edu.espe.banquito.accounts.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCOUNT_CODE", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "UNIQUE_KEY", length = 36, unique = true)
    private String uniqueKey;


    @Column(name = "CODE_INTERNAL_ACCOUNT",length = 8, nullable = false)
    private String codeInternalAccount;
    @Column(name = "CODE_INTERNATIONAL_ACCOUNT", length = 16, nullable = false)
    private String codeInternationalAccount;
    @Column(name = "ACCOUNT_HOLDER_TYPE", length = 3, nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountHolderType accountHolderType;
    @Column(name = "ACCOUNT_HOLDER_CODE", length = 36, nullable = false)
    private String accountHolderCode;
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;
    @Column(name = "TOTAL_BALANCE", precision = 18, scale = 2, nullable = false)
    private BigDecimal totalBalance;
    @Column(name = "AVAILABLE_BALANCE", precision = 18, scale = 2, nullable = false)
    private BigDecimal availableBalance;
    @Column(name = "BLOCKED_BALANCE", precision = 18, scale = 2, nullable = false)
    private BigDecimal blockedBalance;
    @Column(name = "STATE", length = 3, nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(name = "LAST_INTEREST_CALCULATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastInterestCalculationDate;
    @Column(name = "ALLOW_OVERDRAFT", nullable = false)
    private Boolean allowOverdraft;
    @Column(name = "MAX_OVERDRAFT", precision = 18, scale = 2)
    private BigDecimal maxOverdraft;
    @Column(name = "CLOSED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedDate;
    @Column(name = "INTEREST_RATE", precision = 5, scale = 2, nullable = false)
    private BigDecimal interestRate;
    @Column(name = "ACTIVATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate;

    @Column(name = "CLIENT_UK", nullable = true)
    private String clientUk;
    @Column(name = "GROUP_UK", nullable = true)
    private String groupUk;
    @Column(name = "PRODUCT_UK", nullable = true)
    private String productUk;





    @ToString.Exclude
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @ToString.Exclude
    @CreatedDate
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ToString.Exclude
    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @ToString.Exclude
    @LastModifiedDate
    @Column(name = "MODIFIED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ToString.Exclude
    @Column(name = "VALID")
    private Boolean valid;

    public enum AccountHolderType {
        CUS, GRO;
    }

    public enum State {
        INA, ACT, BLO, SUS;
    }


    public Account() {
        this.uniqueKey= UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
