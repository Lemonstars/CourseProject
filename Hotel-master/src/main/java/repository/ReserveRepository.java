package repository;

import model.AssociatorEntity;
import model.ReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/11.
 */
@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity,Integer> {

    @Query("select reserve from ReserveEntity reserve where reserve.associatorByAid  = ?1  ")
    List<ReserveEntity> getReserveListByAssociator(AssociatorEntity associatorEntity);

    @Query("select reserve from ReserveEntity reserve order by branchByHid.id")
    List<ReserveEntity> findOrderByHid();
}
