package com.lost.love.service;

import com.lost.love.mapper.LostLoveMapper;
import com.lost.love.model.WallEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongzhiqiang
 * @date 2018/7/16  11:29
 */
@Service
@Log4j2
public class WallServiceImpl {
    @Autowired
    private LostLoveMapper lostLoveMapper;

    public List<WallEntity> getWallEntityList(){
        List<WallEntity> wallEntities = new ArrayList<>();
        wallEntities = lostLoveMapper.getWallEntityList();
        return wallEntities;
    }

    public void save(WallEntity wallEntity){
        lostLoveMapper.save(wallEntity);
    }

    public List<WallEntity> getLoveWallEntityList(){
        List<WallEntity> wallEntities = new ArrayList<>();
        wallEntities = lostLoveMapper.getLoveWallEntityList();
        return wallEntities;
    }

    public void saveLove(WallEntity wallEntity){
        lostLoveMapper.saveLove(wallEntity);
    }
}
