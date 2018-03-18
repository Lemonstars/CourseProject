package repository;

import model.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by starrylemon on 2017/3/9.
 */

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity,Integer>{


    @Modifying
    @Query("update BranchEntity branch set branch.icard = ?1,branch.address=?2,branch.name=?3," +
            "branch.freeNumber=?4,branch.reserveNumber=?5,branch.useNumber=?6 where branch.id= ?7")
    void modifyContentById(String newIcard,String newCity,String newAddress,int newNumOfRoom,int reserve,int use,int id);

}
