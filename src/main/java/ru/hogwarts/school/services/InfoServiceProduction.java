package ru.hogwarts.school.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceProduction implements InfoService{
    @Value("${server.port}")
    private int port;

    public int getPort() {

        return port;
    }

}
