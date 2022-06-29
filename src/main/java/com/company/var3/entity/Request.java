package com.company.var3.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "REQUEST", indexes = {
        @Index(name = "IDX_REQUEST_EXECUTOR_ID", columnList = "EXECUTOR_ID"),
        @Index(name = "IDX_REQUEST_INITIATOR_ID", columnList = "INITIATOR_ID")
})
@Entity
public class Request {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "EXECUTOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User executor;

    @Column(name = "STATUS")
    private String status;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @JoinColumn(name = "INITIATOR_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Initiator initiator;

    public Initiator getInitiator() {
        return initiator;
    }

    public void setInitiator(Initiator initiator) {
        this.initiator = initiator;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status == null ? null : StatusEnum.fromId(status);
    }

    public void setStatus(StatusEnum status) {
        this.status = status == null ? null : status.getId();
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}