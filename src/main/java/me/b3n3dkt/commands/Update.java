package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Update implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§8§m   §r§8(§b§lChangelog§8)§m   ");
        sender.sendMessage("§7-(02.04) Enderchest Command hinzugefügt");
        sender.sendMessage("§7-(02.04) AutoBroadcaster hinzugefügt ");
        sender.sendMessage("§7-(02.04) Man kann nun Farbig schreiben");
        sender.sendMessage("§7-(02.04) Allgemein Bugs gefixed");
        sender.sendMessage("§8§m   §r§8(§b§lChangelog§8)§m   ");
        return false;
    }
}
