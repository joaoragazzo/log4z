package com.log4z.controllers;

import com.log4z.parsers.C4Parser;
import com.log4z.utils.DateConverter;
import com.log4z.parsers.objects.ParserC4DTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@Log4j2
public class API {

    @PostMapping("/parser")
    public List<ParserC4DTO> c4Parser(@RequestParam("log") String log) {
        return C4Parser.Parse(log);
    }



}
