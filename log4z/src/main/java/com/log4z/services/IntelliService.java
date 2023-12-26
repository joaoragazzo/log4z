package com.log4z.services;

import com.log4z.repository.ActionRepository;
import com.log4z.repository.SteamIDRepository;
import com.log4z.repository.UsernameRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class IntelliService {

    private SteamIDRepository steamIDRepository;
    private ActionRepository actionRepository;
    private UsernameRepository usernameRepository;

    public void toDocument() {
        return;
    }


}
