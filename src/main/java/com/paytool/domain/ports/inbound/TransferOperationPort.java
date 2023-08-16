package com.paytool.domain.ports.inbound;

import com.paytool.domain.models.TransferOperation;

public interface TransferOperationPort {

    TransferOperation makeTransfer(TransferOperation transferOperation);
    String cancelTransfer(Long transferOperationId);
    TransferOperation getTransferById(Long transferOperationId);
}
