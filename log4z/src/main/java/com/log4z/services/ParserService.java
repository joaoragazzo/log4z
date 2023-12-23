package com.log4z.services;

import com.log4z.exceptions.LogFormatNotRecognized;
import com.log4z.parsers.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParserService {

    private List<Parser> parsers = Arrays.asList(
            new C4Parser(),
            new HacksawParser(),
            new AttachLockParser(),
            new AccessLockParser(),
            new GarageParser()
    );

    public Parser IdentifyRegex(String log) throws LogFormatNotRecognized {

        for(Parser parser : parsers) {
            if (parser.check(log)) {
                return parser;
            }
        }

        throw new LogFormatNotRecognized("This log format was not recognized.");
    }

}
