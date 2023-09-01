package com.paytool.application.core.domain.models;

import com.paytool.application.core.domain.enums.TransferOperationStatus;

import java.math.BigDecimal;
import java.util.Date;

public class TransferOperation {

    private Long transferOperationId;
    private User sender;
    private User receiver;
    private BigDecimal transferOperationValue;
    private Enum<TransferOperationStatus> transferOperationStatus;
    private Date transferDate;

    public TransferOperation(User sender, User receiver, BigDecimal transferOperationValue, Enum<TransferOperationStatus> transferOperationStatus, Date transferDate) {
        this.sender = sender;
        this.receiver = receiver;
        this.transferOperationValue = transferOperationValue;
        this.transferOperationStatus = transferOperationStatus;
        this.transferDate = transferDate;
    }

    public Long getTransferOperationId() {
        return transferOperationId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
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

    @Override
    public String toString() {
        return "{" +
                "transferOperationId=" + transferOperationId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", transferOperationValue=" + transferOperationValue +
                ", transferOperationStatus=" + transferOperationStatus +
                '}';
    }
}
