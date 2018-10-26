package de.holisticon.zeitzuhelfen.controller;

import de.holisticon.zeitzuhelfen.domain.TimeDonation;
import de.holisticon.zeitzuhelfen.domain.TimeDonationRepository;
import de.holisticon.zeitzuhelfen.dto.HelpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/donate")
@RequiredArgsConstructor
public class DonateController {

    private final TimeDonationRepository timeDonationRepository;

    @PutMapping
    public void create(@RequestBody HelpDTO helpDTO) {
        timeDonationRepository.save(TimeDonation.fromDto(helpDTO));
    }

    @GetMapping
    public List<HelpDTO> get() {
        return timeDonationRepository.findAll().stream().map(HelpDTO::fromTimeDonation).collect(Collectors.toList());
    }
}
