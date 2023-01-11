package com.liangzi;

import cn.originmc.plugins.origincore.hook.luckperms.LuckPermsManager;
import cn.originmc.plugins.origincore.util.data.yaml.YamlElement;
import cn.originmc.plugins.origincore.util.data.yaml.YamlManager;
import cn.originmc.plugins.origincore.util.text.Sender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class OriginTag extends JavaPlugin {
    private static JavaPlugin instance;
    private static String key;
    private static final String deftag = "Tag_";
    private static int keynum;
    private Sender sender;
    private ConfigFactory factory;
    private YamlManager yamlManager;

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
        factory = new ConfigFactory(this);
        yamlManager = new YamlManager(this, "OriginTag");
        (new Sender(this)).sendToLogger("[OriginTag] &aOriginTag 启动成功");

        this.getCommand("otag").setExecutor(new OtagCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     *基于luckperm的meta功能
     *为玩家设置键值，格式为"Tag_"+数字
     *键值value将被设置在从0开始正序排列所找到的第一个空位上
     *@param p - 玩家
     *@param tag - 要设置的键值
     */
    public static String setPlayerTag(Player p, @NotNull String tag) {
        keynum = 0;
        key = deftag + keynum;//key = Tag_0
        //玩家没有Tag_键值
        if (LuckPermsManager.getMeta(p,key) == null) {
            LuckPermsManager.setMeta(p,key,tag);
            return key;
        }
        else {
            while (LuckPermsManager.getMeta(p, key) != null) {
                keynum++;
                key = deftag + keynum;
            }
            LuckPermsManager.setMeta(p, key, tag);
            return key;
        }
    }

    /**获取一个包含玩家所有Tag_键值的集合
     * 玩家没有Tag_键值则返回null
     * @param p - 玩家
     * @return taglist - 玩家拥有的Tag_键值集合
     */
    public static ArrayList<String> getPlayerTagList(Player p) {
        ArrayList<String> taglist = new ArrayList<>();
        keynum = 0;
        key = deftag + keynum;

        if (LuckPermsManager.getMeta(p,key) != null) {
            while (LuckPermsManager.getMeta(p, key) != null) {
                taglist.add(LuckPermsManager.getMeta(p, key));
                keynum++;
                key = deftag + keynum;
            }
            return taglist;
        }
        else {return null;}
    }
    public YamlElement getConfigYamlElement() {
        return yamlManager.getElement("config.yml");
    }
}


