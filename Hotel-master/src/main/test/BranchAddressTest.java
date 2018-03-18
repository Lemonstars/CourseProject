import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.BranchInforService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by starrylemon on 2017/3/10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class BranchAddressTest {

    @Resource
    BranchInforService branchAddressService;

    @Test
    public void testGetBranchAddressInfor(){
        Map<String,List> map=branchAddressService.getBranchAddressInfor();
        for (String key : map.keySet()) {
            List list=map.get(key);
            for (int i=0;i<list.size();i++){
                System.out.print(list.get(i));
            }
        }
    }

}
