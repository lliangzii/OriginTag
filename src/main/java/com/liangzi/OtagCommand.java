package com.liangzi;

import com.liangzi.utils.ColorUtils;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/1/9 20:02
 * @Version 1.0
 */

public class OtagCommand implements org.bukkit.command.CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("OriginTag") && command.getLabel().equalsIgnoreCase("otag")) {
            if (args.length == 0) {
                sender.sendMessage(ColorUtils.getColorStr("--- &7[&9OriginTag&7] &f---"));
                sender.sendMessage(ColorUtils.getColorStr("&6用法: &a /otag give &b<玩家> <键值> &f- &7为玩家快速添加一个“Tag_”键值"));
                sender.sendMessage(ColorUtils.getColorStr("------"));
                sender.sendMessage(ColorUtils.getColorStr("&6tps:"));
                sender.sendMessage(ColorUtils.getColorStr("&a /lp user &b<玩家> &ameta info &f- &7展示玩家所拥有的所有键值"));
                sender.sendMessage(ColorUtils.getColorStr("&a /lp user &b<玩家> &ameta unset &f- &7移除玩家该键对应的键与键值"));
                sender.sendMessage(ColorUtils.getColorStr("&a /lp user &b<玩家> &ameta set &b<键> <键值> (context) &f- &7为玩家设置一个键值"));
                return false;
            }
            if (args[0].equalsIgnoreCase("give")){
                if (OriginTag.getInstance().getServer().getPlayerExact(args[1]) != null){
                    sender.sendMessage(ColorUtils.getColorStr("&7[&9OriginTag&7]&9-> &a已将玩家 "+args[1]+" 的键值 "+OriginTag.setPlayerTag(OriginTag.getInstance().getServer().getPlayerExact(args[1]), args[2])
                    +" &a设置为 "+ args[2] ));
                    return true;
                } else {
                    sender.sendMessage(ColorUtils.getColorStr("&7[&9OriginTag&7]&9-> &c未找到该玩家"));
                    return false;
                }
            }
            else {
                sender.sendMessage(ColorUtils.getColorStr("&7[&9OriginTag&7]&9-> &c错误的用法"));
                return false;
            }
        } else {
            sender.sendMessage(ColorUtils.getColorStr("&7[&9OriginTag&7]&9-> &c错误的用法"));
            return false;
        }

    }
}
