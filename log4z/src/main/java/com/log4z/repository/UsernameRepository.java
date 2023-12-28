package com.log4z.repository;

import com.log4z.entities.Player;
import com.log4z.entities.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsernameRepository extends JpaRepository<Username, Long> {
    boolean existsByPlayerAndUsername(Player player, String username);

}
