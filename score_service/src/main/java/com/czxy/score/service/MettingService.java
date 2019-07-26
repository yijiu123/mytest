package com.czxy.score.service;

import com.czxy.score.domain.Metting;

import java.util.List;

public interface MettingService {

    List<Metting> getMVo(String username);

    Metting findMetting(Integer mettingId);

    List<Metting> getMettingList(Integer userId);
}
