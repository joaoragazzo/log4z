package com.log4z.parsers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GarageDTO extends ParserDTO implements ParserDTOInterface {


    public String action;
    public String vehicle;

    @Override
    public void parseInformation() {
        this.information = "<b>Player: </b>" + nickname +
                "<br><b>SteamID: </b>" + steamId +
                "<br><b>Date: </b>" + date +
                "<br><b>Action: </b>" + action +
                "<br><b>Vehicle: </b>" + vehicle;
    }

    @Override
    public void parseIconURL() {
        switch (action) {
            case "Parking lot successfully spawned" -> this.iconUrl = "/images/icons/garage/garage-blue-icon.svg";
            case "Parked out" -> this.iconUrl = "/images/icons/garage/garage-green-icon.svg";
            case "Parked in" -> this.iconUrl = "/images/icons/garage/garage-red-icon.svg";
        }
    }

    @Override
    public void parseAll() {
        parseInformation();
        parseIconURL();
    }
}
