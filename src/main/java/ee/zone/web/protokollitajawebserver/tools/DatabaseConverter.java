package ee.zone.web.protokollitajawebserver.tools;

import ee.zone.web.protokollitajawebserver.entity.Competition;
import ee.zone.web.protokollitajawebserver.entity.Competitor;
import ee.zone.web.protokollitajawebserver.entity.Event;
import ee.zone.web.protokollitajawebserver.repository.CompetitionRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DatabaseConverter {

    // Covert events' and competitors' id's from ObjectId to String
    public static void convert(CompetitionRepository repository, SimpleDateFormat simpleDateFormat) {
        List<Competition> competitionsList = repository.findAll(new Sort(Sort.Direction.DESC, "id"));
        System.out.println(simpleDateFormat.format(new Date().getTime()) + " Number of competitions found: " + competitionsList.size());

        for (Competition competition : competitionsList) {
            if(competition.getEvents()[0].getId().length() > 3) {
                System.out.println(simpleDateFormat.format(new Date().getTime()) + " saving: " + competition.getCompetitionName() + ", id: " + competition.getId());

                int competitorId = 0;
                int eventId = 0;
                for (Event event : competition.getEvents()) {
                    event.setId("" + ++eventId);
                    for (Competitor competitor : event.getCompetitors()){
                        competitor.setId("" + ++competitorId);
                    }
                }

            }
            repository.save(competition);    // Overwrite old document with a new one as update would be too complex, needs to be done for all to preserve order
        }
    }
}
