package com.log4z.repository;

import com.log4z.entities.SteamID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamIDRepository extends JpaRepository<SteamID, Long> {

}
