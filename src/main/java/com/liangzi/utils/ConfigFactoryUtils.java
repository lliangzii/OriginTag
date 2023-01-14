package com.liangzi.utils;

import cn.originmc.plugins.origincore.util.data.yaml.YamlElement;
import cn.originmc.plugins.origincore.util.data.yaml.YamlManager;
import cn.originmc.plugins.origincore.util.text.Sender;
import com.liangzi.OriginTag;
import com.liangzi.object.Tag;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/1/10 8:12
 * @Version 1.0
 */

public class ConfigFactoryUtils {
    private JavaPlugin plugin = OriginTag.getInstance();
    private final FileConfiguration configuration = new YamlConfiguration();

    public ConfigFactoryUtils() {
    }

    public ConfigFactoryUtils(OriginTag plugin) {
        this.plugin = plugin;
        initFile();
        loadiConfig();
    }

    /**
     * @param player - 玩家
     * @param tag_id - 称号id
     * @return boolean - 玩家是否拥有此称号
     */
    public boolean hasTag(Player player, String tag_id) {
        List<String> tags = OriginTag.tags;
        for (String tag : tags) {
            if (tag_id.equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public void initFile() {
        try {
            configuration.load(new File(plugin.getDataFolder(), "config.yml"));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            (new Sender(plugin)).sendToLogger("[OriginTag] &c&l配置文件不存在，生成默认配置....");
            plugin.saveDefaultConfig();
            initFile();
        }
        (new Sender(plugin)).sendToLogger("[OriginTag] &b配置文件初始化成功，正在读取...");


    }

    public void loadiConfig() {
        try {
            OriginTag.tags = OriginTag.yamlManager.getKeyList("tags", "tags", false);
        } catch (Exception e) {
            e.printStackTrace();
            (new Sender(plugin)).sendToLogger("[OriginTag] 加载称号失败，初始化...");
            if (!OriginTag.yamlManager.hasElement("tags")) {
                OriginTag.yamlManager.create("tags");
                loadiConfig();
            }
        }
        if (OriginTag.tags == null) {
            Tag default_tag = new Tag("defkey", "default", "show", "description");
            default_tag.addTagToConfig();

            (new Sender(plugin)).sendToLogger("[OriginTag] 成功加载称号");

            (new Sender(plugin)).sendToLogger("[OriginTag] 称号有：" + OriginTag.tags);
        }

    }
}
