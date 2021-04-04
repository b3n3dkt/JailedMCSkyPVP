package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Discord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(SkyPvP.getPrefix() + "§7Unser Discord-Server: https://discord.gg/mmy8EsmAde");
        return false;
    }
}
