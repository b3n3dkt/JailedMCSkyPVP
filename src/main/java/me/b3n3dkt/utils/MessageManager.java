package me.b3n3dkt.utils;

import me.b3n3dkt.SkyPvP;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {

    SkyPvP skyPvP;

    HashMap<Player, Player> conversations = new HashMap<Player, Player>();

    public MessageManager(SkyPvP skyPvP) {
        skyPvP = skyPvP;
    }

    public void setReplyTarget(Player messager, Player reciever){
        conversations.put(messager, reciever);
        conversations.put(reciever, messager);
    }

    public Player getReplyTarget(Player messager){
        return conversations.get(messager);
    }
}