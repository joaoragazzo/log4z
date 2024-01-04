package com.log4z.parsers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HacksawDTO extends ParserDTO {

    public String initialHp = "0";
    public String damageDone = "0";
    public String action;


    @Override
    public void parseInformation() {
        this.information = "<b>Player: </b>" + nickname +
                "<br><b>SteamID: </b>" + steamId +
                "<br><b>Date: </b>" + date +
                "<br><b>Action: </b> " + action;

        if (action.equals("Raiding"))
                this.information += "<br><b>Damage Done: </b>" + damageDone +
                    "<br><b>Initial Hp: </b>" + initialHp;
    }

    @Override
    public void parseIconURL() {
        switch (action) {
            case "Raiding" -> this.iconUrl = "/images/icons/hacksaw/hacksaw-yellow-icon.svg";
            case "Success" -> this.iconUrl = "/images/icons/hacksaw/hacksaw-red-icon.svg";
        }

    }

}
