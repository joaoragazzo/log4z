package com.log4z.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float x;
    private Float y;
    private Float z;

    private String information;

    private String icon_url;
    private Timestamp datetime;

    @ManyToOne
    @JoinColumn(name="author_steam64id")
    private Player player;

    @ManyToOne
    @JoinColumn(name="kills_steam64id")
    private Player kills;



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Action action = (Action) obj;
        return Objects.equals(this.x, action.x) &&
                Objects.equals(this.y, action.y) &&
                Objects.equals(this.z, action.z) &&
                Objects.equals(this.information, action.information) &&
                Objects.equals(this.icon_url, action.icon_url) &&
                Objects.equals(this.datetime, action.datetime) &&
                Objects.equals(this.player, action.player) &&
                Objects.equals(this.kills, action.kills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, information, icon_url, datetime, player, kills);
    }
}
