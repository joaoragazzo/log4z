package com.log4z.parsers.dto;

public class AccessLockDTO extends ParserDTO implements ParserDTOInterface {

    public String action;

    @Override
    public void parseInformation() {
        this.information = "<b>Player: </b>" + nickname +
                "<br><b>SteamID: </b>" + steamId +
                "<br><b>Date: </b>" + date +
                "<br><b>Action: </b>" + action;
    }

    @Override
    public void parseIconURL() {
        switch (action) {
            case "quick accessed a lock" -> this.iconUrl = "/images/icons/lock/lock-blue-icon.svg";
            case "removed a lock", "attempted to change the passcode to a lock they do not own" -> this.iconUrl = "/images/icons/lock/lock-red-icon.svg";
            case "set a new passcode on lock", "accessed a lock", "changed the passcode on a lock" -> this.iconUrl = "/images/icons/lock/lock-orange-icon.svg";
            case "claimed ownership of a lock" -> this.iconUrl = "/images/icons/lock/lock-yellow-icon.svg";
            case "was added as a guest of a lock" -> this.iconUrl = "/images/icons/lock/lock-green-icon.svg";
        }
    }

    @Override
    public void parseAll() {
        parseInformation();
        parseIconURL();
    }
}
