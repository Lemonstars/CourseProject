package service.implement;

import model.AssociatorEntity;
import model.ReserveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AssociatorRepository;
import repository.ReserveRepository;
import service.ReserveInforService;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/12.
 */

@Service
public class ReserveInforServiceImp implements ReserveInforService {

    @Autowired
    ReserveRepository reserveRepository;
    @Autowired
    AssociatorRepository associatorRepository;

    @Override
    public List<ReserveEntity> getReserveInforById(String id) {
        AssociatorEntity associatorEntity=associatorRepository.findOne(Integer.parseInt(id));
        List<ReserveEntity> result=reserveRepository.getReserveListByAssociator(associatorEntity);

        return result;
    }

    @Override
    public void deleteReserveInfor(int id) {
        reserveRepository.delete(id);
    }
}
