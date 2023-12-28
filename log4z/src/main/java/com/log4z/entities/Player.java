package com.log4z.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    private Long steam64id;

    @OneToMany(mappedBy = "player")
    private Set<Action> actions;

    @OneToMany(mappedBy = "player")
    private Set<Username> usernames;

    @OneToMany(mappedBy = "kills")
    private Set<Action> kills;


}
