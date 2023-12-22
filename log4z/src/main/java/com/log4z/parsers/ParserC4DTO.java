package com.log4z.parsers;

import com.log4z.parsers.objects.ParserDTO;
import com.log4z.parsers.objects.ParserObjectInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParserC4DTO extends ParserDTO implements ParserObjectInterface {

    public String date;
    public String target;
    public String item;
    public String eventType;
    public String action;

    @Override
    public void ParseInformation() {
        this.information = "<b>Player: </b>" + nickname +
                "<br><b>SteamID: </b>" + steamId +
                "<br><b>Date: </b>" + date +
                "<br><b>Event Type: </b>" + eventType +
                "<br><b>Target: </b>" + target;
    }

    @Override
    public void ParseIconURL() {
        switch (eventType) {
            case "PLACED" ->
                    this.iconUrl = "/images/icons/c4/c4-green-icon.svg";

            case "ARMED" ->
                    this.iconUrl = "/images/icons/c4/c4-yellow-icon.svg";

            case "EXPLODED" ->
                    this.iconUrl = "/images/icons/c4/c4-orange-icon.svg";

            case "DESTROYED" ->
                    this.iconUrl = "/images/icons/c4/c4-red-icon.svg";

            default ->
                    this.iconUrl = "/images/icons/c4/c4-blue-icon.svg";

        }
    }

    @Override
    public void ParseAll() {
        this.ParseInformation();
        this.ParseIconURL();
    }
}
