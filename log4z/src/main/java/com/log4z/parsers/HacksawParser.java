package com.log4z.parsers;

import com.log4z.parsers.dto.HacksawDTO;
import com.log4z.parsers.dto.ParserDTO;
import com.log4z.utils.DateConverter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class HacksawParser implements Parser {

    private final Pattern patternHeader = Pattern.compile(RegexBook.HacksawHeader);
    private final Pattern patternDate = Pattern.compile(RegexBook.defaultDateHeader);
    private final Pattern patternBody = Pattern.compile(RegexBook.HacksawBody);
    private final Pattern patternSuccess = Pattern.compile(RegexBook.HacksawBodySuccess);

    @Override
    public List<ParserDTO> parse(String log) {
        String[] lines = log.split("\n");
        List<ParserDTO> parserDTOS = new ArrayList<>();

        String day = "01";
        String month = "01";
        String year = "2000";

        for (String line: lines ) {

            HacksawDTO hacksawDTO = new HacksawDTO();

            Matcher matcherDate = patternDate.matcher(line);
            Matcher matcherBody = patternBody.matcher(line);
            Matcher matcherSuccess = patternSuccess.matcher(line);

            if(matcherDate.find()) {
                month = matcherDate.group(1);
                day = matcherDate.group(2);
                year = matcherDate.group(3);
            }

            else if(matcherSuccess.find()) {
                String hour = matcherSuccess.group(1);
                String minute = matcherSuccess.group(2);
                String seconds = matcherSuccess.group(3);
                hacksawDTO.setDate(DateConverter.normalizeDateString(day + "/" + month + "/" + year + "-" + hour + ":" + minute + ":" + seconds));

                hacksawDTO.setNickname(matcherSuccess.group(4));
                hacksawDTO.setSteamId(matcherSuccess.group(5));
                hacksawDTO.setAction("Success");
                hacksawDTO.setX(Float.parseFloat(matcherSuccess.group(6)));
                hacksawDTO.setY(Float.parseFloat(matcherSuccess.group(7)));
                hacksawDTO.setZ(Float.parseFloat(matcherSuccess.group(8)));


                hacksawDTO.parseAll();
                parserDTOS.add(hacksawDTO);
            }

            else if(matcherBody.find()) {
                String hour = matcherBody.group(1);
                String minute = matcherBody.group(2);
                String seconds = matcherBody.group(3);
                hacksawDTO.setDate(DateConverter.normalizeDateString(day + "/" + month + "/" + year + "-" + hour + ":" + minute + ":" + seconds));

                hacksawDTO.setNickname(matcherBody.group(4));
                hacksawDTO.setSteamId(matcherBody.group(5));
                hacksawDTO.setAction("Raiding");
                hacksawDTO.setX(Float.parseFloat(matcherBody.group(6)));
                hacksawDTO.setY(Float.parseFloat(matcherBody.group(7)));
                hacksawDTO.setZ(Float.parseFloat(matcherBody.group(8)));
                hacksawDTO.setInitialHp(matcherBody.group(9));
                hacksawDTO.setDamageDone(matcherBody.group(10));

                hacksawDTO.parseAll();
                parserDTOS.add(hacksawDTO);
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
