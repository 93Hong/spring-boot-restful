package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/elastic")
public class ElasticController {

    ElasticClient client;

    public ElasticController() throws UnknownHostException {
        client = new ElasticClient();
    }

    @RequestMapping(value = "/")
    public void init() {

    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index() throws IOException {
        client.insertDocument("customer", "external", "4");
    }

    

}
