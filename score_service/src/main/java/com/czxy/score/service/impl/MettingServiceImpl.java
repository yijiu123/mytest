package com.czxy.score.service.impl;

import com.czxy.score.dao.MettingMapper;
import com.czxy.score.domain.Metting;
import com.czxy.score.service.MettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MettingServiceImpl implements MettingService {

    @Resource
    private MettingMapper mettingMapper;

    @Override
    public List<Metting> getMVo(String username) {
        List<Metting> mettingList = mettingMapper.getMetting(username);
        return mettingList;
    }

    @Override
    public Metting findMetting(Integer mettingId) {
        return mettingMapper.selectByPrimaryKey(mettingId);
    }

    @Override
    public List<Metting> getMettingList(Integer userId) {
        return mettingMapper.getMettingList(userId);
    }

}
