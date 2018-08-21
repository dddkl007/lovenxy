package com.lost.love.controller;

import com.alibaba.fastjson.JSONObject;
import com.lost.love.model.WallEntity;
import com.lost.love.service.WallServiceImpl;
import com.lost.love.util.ToolUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author zhongzhiqiang
 * @date 2018/7/16  11:31
 */
@RestController
@RequestMapping(value = "/lostlove")
@Log4j2
public class LostLoveController {
    @Autowired
    private WallServiceImpl wallServiceImpl;

    @GetMapping(value = "/wall")
    @ResponseBody
    public List<WallEntity> getWallList(HttpServletRequest httpServletRequest){
        String ip = ToolUtils.getIP(httpServletRequest);
        log.info("访问IP：" + ip);
        List<WallEntity> wallEntities = wallServiceImpl.getWallEntityList();
        return  wallEntities;
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody String json, HttpServletRequest httpServletRequest) throws Exception{
        String ip = ToolUtils.getIP(httpServletRequest);
        log.info("访问IP：" + ip);

        String jsonStr=URLDecoder.decode(json,"utf-8");
        System.out.println(jsonStr);
        JSONObject jsonObject = JSONObject.parseObject(json);
        WallEntity wallEntity = new WallEntity();
        wallEntity.setContent(jsonObject.getString("content"));
        wallEntity.setUserName(jsonObject.getString("userName"));
        wallServiceImpl.save(wallEntity);
        return "true";
    }


    @GetMapping(value = "/lovewall")
    @ResponseBody
    public List<WallEntity> getloveWallList(HttpServletRequest httpServletRequest){
        String ip = ToolUtils.getIP(httpServletRequest);
        log.info("访问IP：" + ip);
        List<WallEntity> wallEntities = wallServiceImpl.getLoveWallEntityList();
        return  wallEntities;
    }

    @PostMapping(value = "/savelove")
    public String savelove(@RequestBody String json, HttpServletRequest httpServletRequest) throws Exception{
        String ip = ToolUtils.getIP(httpServletRequest);
        log.info("访问IP：" + ip);

        String jsonStr=URLDecoder.decode(json,"utf-8");
        System.out.println(jsonStr);
        JSONObject jsonObject = JSONObject.parseObject(json);
        WallEntity wallEntity = new WallEntity();
        wallEntity.setContent(jsonObject.getString("content"));
        wallEntity.setUserName(jsonObject.getString("userName"));
        wallServiceImpl.saveLove(wallEntity);
        return "true";
    }
}
