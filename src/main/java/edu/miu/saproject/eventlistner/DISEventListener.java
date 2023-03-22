package edu.miu.saproject.eventlistner;

import edu.miu.saproject.service.StandardDeviationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Author: Kuylim TITH
 * Date: 3/20/2023
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DISEventListener {

    private final StandardDeviationService service;

    @KafkaListener(topics = "${cds.topic.input}", groupId = "${cds.topic.input}")
    public void onDataSourceOne(@Payload Long message, @Headers MessageHeaders headers) {
        log.info("========> Data from data source one: {}", message);
        try {
            service.findDataChange(message);
        } catch (Exception ex) {
            log.info("========> Failed to convert message:", ex);
        }
    }
}
