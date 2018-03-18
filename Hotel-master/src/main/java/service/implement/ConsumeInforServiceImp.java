package service.implement;

import model.ConsumeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ConsumeRepository;
import service.ConsumeInforService;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/12.
 */

@Service
public class ConsumeInforServiceImp implements ConsumeInforService {

    @Autowired
    ConsumeRepository consumeRepository;

    @Override
    public List<ConsumeEntity> getConsumeInforByUser(String userId) {
        List<ConsumeEntity> result=consumeRepository.findByAid(Integer.parseInt(userId));
        return result;
    }

    @Override
    public double getSumMoneyByUser(String id) {
        double result=0;
        List<ConsumeEntity> consumeEntityList=consumeRepository.findByAid(Integer.parseInt(id));
        for(ConsumeEntity consumeEntity:consumeEntityList){
            result+=consumeEntity.getPrice();
        }
        return result;
    }
}
