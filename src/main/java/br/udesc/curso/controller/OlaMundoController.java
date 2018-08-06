package br.udesc.curso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OlaMundoController {

    @GetMapping("/ola")
    public ResponseEntity<String> getOlaMundo() {
        return ResponseEntity.ok("Olá UDESC!");
    }

}
