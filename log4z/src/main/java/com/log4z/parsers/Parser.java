package com.log4z.parsers;

import com.log4z.parsers.dto.ParserDTO;

import java.util.List;

public interface Parser {


    List<ParserDTO> parse(String log);

    boolean check(String log);
}
