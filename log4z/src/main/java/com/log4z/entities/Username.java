package com.log4z.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Username {

    @Id
    private Integer id;

    private String username;

    @ManyToOne
    @JoinColumn(name="steam64id")
    private SteamID player;
}
