package com.liangzi.command;

import com.liangzi.OriginTag;
import com.liangzi.utils.ColorUtils;
import com.liangzi.utils.PlayerMetaUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/1/13 19:22
 * @Version 1.0
 */

public class TagCommands implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String arg_0 = args[0];
        String arg_1 = args[1];
        String arg_2 = args[2];
        if (arg_0.equalsIgnoreCase("help")) {
            sender.sendMessage(ColorUtils.getColorStr("help"));
            return true;
        }
        if (arg_0.equalsIgnoreCase("check")) {
            Player p = OriginTag.getInstance().getServer().getPlayerExact(arg_1);
            if ( p != null) {
                if (PlayerMetaUtils.checkPlayerTags(p).contains(arg_2)) {
                    sender.sendMessage(ColorUtils.getColorStr("是的他有这个称号"));
                    return true;
                } else {
                    sender.sendMessage(ColorUtils.getColorStr("他没有这个称号"));
                    return true;
                }

            } else {
                sender.sendMessage(ColorUtils.getColorStr("&c无效的玩家名"));
                return false;
            }
        }
        else {
            return false;
        }

    }


}

