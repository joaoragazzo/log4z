package com.log4z.services;

import com.log4z.entities.Action;
import com.log4z.entities.Player;
import com.log4z.entities.Username;
import com.log4z.parsers.dto.ParserDTO;
import com.log4z.repository.ActionRepository;
import com.log4z.repository.SteamIDRepository;
import com.log4z.repository.UsernameRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class IntelliService {

    private final SteamIDRepository steamIDRepository;
    private final ActionRepository actionRepository;
    private final UsernameRepository usernameRepository;

    @Autowired
    public IntelliService(SteamIDRepository steamIDRepository, ActionRepository actionRepository, UsernameRepository usernameRepository) {
        this.usernameRepository = usernameRepository;
        this.actionRepository = actionRepository;
        this.steamIDRepository = steamIDRepository;
    }

    public void toDocument(List<ParserDTO> data) {
        for (ParserDTO information : data) {
            Long steamIdNumber = Long.parseLong(information.steamId);
            Player player = new Player(steamIdNumber, null, null, null);
            insertSteam64id(player);

            Username username = new Username(null, information.nickname, player);
            insertUsername(username);

            Action action = new Action();
            action.setPlayer(player);
            action.setX(information.x);
            action.setY(information.y);
            action.setZ(information.z);
            action.setInformation(information.information);
            action.setIcon_url(information.iconUrl);

            LocalDateTime ldt = LocalDateTime.parse(information.date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            Timestamp timestampSql = Timestamp.valueOf(ldt);

            action.setDatetime(timestampSql);
            action.setKills(null);
            insertAction(action);

        }
    }

    private void insertSteam64id(Player steamID) {
        steamIDRepository.save(steamID);
    }

    private void insertAction(Action action) {

        boolean exists = actionRepository.existsByAll(
                action.getPlayer(),
                action.getX(),
                action.getY(),
                action.getZ(),
                action.getInformation(),
                action.getDatetime(),
                action.getIcon_url()
        );

        if (!exists) {
            actionRepository.save(action);
        }
    }


    private void insertUsername(Username username){

        boolean exists = usernameRepository.existsByPlayerAndUsername(
                username.getPlayer(),
                username.getUsername()
        );


        if (!exists) {
            usernameRepository.save(username);
        }

    }

}
