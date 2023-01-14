package com.liangzi.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @Description 转义颜色工具
 * @Author liangzi
 * @Date 2023/1/9 21:44
 * @Version 1.0
 */

public class ColorUtils {
    public static String getColorStr(String str){
        return ChatColor.translateAlternateColorCodes('&',str);
    }
    public static void sendPlayerMsg(Player player, String msg){
        player.sendMessage(ColorUtils.getColorStr("&a[strengthPlus] "+msg));
    }
}
