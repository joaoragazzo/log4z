package com.log4z.parsers.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParserC4DTO extends ParserAbstractObject implements ParserObjectInterface {

    public Date date;
    public String target;
    public String item;
    public String eventType;
    public String action;
    @Override
    public void ParseInformation() {
        this.information = "<b>Player: </b>" + nickname + "<br><b>SteamID: </b>" + steamId + "<br><b>Date: </b>" + date;
    }
}
