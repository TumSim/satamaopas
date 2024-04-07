package sh.satamahaku.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
    UserType findByUserType(String userType);
}
