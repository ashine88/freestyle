package com.yixin.springboot.controller;/**
 * Created by liushuai2 on 2018/4/11.
 */

import com.yixin.springboot.domain.RiskDomain;
import entity.CfRisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Package : com.yixin.springboot.controller
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月11日 17:29
 */
@RestController
@RequestMapping(value = "/risk")
public class RiskController {

    public static final Logger logger = LoggerFactory.getLogger(RiskController.class);

    @Autowired
    private RiskDomain riskDomain;

    @RequestMapping(value = "/{applyNo}", method = RequestMethod.GET)
    public List<CfRisk> get(@PathVariable String applyNo){
        logger.info("根据申请编号获取risk信息，applyNo：{}", applyNo);
        List<CfRisk> list = riskDomain.get(applyNo);
        return list;
    }

}
