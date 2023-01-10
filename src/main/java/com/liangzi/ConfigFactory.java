package com.liangzi;

import cn.originmc.plugins.origincore.util.text.Sender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/1/10 8:12
 * @Version 1.0
 */

public class ConfigFactory {
    private OriginTag plugin;
    private final FileConfiguration configuration = new YamlConfiguration();

    public ConfigFactory(){}

    public ConfigFactory(OriginTag plugin) {
        initFile();
    }



    public void initFile(){
        try {
            configuration.load(new File(plugin.getDataFolder(),"config.yml"));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            (new Sender(plugin)).sendToLogger("[OriginTag] &c&l配置文件不存在，正在生成配置文件....");
            plugin.saveDefaultConfig();
            initFile();
        }
        (new Sender(plugin)).sendToLogger("[OriginTag] &c&l本地配置文件初始化成功，正在读取配置文件...");
    }
}
