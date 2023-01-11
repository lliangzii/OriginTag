package com.liangzi.object;

import cn.originmc.plugins.origincore.util.data.yaml.YamlManager;
import com.liangzi.OriginTag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @Description tag实例
 * @Author liangzi
 * @Date 2023/1/10 8:40
 * @Version 1.0
 */

/*
    定义一个tag类
    1、与lp的元数据挂钩：有key与value属性
    2、自身的属性：tag_id、显示、描述
    3、方法：读取配置中的称号、向配置中储存称号
 */

public class Tag {
    private String key;
    private String tag_id;
    private String show;
    private String description;
    private final FileConfiguration configuration = new YamlConfiguration();
    Tag(){}
    Tag(String key, String tag_id, String show, String description) {
        setKey(key);
        setTag_id(tag_id);
        setShow(show);
        setDescription(description);
    }
    public void addTagToConfig() {
        YamlManager yamlManager = new YamlManager(new OriginTag(), "OriginTag");
        yamlManager.set("config.yml", tag_id, key);
        yamlManager.set("config.yml", tag_id+".show", show);
        yamlManager.set("config.yml", tag_id+".description", description);
        yamlManager.save("config.yml");
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
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
