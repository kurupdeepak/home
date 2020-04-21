package dkurup.cameldeveloper.repository;

import dkurup.cameldeveloper.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
