package com.liangzi.command;

import cn.originmc.plugins.origincore.util.text.Sender;
import com.liangzi.OriginTag;
import com.liangzi.utils.ColorUtils;
import com.liangzi.utils.ConfigFactoryUtils;
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
    private OriginTag plugin;
    private ConfigFactoryUtils factory;
    public TagCommands(OriginTag plugin, ConfigFactoryUtils factory) {
        this.plugin = plugin;
        this.factory = factory;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if ("otag".equalsIgnoreCase(command.getName())){
            if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ColorUtils.getColorStr("help"));
                return true;
            }
            if (args[0].equalsIgnoreCase("check")) {
                if (args[1] != null && OriginTag.getInstance().getServer().getPlayerExact(args[1]) != null) {
                    Player p = OriginTag.getInstance().getServer().getPlayerExact(args[1]);
                    if (args[2] != null && PlayerMetaUtils.checkPlayerTags(p).contains(args[2])) {
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
            if (args[0].equalsIgnoreCase("info")) {
                (new Sender(OriginTag.getInstance())).sendToLogger("[OriginTag] 已经加载的称号有：&b" + OriginTag.tags);
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                if ("CONSOLE".equals(sender.getName())) {
                    plugin.reloadConfig();
                } else if (sender.isOp()) {
                    ColorUtils.sendPlayerMsg((Player) sender, "[OriginTag] &c&l正在重新读取配置文件...");
                    plugin.reloadConfig();
                }

                return true;
            }
            else {
                return false;
            }
        } else return false;
    }


    public void setFactory(ConfigFactoryUtils factory) {
        this.factory = factory;
    }
}

