package com.lavanderia.inventario.Controller;

import com.lavanderia.inventario.Model.Capo;
import com.lavanderia.inventario.Service.CapoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lavanderia/inventario")
@CrossOrigin(origins = "*")
public class CapiController {


    @Autowired
    private CapoService capoService;

    @GetMapping("/capiFeign")
    public ResponseEntity<String> getCapiFeign(){
        return ResponseEntity.ok(capoService.getClienteViaFeign());
    }

    @GetMapping("/capiRestTemplate")
    public ResponseEntity<String> getCapiRestTemplate(){

        return ResponseEntity.ok(capoService.getClienteViaRestTemplate());
    }
}
