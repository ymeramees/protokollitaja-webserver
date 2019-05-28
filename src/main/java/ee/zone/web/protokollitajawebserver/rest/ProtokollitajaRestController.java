package ee.zone.web.protokollitajawebserver.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ee.zone.web.protokollitajawebserver.entity.Competition;
import ee.zone.web.protokollitajawebserver.entity.CompetitionHeader;
import ee.zone.web.protokollitajawebserver.entity.Event;
import ee.zone.web.protokollitajawebserver.entity.EventHeader;
import ee.zone.web.protokollitajawebserver.entity.Competitor;
import ee.zone.web.protokollitajawebserver.repository.CompetitionRepository;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class ProtokollitajaRestController {

    @Autowired
    private CompetitionRepository repository;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd - hh:mm:ss");
    private int numberOfCompetitorRequests = 0;

    // Get list of available competitions (only IDs, names, times and places)
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/competitions")
    public List<CompetitionHeader> getCompetitionsList() {
        List<Competition> competitionsList = repository.findAll(new Sort(Sort.Direction.DESC, "id"));
        System.out.println(simpleDateFormat.format(new Date().getTime()) + " Number of competitions found: " + competitionsList.size());

        List<CompetitionHeader> competitionHeaders = new ArrayList<>();

        for (Competition competition : competitionsList) {
            competitionHeaders.add(new CompetitionHeader(competition.getId(), competition.getCompetitionName(), competition.getTimeAndPlace()));
        }

        return competitionHeaders;
    }

    // Get list of events in one specific competition, by competition ID (only IDs and event names)
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/competitions/{competitionID}")
    public List<EventHeader> getCompetitionEvents(@PathVariable String competitionID) {
        Optional<Competition> oCompetition = repository.findById(competitionID);

        List<EventHeader> eventsList = new ArrayList<>();

        if (oCompetition.isPresent()) {
            Competition competition = oCompetition.get();

            Event[] events = competition.getEvents();

            for (Event event : events) {
                eventsList.add(new EventHeader(event.getId(), event.getEventName()));
            }
        } else {
            System.out.println(simpleDateFormat.format(new Date().getTime()) + " Competition not found: " + competitionID);
        }

        System.out.println(simpleDateFormat.format(new Date().getTime()) + " Number of events found: " + eventsList.size());

        return eventsList;
    }

    // Get data about one event by event ID
    @GetMapping("/competitions/{competitionID}/{eventID}")
    public Competitor[] getEvent(@PathVariable String competitionID, @PathVariable String eventID) {
        Optional<Competition> oCompetition = repository.findById(competitionID);

        if (oCompetition.isPresent()) {
            Competition competition = oCompetition.get();

            Event[] events = competition.getEvents();

            for (Event event : events) {
                if (event.getId().toString().equals(eventID)) {
                    System.out.println(simpleDateFormat.format(new Date().getTime()) + " Number of competitors found: "
                            + event.getCompetitors().length);
                    System.out.println(simpleDateFormat.format(new Date().getTime()) + " Number of times competitors have been asked: "
                            + ++numberOfCompetitorRequests);
                    return event.getCompetitors();
                }
            }
        }
        System.out.println(simpleDateFormat.format(new Date().getTime()) + " Event not found: " + eventID);

        return null;
    }

    // Save a new competition
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/competitions")
    public @ResponseBody
    String saveCompetition(@RequestBody Competition competition, HttpServletResponse response) {
        System.out.println(simpleDateFormat.format(new Date().getTime())
                + " POST: " + competition.getCompetitionName() + ", id: " + competition.getId());

        if (competition.getId() == null) {    //Check if competition with same name already exists

            List<Competition> existingCompetitions = repository.findAll(new Sort(Sort.Direction.DESC, "id"));

            for (Competition existingCompetition : existingCompetitions) {
                if (existingCompetition.getCompetitionName().equals(competition.getCompetitionName())) {
                    System.out.println(simpleDateFormat.format(new Date().getTime())
                            + " Competition with same name already existing!, id: " + existingCompetition.getId());
                    response.setStatus(HttpServletResponse.SC_CONFLICT);
                    return " Competition with same name already existing!, id: " + existingCompetition.getId();
                }
            }
        } else {
            System.out.println(simpleDateFormat.format(new Date().getTime())
                    + " Competition id given! Use PUT request to update an existing competition!");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return " Competition id given! Use PUT request to update an existing competition!";
        }
        repository.save(competition);

        System.out.println(simpleDateFormat.format(new Date().getTime()) + " Competition saved: " + competition.getId());

        response.setStatus(HttpServletResponse.SC_OK);
        return competition.getId();
    }

    // Update an existing competition
    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/competitions")
    public @ResponseBody
    String updateCompetition(@RequestBody Competition competition, HttpServletResponse response) {
        System.out.println(simpleDateFormat.format(new Date().getTime())
                + " PUT: " + competition.getCompetitionName() + ", id: " + competition.getId());

        if (competition.getId() == null) {    //Check if id is given and abort if not
            System.out.println(simpleDateFormat.format(new Date().getTime()) + " Competition id missing!");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Competition id missing! Use POST request for a new competition!";
        }
        repository.save(competition);    // Overwrite old document with a new one as update would be too complex and unnecessary

        System.out.println(simpleDateFormat.format(new Date().getTime()) + " Competition updated: " + competition.getId());

        response.setStatus(HttpServletResponse.SC_OK);
        return competition.getId();
    }
}
