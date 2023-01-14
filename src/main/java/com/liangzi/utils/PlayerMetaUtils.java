package com.liangzi.utils;

import cn.originmc.plugins.origincore.hook.luckperms.LuckPermsManager;
import com.liangzi.OriginTag;
import com.liangzi.object.Meta;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 对于玩家的meta操作
 * @Author liangzi
 * @Date 2023/1/11 17:25
 * @Version 1.0
 */

public class PlayerMetaUtils {
    public PlayerMetaUtils() {
    }

    /**
     *
     * @param player 玩家
     * @param tag 称号id
     * @return 是否含有该称号
     */
    public static boolean hasTag(Player player, String tag) {
        return checkPlayerTags(player).contains(tag);
    }

    /**
     *
     * @param player - 玩家
     * @return 玩家tag_meta与配置tags的交集集合
     */
    public static List<String> checkPlayerTags(Player player){
        ArrayList<Meta> tag_meta = getPlayerTag(player);
        List<String> metas = new ArrayList<>();
        List<String> tags = OriginTag.tags;
        for (Meta meta : tag_meta) {
            String s = meta.getValue();
            metas.add(s);
        }
        return intersectList(tags,metas);
    }

    public static List<String> intersectList(List<String> list1, List<String> list2) {
        list1.retainAll(list2);
        return list1;
    }

        /**
         * 遍历玩家的Meta，并返回符合tag格式的Meta集合
         * @param player - 玩家
         * @return - 元数据集合，key_id 均为 “tag_”
         */
    public static ArrayList<Meta> getPlayerTag(Player player){
        ArrayList<Meta> arrayList = new ArrayList<>();
        List<String> list = LuckPermsManager.getMetaKeyList(player);
        for (String key : list) {
            if (isTag(key)) {
                arrayList.add(new Meta(player,key));
            }
        }
        return arrayList;
    }

    public static boolean isTag(String key) {
        if (key.length() >= 4)
        {
            return "tag_".equals(key.substring(0, 4));
        } else return false;
    }

    public static boolean isTag(Meta meta) {
        if (meta.getKey().length() >= 4)
        {
            return "tag_".equals(meta.getKey().substring(0, 4));
        } else return false;
    }
}
