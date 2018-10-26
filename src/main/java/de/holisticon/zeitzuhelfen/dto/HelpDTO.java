package de.holisticon.zeitzuhelfen.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class HelpDTO {

    private String topic;

    private Date from;

    private Date to;

    private String remarks;

    List<Requirements> requirementsList;
}
