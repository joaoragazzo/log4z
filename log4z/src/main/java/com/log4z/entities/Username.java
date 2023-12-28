package com.log4z.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "username")
public class Username {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne
    @JoinColumn(name="player_steam64id")
    private Player player;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Username usernameObj = (Username) obj;
        return Objects.equals(id, usernameObj.id) &&
                Objects.equals(username, usernameObj.username) &&
                Objects.equals(player, usernameObj.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, player);
    }
}
