package com.log4z.parsers.dto;

public class AttachLockDTO extends ParserDTO {


    @Override
    public void parseInformation() {
        this.information = "<b>Player: </b>" + nickname +
                "<br><b>SteamID: </b>" + steamId +
                "<br><b>Date: </b>" + date +
                "<br><b>Action: </b> The player attached a lock";
    }

    @Override
    public void parseIconURL() {
        this.iconUrl = "/images/icons/lock/lock-green-icon.svg";
    }

}
