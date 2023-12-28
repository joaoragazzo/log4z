package com.log4z.repository;

import com.log4z.entities.Action;
import com.log4z.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {

    @Query("SELECT COUNT(a) > 0 FROM Action a WHERE a.player = :player AND a.x = :x AND a.y = :y AND a.z = :z AND a.information = :information AND a.datetime = :datetime AND a.icon_url = :iconUrl")
    boolean existsByAll(@Param("player") Player player, @Param("x") Float x, @Param("y") Float y, @Param("z") Float z, @Param("information") String information, @Param("datetime") Timestamp datetime, @Param("iconUrl") String iconUrl);

    @Query("SELECT 1")
    boolean test();
}
