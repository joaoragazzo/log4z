package com.log4z.parsers;

import com.log4z.parsers.dto.ParserC4DTO;
import com.log4z.parsers.dto.ParserDTO;
import com.log4z.utils.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Getter
@Setter
public class C4Parser implements Parser {

    private final Pattern pattern = Pattern.compile(RegexBook.C4Regex);

    @Override
    public List<ParserDTO> parse(String log) {
        String[] lines = log.split("\n");
        List<ParserDTO> parserC4DTOS = new ArrayList<>();

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String dateTime = matcher.group(1);
                String eventType = matcher.group(2);
                String action = matcher.group(4).trim();
                String item = matcher.group(5).trim();
                String x = matcher.group(6);
                String y = matcher.group(7);
                String z = matcher.group(8);
                String target = matcher.group(9);
                String playerName = matcher.group(10);
                String playerID = matcher.group(11);

                ParserC4DTO parserC4DTO = new ParserC4DTO();

                parserC4DTO.setAction(action);
                parserC4DTO.setItem(item);
                parserC4DTO.setSteamId("76" + playerID);
                parserC4DTO.setDate(DateConverter.normalizeDateString(dateTime));
                parserC4DTO.setEventType(eventType);
                parserC4DTO.setTarget(target);
                parserC4DTO.setNickname(playerName);
                parserC4DTO.setX(Float.parseFloat(x));
                parserC4DTO.setY(Float.parseFloat(y));
                parserC4DTO.setZ(Float.parseFloat(z));

                parserC4DTO.parseAll();
                parserC4DTOS.add(parserC4DTO);
            }
        }

        return parserC4DTOS;
    }

    @Override
    public boolean check(String log) {
        String[] lines = log.split("\n");
        return pattern.matcher(lines[0]).find();
    }
}
