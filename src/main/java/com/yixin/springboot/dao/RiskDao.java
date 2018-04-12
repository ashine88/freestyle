package com.yixin.springboot.dao;/**
 * Created by liushuai2 on 2018/4/11.
 */

import com.alibaba.fastjson.JSON;
import entity.CfRisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Package : com.yixin.springboot.dao
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月11日 15:25
 */
@Component
public class RiskDao {

    public static final Logger logger = LoggerFactory.getLogger(RiskDao.class);
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RiskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<CfRisk> getByApplyNo(String applyNo){
        String sql = "select id, apply_no, flowing_account, results from cf_risk where apply_no = ?";
        Object[] args = new Object[]{applyNo};


        List<CfRisk> list = jdbcTemplate.query(sql, args,
                new RowMapper<CfRisk>() {
                    @Override
                    public CfRisk mapRow(ResultSet resultSet, int i) throws SQLException {
                        CfRisk cfRisk = new CfRisk();
                        cfRisk.setApplyNo(resultSet.getString("apply_no"));
                        cfRisk.setFlowingAccount(resultSet.getString("flowing_account"));
                        cfRisk.setId(resultSet.getString("id"));
                        cfRisk.setResults(resultSet.getString("results"));
                        return cfRisk;
                    }
                }
        );

        logger.info("获取到的risk结果 {}", JSON.toJSONString(list));
        return list;
    }







}
