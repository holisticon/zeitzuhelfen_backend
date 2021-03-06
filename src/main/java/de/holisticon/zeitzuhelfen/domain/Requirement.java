package de.holisticon.zeitzuhelfen.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String requirement;

    @Setter
    @ManyToOne
    private HelpRequest request;

    @Setter
    @ManyToOne
    private TimeDonation donation;

}
