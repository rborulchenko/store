package store.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import store.model.Principal;

import java.util.stream.Stream;

public interface PrincipalRepository extends CrudRepository<Principal, Long>
{
  Principal findOneByLogin(String login);

  @Query("select c from Principal c where c.login = :login")
  Stream<Principal> findByLoginReturnsStream(@Param("login") String login);
}
