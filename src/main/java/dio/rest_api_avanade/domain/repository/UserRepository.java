package dio.rest_api_avanade.domain.repository;

import dio.rest_api_avanade.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccount_Number(String accountNumber);
}
