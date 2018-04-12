package com.yixin.springboot.domain;/**
 * Created by liushuai2 on 2018/4/11.
 */

import com.yixin.springboot.dao.RiskDao;
import entity.CfRisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * risk 控制domain
 *
 * Package : com.yixin.springboot.domain
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月11日 15:24
 */
@Service
public class RiskDomain {

    @Autowired
    private RiskDao riskDao;

    public List<CfRisk> get(String applyNo){
        return riskDao.getByApplyNo(applyNo);
    }


}
