package ec.edu.espe.banquito.accounts.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DOCUMENT_TYPE")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DOCUMENT_TYPE_CODE", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "APPLICABILITY", length = 3)
    @Enumerated(EnumType.STRING)
    private Applicability applicability;

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
    public enum Applicability {
        CUS, GRO, GCO;
    }
}
