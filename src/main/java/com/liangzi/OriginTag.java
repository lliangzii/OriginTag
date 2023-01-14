package com.liangzi;

import cn.originmc.plugins.origincore.hook.luckperms.LuckPermsManager;
import cn.originmc.plugins.origincore.util.data.yaml.YamlElement;
import cn.originmc.plugins.origincore.util.data.yaml.YamlManager;
import cn.originmc.plugins.origincore.util.text.Sender;
import com.liangzi.command.TagCommands;
import com.liangzi.object.Tag;
import com.liangzi.utils.ConfigFactoryUtils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class OriginTag extends JavaPlugin {
    private static JavaPlugin instance;
    private Sender sender;
    private ConfigFactoryUtils factory;
    private TagCommands handler;
    public static YamlManager yamlManager;
    public static List<String> tags;
    public static List<Tag> tagList;

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
        yamlManager = new YamlManager(this,"tags",false);
        factory = new ConfigFactoryUtils(this);
        handler = new TagCommands(this, factory);

        //设置命令处理器
        Objects.requireNonNull(this.getCommand("otag")).setExecutor(handler);
        handler.setFactory(factory);

        (new Sender(this)).sendToLogger("[OriginTag] &aOriginTag 启动成功");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();

        (new Sender(this)).sendToLogger("[OriginTag] &c&l正在重新读取配置文件...");
        yamlManager = new YamlManager(this,"tags",false);
        tags = null;

        factory.initFile();
        factory.loadiConfig();

    }
}


