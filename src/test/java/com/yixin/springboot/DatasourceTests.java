package com.yixin.springboot;/**
 * Created by liushuai2 on 2018/4/10.
 */

import com.yixin.springboot.dao.RiskDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Package : com.yixin.springboot
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月10日 23:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceTests {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testDatasource(){
        // 获取数据源
        RiskDao riskDao = applicationContext.getBean(RiskDao.class);
        System.out.println(riskDao.getByApplyNo("201712040000005").size());

    }

}
