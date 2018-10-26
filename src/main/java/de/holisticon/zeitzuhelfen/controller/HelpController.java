package de.holisticon.zeitzuhelfen.controller;

import de.holisticon.zeitzuhelfen.dto.HelpDTO;
import de.holisticon.zeitzuhelfen.dto.Requirements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/help")
public class HelpController {

    @PutMapping
    public void create(HelpDTO helpDTO) {
        // TODO: 26.10.18
    }

    @GetMapping
    public List<HelpDTO> get() {
        // TODO:
        return Collections.emptyList();
    }
}
