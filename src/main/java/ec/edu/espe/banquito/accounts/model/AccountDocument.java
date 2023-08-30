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

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@Table(name = "ACCOUNT_DOCUMENT")
public class AccountDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCOUNT_DOCUMENT_CODE", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "GROUP_UK")
    private String groupUK;
    @Column(name = "CLIENT_UK")
    private String clientUK;
    @Column(name = "PRODUCT_ACCOUNT_UK")
    private String productAccountUK;

    @Column(name = "UNIQUE_KEY", unique = true)
    private String uniqueKey;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "URL", length = 250, nullable = false)
    private String url;

    public AccountDocument() {
        this.uniqueKey= UUID.randomUUID().toString();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "DOCUMENT_TYPE_CODE",
            referencedColumnName = "DOCUMENT_TYPE_CODE",
            nullable = false)
    @ToString.Exclude
    private DocumentType documentType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDocument that = (AccountDocument) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
