package sh.satamahaku.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface HarbourRepository extends CrudRepository<Harbour, Long>{
    List <Harbour> findByName(String name);
}
