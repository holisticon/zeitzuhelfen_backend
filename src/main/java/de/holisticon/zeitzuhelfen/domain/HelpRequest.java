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
public class HelpRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column
    private String topic;

    @Column
    private Date start;

    @Column
    private Date end;

    @OneToMany(mappedBy = "request")
    private Set<Requirement> requirements;

    public static HelpRequest fromDto(HelpDTO dto) {
        return HelpRequest.builder()
                .topic(dto.getTopic())
                .start(dto.getFrom())
                .end(dto.getTo())
                .requirements(dto.getRequirementsList().stream().map(r -> Requirement.builder()
                        .requirement(r.name())
                        .build()).collect(Collectors.toSet()))
                .build();
    }
}
