package com.carportal.entity.common;

import com.carportal.config.PrefixedSequenceIdGenerator;
import com.carportal.constants.ApplicationConstants.Sequence;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;
import java.time.Instant;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom-sequence")
  @GenericGenerator(
      name = Sequence.BASE_CUS_SEQ_NAME,
      strategy = Sequence.STRATEGY,
      parameters = {
          @org.hibernate.annotations.Parameter(name = PrefixedSequenceIdGenerator.PREFIX_PARAM, value = "GEN"),
          @org.hibernate.annotations.Parameter(name = PrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAM, value = "%06d")
      }
  )
  @Column(name = "id", updatable = false, nullable = false)
  protected String id;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  protected Instant createdAt;

  @CreatedBy
  @Column(name = "created_by", updatable = false)
  protected String createdBy;

  @LastModifiedDate
  @Column(name = "updated_at")
  protected Instant updatedAt;

  @LastModifiedBy
  @Column(name = "updated_by")
  protected String updatedBy;

  @Version
  @Column(name = "version")
  protected Long version;

  protected abstract String getIdPrefix();

  @PrePersist
  public void prePersist() {
    // Do nothing, but needed to trigger GenericGenerator properly
  }

}
