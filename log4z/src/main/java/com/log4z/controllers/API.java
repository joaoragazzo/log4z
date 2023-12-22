package com.log4z.controllers;

import com.log4z.dto.LogDTO;
import com.log4z.parsers.C4Parser;
import com.log4z.parsers.objects.ParserDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Log4j2
public class API {

    @PostMapping("/parser")
    public List<ParserDTO> c4Parser(@RequestBody LogDTO logDTO) {

        return C4Parser.Parse(logDTO.getLog());
    }



}
