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
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@Table(name = "ACCOUNT_INTEREST_ACCRUED")
public class AccountInterestAccrued {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCOUNT_INTEREST_ACCRUED_CODE", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "UNIQUE_KEY", unique = true)
    private String uniqueKey;
    @Column(name = "EXECUTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executionDate;
    @Column(name = "AMMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal ammount;
    @Column(name = "INTEREST_RATE", precision = 5, scale = 2, nullable = false)
    private BigDecimal interestRate;

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

    public AccountInterestAccrued() {
        this.uniqueKey= UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInterestAccrued that = (AccountInterestAccrued) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
