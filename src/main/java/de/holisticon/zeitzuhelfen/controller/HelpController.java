package de.holisticon.zeitzuhelfen.controller;

import de.holisticon.zeitzuhelfen.domain.HelpRequest;
import de.holisticon.zeitzuhelfen.domain.HelpRequestRepository;
import de.holisticon.zeitzuhelfen.dto.HelpDTO;
import de.holisticon.zeitzuhelfen.dto.Requirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
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
        return helpRequestRepository.findAll().stream().map(HelpDTO::fromHelpRequest).collect(Collectors.toList());
    }

    @GetMapping(path = "match")
    public List<HelpDTO> find(@RequestBody HelpDTO request) {
        List<HelpRequest> possibleMatches = helpRequestRepository.findByStartGreaterThanEqualAndEndLessThanEqual(request.getFrom(), request.getTo());

        return possibleMatches.stream()
                .filter(match -> matchRequirements(match.getRequirements(), request.getRequirementsList()))
                .map(HelpDTO::fromHelpRequest)
                .collect(Collectors.toList());
    }

    private boolean matchRequirements(Set<de.holisticon.zeitzuhelfen.domain.Requirement> neededRequirements, List<Requirement> availableRequirements){
        return true;
    }
}
