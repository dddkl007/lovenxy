package com.lost.love.mapper;

import com.lost.love.model.WallEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhongzhiqiang
 * @date 2018/7/16  11:27
 */
@Mapper
@Component
public interface LostLoveMapper {

    @Select("select * from wall ")
    List<WallEntity> getWallEntityList();

    @Select("select * from love_wall ")
    List<WallEntity> getLoveWallEntityList();

    @Insert("INSERT INTO wall(user_name,content,create_date) VALUES(#{userName},#{content},NOW())")
    void save(WallEntity wallEntity);

    @Insert("INSERT INTO love_wall(user_name,content,create_date) VALUES(#{userName},#{content},NOW())")
    void saveLove(WallEntity wallEntity);
}
