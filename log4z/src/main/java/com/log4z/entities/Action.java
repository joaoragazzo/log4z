package com.log4z.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="player_action")
public class Action {

    @Id
    private Integer id;

    private Integer x;
    private Integer y;
    private Integer z;

    private String information;
    private String iconUrl;

    @ManyToOne
    @JoinColumn(name="steam64id")
    private SteamID player;


}
