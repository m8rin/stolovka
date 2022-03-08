package rinat.isangulov.stolovka.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rinat.isangulov.stolovka.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}