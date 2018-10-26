package de.holisticon.zeitzuhelfen.controller;

import de.holisticon.zeitzuhelfen.domain.HelpRequest;
import de.holisticon.zeitzuhelfen.domain.HelpRequestRepository;
import de.holisticon.zeitzuhelfen.dto.HelpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/help")
@RequiredArgsConstructor
public class HelpController {

    private final HelpRequestRepository helpRequestRepository;

    @PutMapping
    public void create(@RequestBody HelpDTO helpDTO) {
        helpRequestRepository.save(HelpRequest.fromDto(helpDTO));
    }

    @GetMapping
    public List<HelpDTO> get() {
        return helpRequestRepository.findAll().stream().map(HelpDTO::fromEntity).collect(Collectors.toList());
    }
}
