package repository;

import model.AssociatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by starrylemon on 2017/3/5.
 */

@Repository
public interface AssociatorRepository extends JpaRepository<AssociatorEntity,Integer> {

    @Modifying
    @Query("update AssociatorEntity associator set associator.balace = ?1 where associator.aid= ?2")
    int setBalance(double num, int id);

    @Modifying
    @Query("update AssociatorEntity associator set associator.point = ?1 where associator.aid= ?2")
    int setPoint(int point, int id);

    @Modifying
    @Query("update AssociatorEntity associator set associator.level = ?1 where associator.aid= ?2")
    int setLevel(int level, int id);

    @Modifying
    @Query("update AssociatorEntity associator set associator.status = ?1 where associator.aid= ?2")
    int setStatus(String status, int id);

    @Modifying
    @Query("update AssociatorEntity user set user.name=:userName, user.icard=:icard, user.phone=:phone, " +
            "user.password=:password,user.status=:status where user.id=:id")
    void updateUser(@Param("userName") String userName, @Param("icard") String icard,
                    @Param("phone") String phone, @Param("password") String password,
                    @Param("status")String status,@Param("id") Integer id);
}
