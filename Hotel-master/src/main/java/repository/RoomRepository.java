package repository;

import model.BranchEntity;
import model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by starrylemon on 2017/3/12.
 */

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,Integer> {

    @Query("select room from RoomEntity room where room.branchByHid = ?1 and room.type = ?2")
    RoomEntity getRoom(BranchEntity branchEntity, String type);

    @Modifying
    @Query("update RoomEntity room set room.price=?1 where branchByHid=?2 and type=?3" )
    void setPriceByHid(int price,BranchEntity branchEntity,String type);
}
