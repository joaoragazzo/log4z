package com.log4z.parsers;

import com.log4z.parsers.dto.AttachLockDTO;
import com.log4z.parsers.dto.ParserDTO;
import com.log4z.utils.DateConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttachLockParser implements Parser {

    private final Pattern patternHeader = Pattern.compile(RegexBook.AttachLockHeader);
    private final Pattern patternBody = Pattern.compile(RegexBook.AttachLockBody);
    private final Pattern patternDate = Pattern.compile(RegexBook.defaultDateHeader);

    @Override
    public List<ParserDTO> parse(String log) {
        String[] lines = log.split("\n");
        List<ParserDTO> parserDTOS = new ArrayList<>();

        String day = "01";
        String month = "01";
        String year = "2000";

        for (String line: lines ) {

            AttachLockDTO attachLockDTO = new AttachLockDTO();

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

                attachLockDTO.setDate(DateConverter.normalizeDateString(day + "/" + month + "/" + year + "-" + hour + ":" + minute + ":" + seconds));
                attachLockDTO.setNickname(matcherBody.group(4));
                attachLockDTO.setSteamId(matcherBody.group(5));
                attachLockDTO.setX(Float.parseFloat(matcherBody.group(6)));
                attachLockDTO.setY(Float.parseFloat(matcherBody.group(7)));
                attachLockDTO.setZ(Float.parseFloat(matcherBody.group(8)));

                attachLockDTO.parseAll();
                parserDTOS.add(attachLockDTO);
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
