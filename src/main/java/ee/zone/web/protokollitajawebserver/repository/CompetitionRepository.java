package ee.zone.web.protokollitajawebserver.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ee.zone.web.protokollitajawebserver.entity.Competition;;

public interface CompetitionRepository extends MongoRepository<Competition, String> {
	
	List<Competition> findAll(Sort sort);
	
	@Query(value="{ 'id': ?0 }", fields="{ 'events.competitors.birthYear': 0 }")
	Optional<Competition> findById(String competitionId);
}
