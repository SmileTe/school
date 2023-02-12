package ru.hogwarts.school.services;

import org.springframework.beans.factory.annotation.Value;

public class InfoServiceTest implements InfoService{

    private int port = 7442;

    @Override
    public int getPort() {
        return 0;
    }
}
