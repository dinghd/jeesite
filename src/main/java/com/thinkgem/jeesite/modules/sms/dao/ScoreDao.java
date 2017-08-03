package com.thinkgem.jeesite.modules.sms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sms.entity.Score;
import com.thinkgem.jeesite.modules.sms.entity.Student;

/**
 * 成绩Dao
 * @author Gaowang
 * @version 2017-08-02
 */

@MyBatisDao
public interface ScoreDao extends CrudDao<Score> {



}
