package com.remind.core.domain.common.util.FCM;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FCMAsyncUtil {

    private final FirebaseMessaging firebaseMessaging;

    @Async
    public void sendBatchMessage(List<Message> messages) throws {
        firebaseMessaging.sendEach(messages);
    }
}
