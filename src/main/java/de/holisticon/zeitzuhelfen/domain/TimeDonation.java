package de.holisticon.zeitzuhelfen.domain;

import de.holisticon.zeitzuhelfen.dto.HelpDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TimeDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column
    private Date start;

    @Column
    private Date end;

    @Column
    private String remarks;

    @OneToMany(mappedBy = "donation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Requirement> requirements;

    public static TimeDonation fromDto(HelpDTO dto) {
        TimeDonation timeDonation = TimeDonation.builder()
                .id(dto.getId())
                .start(dto.getFrom())
                .end(dto.getTo())
                .remarks(dto.getRemarks())
                .requirements(dto.getRequirementsList().stream().map(r -> Requirement.builder()
                        .requirement(r.name())
                        .build()).collect(Collectors.toSet())).build();

       timeDonation.getRequirements().forEach(r -> r.setDonation(timeDonation));

        return timeDonation;
    }
}
