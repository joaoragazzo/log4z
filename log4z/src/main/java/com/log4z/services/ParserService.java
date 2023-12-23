package com.log4z.services;

import com.log4z.exceptions.LogFormatNotRecognized;
import com.log4z.parsers.C4Parser;
import com.log4z.parsers.HacksawParser;
import com.log4z.parsers.Parser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParserService {

    private C4Parser c4Parser = new C4Parser();
    private HacksawParser hacksawParser = new HacksawParser();

    public Parser IdentifyRegex(String log) throws LogFormatNotRecognized {
        if (c4Parser.check(log)) {
            return c4Parser;
        }

        if (hacksawParser.check(log)) {
            return hacksawParser;
        }

        throw new LogFormatNotRecognized("This log format was not recognized.");
    }

}
