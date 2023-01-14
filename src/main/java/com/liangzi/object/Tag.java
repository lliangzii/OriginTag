package com.liangzi.object;

import cn.originmc.plugins.origincore.util.data.yaml.YamlManager;
import com.liangzi.OriginTag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

import static com.liangzi.OriginTag.yamlManager;

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
 */

public class Tag {
    private String key;
    private String tag_id;
    private String show;
    private String description;
    private final FileConfiguration configuration = new YamlConfiguration();
    public Tag(String tag_id){
        setTag_id(tag_id);
        setKey((String) yamlManager.get("tags", "key"));
        setShow((String) yamlManager.get("tags", "show"));
        setDescription((String) yamlManager.get("tags", "description"));
    }
    /**
     *
     * @param key - 用于和meta比较判断玩家是否有称号
     * @param tag_id - 称号的id，显示在tag.yml中
     * @param show - 称号的实际展现， 显示为tag.yml中的tag_id的子键
     * @param description - 称号的描述， 显示为tag.yml中的tag_id的子键
     */
    public Tag(String key, String tag_id, String show, String description) {
        setKey(key);
        setTag_id(tag_id);
        setShow(show);
        setDescription(description);
    }
    public void addTagToConfig() {
        yamlManager.set("tags",("tags." + tag_id+".key"), key);
        yamlManager.set("tags", ("tags." + tag_id+".show"), show);
        yamlManager.set("tags", ("tags." + tag_id+".description"), description);
        yamlManager.save("tags");
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
