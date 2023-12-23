package com.log4z.controllers;

import com.log4z.exceptions.LogFormatNotRecognized;
import com.log4z.dto.LogDTO;
import com.log4z.parsers.Parser;
import com.log4z.services.ParserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Log4j2
@AllArgsConstructor
public class API {


    private ParserService service;
    @PostMapping("/parser")
    public ResponseEntity<?> c4Parser(@RequestBody LogDTO logDTO) {
        Parser parser;

        try {
            parser = service.IdentifyRegex(logDTO.getLog());
        } catch (LogFormatNotRecognized e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        return ResponseEntity.ok(parser.parse(logDTO.getLog()));
    }



}
