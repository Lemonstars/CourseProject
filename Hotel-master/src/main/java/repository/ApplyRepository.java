package repository;

import model.ApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by starrylemon on 2017/3/13.
 */

@Repository
public interface ApplyRepository extends JpaRepository<ApplyEntity,Integer> {
    @Modifying
    @Query("update ApplyEntity apply set apply.status = ?1 where apply.id= ?2")
    void modifyStatuById(String status,int id);
}
