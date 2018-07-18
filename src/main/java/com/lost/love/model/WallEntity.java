package com.lost.love.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author zhongzhiqiang
 * @date 2018/7/16  11:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WallEntity {
    private int id;
    private String ip;
    private String userName;
    private String password;
    private String content;
    private String createDate;
    private String modifyDate;
    private String remark;


}
