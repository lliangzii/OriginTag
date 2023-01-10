package com.liangzi;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @Description tag实例
 * @Author liangzi
 * @Date 2023/1/10 8:40
 * @Version 1.0
 */

/*
    定义一个tag类
    1、与lp的元数据挂钩：有key与value属性
    2、自身的属性：id、显示、描述
    3、方法：读取配置中的称号、向配置中储存称号
 */

public class Tag {
    private String key;
    private String value;
    private String id;
    private String show;
    private String description;
    private final FileConfiguration configuration = new YamlConfiguration();
    Tag(){}

    public void getConfigTag(){

    }

    public void addConfigTag(){

    }





    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
