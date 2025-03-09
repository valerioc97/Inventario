package com.lavanderia.inventario.Controller;

import com.lavanderia.inventario.Model.Capo;
import com.lavanderia.inventario.Service.CapoService;
import com.lavanderia.inventario.Service.KafkaProducerService;
import com.lavanderia.inventario.dto.CapoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lavanderia/inventario")
@CrossOrigin(origins = "*")
public class CapiController {


    @Autowired
    private CapoService capoService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/capiFeign")
    public ResponseEntity<String> getCapiFeign(){
        return ResponseEntity.ok(capoService.getClienteViaFeign());
    }

    @GetMapping("/capiRestTemplate")
    public ResponseEntity<String> getCapiRestTemplate(){

        return ResponseEntity.ok(capoService.getClienteViaRestTemplate());
    }

    @PostMapping("/capiKafkaTemplate")
    public ResponseEntity<String> getCapiKafka(@RequestBody String message){
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka");
    }

    @PostMapping("/capiKafkaTemplate1")
    public ResponseEntity<String> getCapiKafka1(@RequestBody CapoDto capoDto, @RequestParam Integer selezionaCoda){
        if(selezionaCoda != null && selezionaCoda == 1){
            kafkaProducerService.sendMessage1(capoDto);
        } else if (selezionaCoda != null && selezionaCoda == 2) {
            kafkaProducerService.sendMessage2(capoDto);
        }

        return ResponseEntity.ok("Message sent to Kafka");
    }
}
