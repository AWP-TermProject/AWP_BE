package buildup.backend.usersservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path="user")
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {
}
