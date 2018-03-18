package repository;

import model.CheckInEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/12.
 */

@Repository
public interface CheckInRepository extends JpaRepository<CheckInEntity,Integer> {
    List<CheckInEntity> findByAid(int id);

    @Query("select max(checkIn.time) from CheckInEntity checkIn where checkIn.aid=?1")
    String getMaxCheckInDateByUserId(int id);
}
