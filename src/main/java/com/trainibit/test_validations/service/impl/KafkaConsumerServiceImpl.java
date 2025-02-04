package com.trainibit.test_validations.service.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainibit.test_validations.entity.UserData;
import com.trainibit.test_validations.mapper.UserDataMapper;
import com.trainibit.test_validations.repository.UserDataRepository;
import com.trainibit.test_validations.request.UserDataRequestKafka;
import com.trainibit.test_validations.service.KafkaConsumerService;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService{
    private final String TOPIC = "emails_sent";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    @KafkaListener(topics = TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    public void readMessages(ConsumerRecord<String, String> message) {
        try {
            UserDataRequestKafka userDataRequestKafka = objectMapper.readValue(message.value(), UserDataRequestKafka.class);

            UserData userData = userDataMapper.requestToEntity(userDataRequestKafka);

            userDataRepository.save(userData);
            System.out.printf("Los datos del usuario %s se han guardado correctamente en la base de datos\n", userData.getEmail());

        } catch (Exception e) {
            System.err.println("Error al deserializar el mensaje: " + e.getMessage());
        }
    }
}
