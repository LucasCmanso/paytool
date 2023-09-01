package com.paytool.application.ports.inbound;

import com.paytool.application.core.domain.models.TransferOperation;

public interface TransferOperationPort {

    TransferOperation makeTransfer(TransferOperation transferOperation);
    String cancelTransfer(Long transferOperationId);
    TransferOperation getTransferById(Long transferOperationId);
}
