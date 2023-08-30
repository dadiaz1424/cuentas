package ec.edu.espe.banquito.accounts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@Table(name = "ACCOUNT_TRANSACTION")
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCOUNT_TRANSACTION_CODE", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "UNIQUE_KEY",length =255, unique = true)
    private String uniqueKey;
    @Column(name = "TRANSACTION_TYPE", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name = "REFERENCE", length = 100, nullable = false)
    private String reference;
    @Column(name = "AMMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal ammount;
    @Column(name = "BALANCE_AFTER_TRANSACTION", precision = 18, scale = 2, nullable = false)
    private BigDecimal balanceAfterTransaction;
    @Column(name = "CREDITOR_BANK_CODE", length = 100, nullable = true)
    private String creditorBankCode;
    @Column(name = "CREDITOR_ACCOUNT", length = 100, nullable = true)
    private String creditorAccount;
    @Column(name = "DEBTOR_BANK_CODE", length = 100, nullable = true)
    private String debtorBankCode;
    @Column(name = "DEBTOR_ACCOUNT", length = 100, nullable = true)
    private String debtorAccount;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "BOOKING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;
    @Column(name = "VALUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueDate;
    @Column(name = "APPLY_TAX")
    private Boolean applyTax;

    @Column(name = "PARENT_TRANSACTION_CODE")
    private Integer parentTransactionId;

    @ManyToOne
    @JoinColumn(name = "PARENT_TRANSACTION_CODE", nullable = true, updatable = false, insertable = false)
    @ToString.Exclude
    private AccountTransaction parentUK;

    @OneToMany(mappedBy = "parentUK", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AccountTransaction> childrenAccountTransactions;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "NOTES", length = 100, nullable = false)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ACCOUNT_CODE",
            referencedColumnName = "ACCOUNT_CODE",
            nullable = false)
    @ToString.Exclude
    private Account account;

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

    public enum TransactionType {
        ADJUSTMENT, WITHDRAWAL, TRANSFER,PAYMENT,FEE_APPLIED,INTEREST_AP,WITHHOLD_TA,LOAN_FUNDED,LOAN_REPAID;
    }
    public enum State {
        INA, ACT, BLO, SUS;
    }

    public AccountTransaction() {
        this.uniqueKey= UUID.randomUUID().toString();
    }
}
