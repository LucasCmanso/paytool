package com.paytool.domain.ports.outbound;

import com.paytool.domain.models.TransferOperation;

public interface TransferNotificationPort {
    String sendNotification(TransferOperation transferOperation);
}
