package com.lavanderia.inventario.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cliente-service", url="http://localhost:8080")
public interface ClienteFeignClient {

    @GetMapping("/lavanderia/anagrafica/clienti")
    String getCliente();
}
