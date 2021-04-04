package me.b3n3dkt.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import org.bukkit.Bukkit;

public class SkyPvPStats {
   public static void createUser(final String name, final String uuid) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            MySQL.update("INSERT INTO SkyPvP (Spielername, UUID, Tode, Kills, Killstreak) VALUES('" + name + "','" + uuid + "','" + 0 + "','" + 0 + "','" + 0 + "')");
         }
      });
   }

   public static boolean isUserExists(String uuid) {
      try {
         PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM SkyPvP WHERE UUID = ?");
         ps.setString(1, uuid.toString());
         ResultSet rs = ps.executeQuery();
         return rs.next();
      } catch (SQLException var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public static Integer getKillstreak(String uuid) {
      try {
         PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM SkyPvP WHERE UUID = ?");
         ps.setString(1, uuid.toString());
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            return rs.getInt("Killstreak");
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

      return 0;
   }

   public static void setKillstreak(final String uuid, final int amount) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            MySQL.update("UPDATE SkyPvP SET Killstreak = '" + amount + "' WHERE UUID = '" + uuid + "'");
         }
      });
   }

   public static Integer getKills(String uuid) {
      try {
         PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Kills FROM SkyPvP WHERE UUID = ?");
         ps.setString(1, uuid.toString());
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            return rs.getInt("Kills");
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

      return 0;
   }

   public static void setKills(String uuid, int amount) {
      MySQL.update("UPDATE SkyPvP SET Kills = '" + amount + "' WHERE UUID = '" + uuid + "'");
   }

   public static Integer getTode(String uuid) {
      try {
         PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Tode FROM SkyPvP WHERE UUID = ?");
         ps.setString(1, uuid.toString());
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            return rs.getInt("Tode");
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

      return 0;
   }

   public static void setTode(final String uuid, final int amount) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            MySQL.update("UPDATE SkyPvP SET Tode = '" + amount + "' WHERE UUID = '" + uuid + "'");
         }
      });
   }
}
