package ru.hogwarts.school.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!production")
public class InfoServiceNotProduction implements InfoService{

    @Override
    public int getPort() {
        return 4555;
    }
}
