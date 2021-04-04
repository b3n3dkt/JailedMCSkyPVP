package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSG implements CommandExecutor {

    SkyPvP skypvp;

    public MSG(SkyPvP skypvp) {
        skypvp = skypvp;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player && args.length > 0){
            if(Bukkit.getOfflinePlayer(args[0]).getPlayer() != null){
                Player messager = (Player) sender;
                Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                SkyPvP.mM.setReplyTarget(messager, reciever);
                args[0] = "";
                String message = "";
                for(int i = 0; i < args.length; i++){
                    message += " " + args[i];
                }
                messager.sendMessage("§8[§eMSG§8] §8»§7 " + reciever.getName() + ": §7" + message);
                reciever.sendMessage("§8[§eMSG§8] §8»§7 " + messager.getName() + ": §7" + message);
                return true;
            } else {
                sender.sendMessage(SkyPvP.getPrefix() + "§cDer Spieler ist nicht online!");
                return true;
            }

        }
        return false;
    }

}