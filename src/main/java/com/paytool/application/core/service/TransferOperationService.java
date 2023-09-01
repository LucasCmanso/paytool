package com.paytool.application.core.service;

import com.paytool.application.core.domain.models.TransferOperation;
import com.paytool.application.ports.inbound.TransferOperationPort;
import com.paytool.application.ports.outbound.TransferAuthorizerPort;
import com.paytool.application.ports.outbound.TransferNotificationPort;

import java.math.BigDecimal;

public class TransferOperationService {

    private final TransferOperationPort transferOperationPort;
    private final TransferAuthorizerPort transferAuthorizerPort;
    private final TransferNotificationPort transferNotificationPort;
    private final static String TRANSFER_AUTHORIZER_MESSAGE_OK = "Autorizado";
    private final static String TRANSFER_CANCEL_MESSAGE_OK = "Successfully cancel transfer";


    public TransferOperationService(TransferOperationPort transferOperationPort,
                                    TransferAuthorizerPort transferAuthorizerPort,
                                    TransferNotificationPort transferNotificationPort) {
        this.transferOperationPort = transferOperationPort;
        this.transferAuthorizerPort = transferAuthorizerPort;
        this.transferNotificationPort = transferNotificationPort;
    }

    public TransferOperation makeTransfer(TransferOperation transferOperation) {
        String authorization = transferAuthorizerPort.getAuthorization();
        BigDecimal senderBalance = transferOperation.getSender().getBalance();


        if (!authorization.equalsIgnoreCase(TRANSFER_AUTHORIZER_MESSAGE_OK)
                || senderBalance.compareTo(transferOperation.getTransferOperationValue()) < 0
        ) return null;


        transferOperationPort.makeTransfer(transferOperation);
        transferNotificationPort.sendNotification(transferOperation);

        return transferOperation;
    }

    public String cancelTransfer(TransferOperation transferOperation) {
        String cancelMessage = transferOperationPort.cancelTransfer(transferOperation.getTransferOperationId());

        if (!cancelMessage.equalsIgnoreCase(TRANSFER_CANCEL_MESSAGE_OK)) return null;

        return cancelMessage;
    }

    public TransferOperation getTransfer(Long id) {
        return transferOperationPort.getTransferById(id);
    }
}
