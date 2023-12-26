package com.log4z.repository;

import com.log4z.entities.Username;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernameRepository extends JpaRepository<Username, Long> {

}
