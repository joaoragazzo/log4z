package com.log4z.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class SteamID {

    @Id
    private Long steam64id;

    @OneToMany(mappedBy = "player")
    private List<Action> actions;

    @OneToMany(mappedBy = "player")
    private List<Username> usernames;


}
