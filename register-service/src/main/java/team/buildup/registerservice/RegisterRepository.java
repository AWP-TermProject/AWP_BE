package team.buildup.registerservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    // save 메소드
    Register save(Register register);

    // findById 메소드
    Register findById(long id);

    // deleteById 메소드
    void deleteById(long id);
}