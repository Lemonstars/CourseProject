package repository;

import model.ChangeInforEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by starrylemon on 2017/3/15.
 */

@Repository
public interface ChangeInfroRepository extends JpaRepository<ChangeInforEntity,Integer> {

    @Modifying
    @Query("update ChangeInforEntity changeInfor set changeInfor.status = ?1 where changeInfor.id= ?2")
    void modifyStatuById(String status,int id);
}
