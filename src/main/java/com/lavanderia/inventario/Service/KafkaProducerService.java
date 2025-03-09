package com.lavanderia.inventario.Service;

import com.lavanderia.inventario.Model.Capo;
import com.lavanderia.inventario.dto.CapoDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, CapoDto> kafkaTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate1;


    public KafkaProducerService(KafkaTemplate<String, CapoDto> kafkaTemplate, KafkaTemplate<String, String> kafkaTemplate1) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplate1 = kafkaTemplate1;
    }

    public void sendMessage(String message) {
        kafkaTemplate1.send("test-topic", message);
    }

    public void sendMessage1(CapoDto message) {
        kafkaTemplate.send("test-topic", message);
    }

    public void sendMessage2(CapoDto message){
        kafkaTemplate.send("SALVA_CAPO", message);
    }
}
