package ru.hogwarts.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.services.InfoService;

@RestController
@RequestMapping(value = "/info")
public class InfoController {

    private  InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping(value = "/getPort")
    public int getPort() {

        return infoService.getPort();
    }

    @GetMapping("value-from-formula")
    public int getValueFromFormula() {
        return infoService.getValueFromFormula();
    }
}
