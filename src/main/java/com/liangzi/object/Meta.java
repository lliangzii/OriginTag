package com.liangzi.object;

import org.bukkit.entity.Player;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/1/11 17:14
 * @Version 1.0
 */

public class Meta {
    Meta(Player player, String key, String value) {
        setPlayer(player);
        setKey(key);
        setValue(value);
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
