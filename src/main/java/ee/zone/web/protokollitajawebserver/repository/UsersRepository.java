package ee.zone.web.protokollitajawebserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ee.zone.web.protokollitajawebserver.entity.Users;

public interface UsersRepository extends MongoRepository<Users, String> {
	Users findByUsername(String username);
}
