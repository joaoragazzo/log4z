package com.log4z.parsers;

import com.log4z.parsers.dto.GarageDTO;
import com.log4z.parsers.dto.ParserDTO;
import com.log4z.utils.DateConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GarageParser implements Parser {

    private final Pattern garageHeader = Pattern.compile(RegexBook.GarageHeader);
    private final Pattern garageLocation = Pattern.compile(RegexBook.GarageLocation);
    private final Pattern garageBody = Pattern.compile(RegexBook.GarageParking);

    @Override
    public List<ParserDTO> parse(String log) {
        String[] lines = log.split("\n");
        
        List<ParserDTO> parsersDTOS = new ArrayList<>();

        for (String line : lines ) {
            GarageDTO garageDTO = new GarageDTO();
            Matcher matcherHeader = garageHeader.matcher(line);
            Matcher matcherLocation = garageLocation.matcher(line);
            Matcher matcherBody = garageBody.matcher(line);

            if (matcherHeader.find()) {
                continue;
            }

            if (matcherLocation.find()) {
                garageDTO.setNickname("World");
                garageDTO.setSteamId("None");
                garageDTO.setX(Float.parseFloat(matcherLocation.group(2)));
                garageDTO.setY(Float.parseFloat(matcherLocation.group(3)));
                garageDTO.setZ(Float.parseFloat(matcherLocation.group(4)));
                garageDTO.setVehicle("None");
                garageDTO.setAction("Parking lot successfully spawned");
            }

            else if (matcherBody.find()) {
                garageDTO.setNickname(matcherBody.group(2));
                garageDTO.setSteamId(matcherBody.group(3));
                garageDTO.setAction(matcherBody.group(4));
                garageDTO.setVehicle(matcherBody.group(5));
                garageDTO.setX(Float.parseFloat(matcherBody.group(6)));
                garageDTO.setY(Float.parseFloat(matcherBody.group(7)));
                garageDTO.setZ(Float.parseFloat(matcherBody.group(8)));
            }

            if (matcherBody.find() || matcherLocation.find()) {
                garageDTO.setDate(DateConverter.normalizeDateString(matcherBody.group(1)));
                garageDTO.parseAll();
                parsersDTOS.add(garageDTO);
            }
        }

        return parsersDTOS;
    }

    @Override
    public boolean check(String log) {
        String[] lines = log.split("\n");
        return garageHeader.matcher(lines[0]).find();
    }
}
