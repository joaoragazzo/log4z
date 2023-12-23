package com.log4z.parsers;

import com.log4z.parsers.dto.AccessLockDTO;
import com.log4z.parsers.dto.ParserDTO;
import com.log4z.utils.DateConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessLockParser implements Parser {

    private final Pattern patternHeader = Pattern.compile(RegexBook.AccessLockHeader);
    private final Pattern patternDate = Pattern.compile(RegexBook.DefaultDateHeader);
    private final Pattern patternBody = Pattern.compile(RegexBook.AccessLockBody);


    @Override
    public List<ParserDTO> parse(String log) {
        String[] lines = log.split("\n");
        List<ParserDTO> parserDTOS = new ArrayList<>();

        String day = "01";
        String month = "01";
        String year = "2000";

        for (String line: lines ) {

            AccessLockDTO accessLockDTO = new AccessLockDTO();
            Matcher matcherDate = patternDate.matcher(line);
            Matcher matcherBody = patternBody.matcher(line);

            if(matcherDate.find()) {
                month = matcherDate.group(1);
                day = matcherDate.group(2);
                year = matcherDate.group(3);
            }

            else if(matcherBody.find()) {
                String hour = matcherBody.group(1);
                String minute = matcherBody.group(2);
                String seconds = matcherBody.group(3);

                accessLockDTO.setDate(DateConverter.normalizeDateString(day + "/" + month + "/" + year + "-" + hour + ":" + minute + ":" + seconds));
                accessLockDTO.setNickname(matcherBody.group(4));
                accessLockDTO.setSteamId(matcherBody.group(5));
                accessLockDTO.setX(Float.parseFloat(matcherBody.group(6)));
                accessLockDTO.setY(Float.parseFloat(matcherBody.group(7)));
                accessLockDTO.setZ(Float.parseFloat(matcherBody.group(8)));
                accessLockDTO.action = matcherBody.group(9);

                accessLockDTO.parseAll();
                parserDTOS.add(accessLockDTO);
            }

        }

        return parserDTOS;

    }


    @Override
    public boolean check(String log) {
        String[] lines = log.split("\n");
        return patternHeader.matcher(lines[0]).find();
    }
}
