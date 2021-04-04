package me.b3n3dkt.commands;

import java.util.ArrayList;
import java.util.Iterator;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.Voting;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Votekick implements CommandExecutor {
   public static ArrayList<String> cooldown = new ArrayList();
   public static ArrayList<String> grund = new ArrayList();

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         final Player p = (Player)sender;
         if (args.length == 1) {
            if (args[0].equalsIgnoreCase("yes")) {
               if (SkyPvP.activeVote != null) {
                  Voting.vote(p, Voting.Vote.YES);
               } else {
                  p.sendMessage(SkyPvP.getPrefix() + "§7Momentan läuft kein VoteKick");
               }
            } else if (args[0].equalsIgnoreCase("no")) {
               if (SkyPvP.activeVote != null) {
                  Voting.vote(p, Voting.Vote.YES);
               } else {
                  p.sendMessage(SkyPvP.getPrefix() + "§7Momentan läuft kein VoteKick");
               }
            } else {
               p.sendMessage("§7]=============== §eVoteKick §7===============[");
               p.sendMessage("§8> §c/votekick §e<Spieler> <Grund>");
               p.sendMessage("§8> §c/votekick §eYes");
               p.sendMessage("§8> §c/votekick §eNo");
               p.sendMessage("§7]=============== §eVoteKick §7===============[");
            }
         } else if (args.length == 2) {
            if (p.hasPermission("jailedmc.command.votekick")) {
               Player t = Bukkit.getPlayer(args[0]);
               Iterator var8 = Bukkit.getOnlinePlayers().iterator();

               while(var8.hasNext()) {
                  Player all = (Player)var8.next();
                  if (args[0].equalsIgnoreCase(all.getName())) {
                     t = all;
                     break;
                  }
               }

               if (t != null) {
                  if (t.hasPermission("jailedmc.command.votekick.bypass")) {
                     p.sendMessage(SkyPvP.getPrefix() + "§7Du darfst kein Teammitglied VoteKicken");
                  } else if (!cooldown.contains(p.getName())) {
                     p.sendMessage("§7]=============== §eVoteKick §7===============[");
                     p.sendMessage("§8> §7Die Abstimmung wird erstellt...");
                     p.sendMessage("§7]=============== §eVoteKick §7===============[");
                     SkyPvP.activeVote = new Voting(p, t, args[1]);
                     cooldown.add(p.getName());
                     Bukkit.getScheduler().scheduleSyncDelayedTask(SkyPvP.getMain(), new Runnable() {
                        public void run() {
                           CMD_Votekick.cooldown.remove(p.getName());
                        }
                     }, 18000L);
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst nur alle 15 minuten einen Spieler VoteKicken!");
                  }
               } else {
                  p.sendMessage("§7]=============== §eVoteKick §7===============[");
                  p.sendMessage("§8> §cDer Spieler konnte nicht gefunden werden.");
                  p.sendMessage("§7]=============== §eVoteKick §7===============[");
               }
            } else {
               p.sendMessage(SkyPvP.getNoperm());
            }
         } else {
            p.sendMessage("§7]=============== §eVoteKick §7===============[");
            p.sendMessage("§8> §c/votekick §e<Spieler> <Grund>");
            p.sendMessage("§8> §c/votekick §eYes");
            p.sendMessage("§8> §c/votekick §eNo");
            p.sendMessage("§7]=============== §eVoteKick §7===============[");
         }
      }

      return false;
   }
}
