package com.liangzi.object;

import cn.originmc.plugins.origincore.hook.luckperms.LuckPermsManager;
import org.bukkit.entity.Player;

/**
 * @Description 定义LuckPerms的 meta 类
 * @Author liangzi
 * @Date 2023/1/11 17:14
 * @Version 1.0
 */

public class Meta {
    public Meta(Player player, String key) {
        setPlayer(player);
        setKey(key);
        setValue(LuckPermsManager.getMeta(player, key));
    }

    private String key;
    private String value;
    private Player player;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
