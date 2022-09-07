package com.example.taskmanager.Sample;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/hello")
public class SampleController {

    @PostMapping
    public ResponseEntity<String> sayHello(String name){
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("Hello World " + name);
        // return "Hello World";
    }
}
