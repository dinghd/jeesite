package com.thinkgem.jeesite.modules.sms.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sms.dao.ScoreDao;
import com.thinkgem.jeesite.modules.sms.entity.Score;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 成绩Service
 * @author Gaowang
 * @version 2017-08-02
 */

@Service
@Transactional(readOnly = true)
public class ScoreService extends CrudService<ScoreDao, Score>{

    @Transactional(readOnly = false)
    public void delete(Score score, Boolean isRe) {
        score.setDelFlag(isRe!=null&&isRe?Score.DEL_FLAG_NORMAL:Score.DEL_FLAG_DELETE);
        super.delete(score);
    }

}
