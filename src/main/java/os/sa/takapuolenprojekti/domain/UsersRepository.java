package os.sa.takapuolenprojekti.domain;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
