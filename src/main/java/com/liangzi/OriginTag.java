package com.liangzi;

import cn.originmc.plugins.origincore.hook.luckperms.LuckPermsManager;
import cn.originmc.plugins.origincore.util.data.yaml.YamlElement;
import cn.originmc.plugins.origincore.util.data.yaml.YamlManager;
import cn.originmc.plugins.origincore.util.text.Sender;
import com.liangzi.utils.ConfigFactoryUtils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class OriginTag extends JavaPlugin {
    private static JavaPlugin instance;
    private Sender sender;
    private ConfigFactoryUtils factory;
    public static YamlManager yamlManager;
    public static List<String> tags;

    public static JavaPlugin getInstance() {
        return instance;
    }

    public Sender getSender() {
        return sender;
    }
    @Override
    public void onLoad() {
        this.saveDefaultConfig();
    }
    @Override
    public void onEnable() {
        instance = this;
        sender = new Sender(this);
        yamlManager = new YamlManager(this, "tags");
        factory = new ConfigFactoryUtils(this);



        (new Sender(this)).sendToLogger("[OriginTag] &aOriginTag 启动成功");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}


