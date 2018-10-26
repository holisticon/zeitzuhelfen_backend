package de.holisticon.zeitzuhelfen.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.holisticon.zeitzuhelfen.domain.HelpRequest;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class HelpDTO {

    List<Requirements> requirementsList;
    private Long id;
    private String topic;
    private Date from;
    private Date to;
    private String remarks;

    @JsonCreator
    public HelpDTO(@JsonProperty("requirementsList") List<Requirements> requirementsList,
                   @JsonProperty("id") Long id,
                   @JsonProperty("topic") String topic,
                   @JsonProperty("from") Date from,
                   @JsonProperty("to") Date to,
                   @JsonProperty("remarks") String remarks) {
        this.requirementsList = requirementsList;
        this.id = id;
        this.topic = topic;
        this.from = from;
        this.to = to;
        this.remarks = remarks;
    }

    public static HelpDTO fromEntity(HelpRequest entity) {
        return HelpDTO.builder()
                .id(entity.getId())
                .topic(entity.getTopic())
                .from(entity.getStart())
                .to(entity.getEnd())
                .requirementsList(entity.getRequirements().stream().map(r -> Requirements.valueOf(r.getRequirement())).collect(Collectors.toList()))
                .build();
    }
}
