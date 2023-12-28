package com.log4z.repository;

import com.log4z.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteamIDRepository extends JpaRepository<Player, Long> {

}
