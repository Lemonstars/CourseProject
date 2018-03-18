package repository;

import model.CenterPayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/16.
 */

@Repository
public interface Center_payRepository extends JpaRepository<CenterPayEntity,Integer> {

    List<CenterPayEntity> findByType(String type);

    @Modifying
    @Query("update CenterPayEntity center set center.status=?1 where center.id=?2")
    void changeStatus(String status,int id);
}
