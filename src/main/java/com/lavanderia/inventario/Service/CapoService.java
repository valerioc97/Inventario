package com.lavanderia.inventario.Service;

import com.lavanderia.inventario.Repos.CapoRespository;
import com.lavanderia.inventario.feign.ClienteFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CapoService {

    @Autowired
    private CapoRespository capoRespository;

    @Autowired
    private ClienteFeignClient feignClient;

    public String getClienteViaRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/lavanderia/anagrafica/clientiRestTemplate";
        return restTemplate.getForObject(url, String.class);
    }

    public String getClienteViaFeign(){
        return feignClient.getCliente();
    }
}
