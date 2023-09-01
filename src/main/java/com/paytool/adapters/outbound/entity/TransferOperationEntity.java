package com.paytool.adapters.outbound.entity;

import com.paytool.application.core.domain.enums.TransferOperationStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transfer_operations")
public class TransferOperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long transferOperationId;
    @ManyToOne
    private UserEntity sender;
    @ManyToOne
    private UserEntity receiver;
    private BigDecimal transferOperationValue;
    private Enum<TransferOperationStatus> transferOperationStatus;
    private Date transferDate;

    public TransferOperationEntity() {
    }

    public TransferOperationEntity(Long transferOperationId, UserEntity sender, UserEntity receiver, BigDecimal transferOperationValue, Enum<TransferOperationStatus> transferOperationStatus, Date transferDate) {
        this.transferOperationId = transferOperationId;
        this.sender = sender;
        this.receiver = receiver;
        this.transferOperationValue = transferOperationValue;
        this.transferOperationStatus = transferOperationStatus;
        this.transferDate = transferDate;
    }

    public Long getTransferOperationId() {
        return transferOperationId;
    }

    public void setTransferOperationId(Long transferOperationId) {
        this.transferOperationId = transferOperationId;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public UserEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getTransferOperationValue() {
        return transferOperationValue;
    }

    public void setTransferOperationValue(BigDecimal transferOperationValue) {
        this.transferOperationValue = transferOperationValue;
    }

    public Enum<TransferOperationStatus> getTransferOperationStatus() {
        return transferOperationStatus;
    }

    public void setTransferOperationStatus(Enum<TransferOperationStatus> transferOperationStatus) {
        this.transferOperationStatus = transferOperationStatus;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

}
