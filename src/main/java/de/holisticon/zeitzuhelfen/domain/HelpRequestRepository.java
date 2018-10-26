package de.holisticon.zeitzuhelfen.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

    List<HelpRequest> findByStartGreaterThanEqualAndEndLessThanEqual(Date start, Date end);

}
