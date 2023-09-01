package com.paytool.application.ports.outbound;

import com.paytool.application.core.domain.models.TransferOperation;

public interface TransferNotificationPort {
    String sendNotification(TransferOperation transferOperation);
}
