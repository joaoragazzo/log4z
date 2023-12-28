package com.log4z.controllers;

import com.log4z.exceptions.LogFormatNotRecognized;
import com.log4z.dto.LogDTO;
import com.log4z.parsers.Parser;
import com.log4z.parsers.dto.ParserDTO;
import com.log4z.services.IntelliService;
import com.log4z.services.ParserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Log4j2
public class API {

    private final ParserService parserService;
    private final IntelliService intelliService;

    @Autowired
    public API (ParserService parserService, IntelliService intelliService) {
        this.parserService = parserService;
        this.intelliService = intelliService;
    }


    @PostMapping("/parser")
    public ResponseEntity<?> c4Parser(@RequestBody LogDTO logDTO) {
        Parser parser;

        try {
            parser = parserService.IdentifyRegex(logDTO.getLog());
        } catch (LogFormatNotRecognized e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        List<ParserDTO> response = parser.parse(logDTO.getLog());
        intelliService.toDocument(response);

        return ResponseEntity.ok(response);
    }



}
