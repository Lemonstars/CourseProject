package repository;

import model.ConsumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumeRepository extends JpaRepository<ConsumeEntity,Integer> {

    List<ConsumeEntity> findByAid(int id);

    @Query("select consume from ConsumeEntity consume order by consume.hid")
    List<ConsumeEntity> findOrderByHid();

}
