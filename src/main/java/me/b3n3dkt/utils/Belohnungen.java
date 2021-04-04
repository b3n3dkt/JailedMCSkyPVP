package me.b3n3dkt.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import org.bukkit.Bukkit;

public class Belohnungen {
   public static void setUsedTäglich(final String uuid, final String playername, final long seconds) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            long current = System.currentTimeMillis();
            long millis = seconds * 1000L;
            long end = current + millis;
            MySQL.update("INSERT INTO TäglicheBelohnungen (Spielername, UUID, Ende) VALUES('" + playername + "','" + uuid + "','" + end + "')");
            Bukkit.getPlayer(playername).sendMessage(SkyPvP.getPrefix() + "§7Du hast dir erfolgreich deine Täglichen belohnungen abgeholt!");
         }
      });
   }

   public static void setUsedWöchentlich(final String uuid, final String playername, final long seconds) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            long current = System.currentTimeMillis();
            long millis = seconds * 1000L;
            long end = current + millis;
            MySQL.update("INSERT INTO WöchentlicheBelohnungen (Spielername, UUID, Ende) VALUES('" + playername + "','" + uuid + "','" + end + "')");
            Bukkit.getPlayer(playername).sendMessage(SkyPvP.getPrefix() + "§7Du hast dir erfolgreich deine Wöchentlichen belohnungen abgeholt!");
         }
      });
   }

   public static void setUsedMontalich(final String uuid, final String playername, final long seconds) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            long current = System.currentTimeMillis();
            long millis = seconds * 1000L;
            long end = current + millis;
            MySQL.update("INSERT INTO MonatlicheBelohnungen (Spielername, UUID, Ende) VALUES('" + playername + "','" + uuid + "','" + end + "')");
            Bukkit.getPlayer(playername).sendMessage(SkyPvP.getPrefix() + "§7Du hast dir erfolgreich deine Monatlichen belohnungen abgeholt!");
         }
      });
   }

   public static void unsetUsedTäglich(final String uuid) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            MySQL.update("DELETE FROM TäglicheBelohnungen WHERE UUID = '" + uuid + "'");
         }
      });
   }

   public static void unsetUsedWöchentlich(final String uuid) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            MySQL.update("DELETE FROM WöchentlicheBelohnungen WHERE UUID = '" + uuid + "'");
         }
      });
   }

   public static void unsetUsedMonatlich(final String uuid) {
      Bukkit.getScheduler().runTaskAsynchronously(SkyPvP.getMain(), new Runnable() {
         public void run() {
            MySQL.update("DELETE FROM MonatlicheBelohnungen WHERE UUID = '" + uuid + "'");
         }
      });
   }

   public static boolean usedTägliche(String uuid) {
      ResultSet rs = MySQL.getResult("SELECT * FROM TäglicheBelohnungen WHERE UUID = '" + uuid + "'");

      try {
         return rs.next();
      } catch (SQLException var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public static boolean usedWöchentliche(String uuid) {
      ResultSet rs = MySQL.getResult("SELECT * FROM WöchentlicheBelohnungen WHERE UUID = '" + uuid + "'");

      try {
         return rs.next();
      } catch (SQLException var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public static boolean usedMonatliche(String uuid) {
      ResultSet rs = MySQL.getResult("SELECT * FROM MonatlicheBelohnungen WHERE UUID = '" + uuid + "'");

      try {
         return rs.next();
      } catch (SQLException var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public static Long getEndTägliche(String uuid) {
      ResultSet rs = MySQL.getResult("SELECT Ende FROM TäglicheBelohnungen WHERE UUID = '" + uuid + "'");

      try {
         if (rs.next()) {
            return rs.getLong("Ende");
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

      return null;
   }

   public static Long getEndWöchentliche(String uuid) {
      ResultSet rs = MySQL.getResult("SELECT Ende FROM WöchentlicheBelohnungen WHERE UUID = '" + uuid + "'");

      try {
         if (rs.next()) {
            return rs.getLong("Ende");
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

      return null;
   }

   public static Long getEndMonatliche(String uuid) {
      ResultSet rs = MySQL.getResult("SELECT Ende FROM MonatlicheBelohnungen WHERE UUID = '" + uuid + "'");

      try {
         if (rs.next()) {
            return rs.getLong("Ende");
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

      return null;
   }

   public static String getRemainingTimeTägliche(String uuid) {
      long current = System.currentTimeMillis();
      long end = getEndTägliche(uuid);
      long millis = end - current;
      int seconds = 0;
      int minutes = 0;

      int hours;
      for(hours = 0; millis > 1000L; ++seconds) {
         millis -= 1000L;
      }

      while(seconds > 60) {
         seconds -= 60;
         ++minutes;
      }

      while(minutes > 60) {
         minutes -= 60;
         ++hours;
      }

      return "§e" + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n)";
   }

   public static String getRemainingTimeWöchentliche(String uuid) {
      long current = System.currentTimeMillis();
      long end = getEndWöchentliche(uuid);
      long millis = end - current;
      int seconds = 0;
      int minutes = 0;
      int hours = 0;

      int days;
      for(days = 0; millis > 1000L; ++seconds) {
         millis -= 1000L;
      }

      while(seconds > 60) {
         seconds -= 60;
         ++minutes;
      }

      while(minutes > 60) {
         minutes -= 60;
         ++hours;
      }

      while(hours > 24) {
         hours -= 24;
         ++days;
      }

      return "§e" + days + " Tag(e) " + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n)";
   }

   public static String getRemainingTimeMonatliche(String uuid) {
      long current = System.currentTimeMillis();
      long end = getEndMonatliche(uuid);
      long millis = end - current;
      int seconds = 0;
      int minutes = 0;
      int hours = 0;
      int days = 0;

      int weeks;
      for(weeks = 0; millis > 1000L; ++seconds) {
         millis -= 1000L;
      }

      while(seconds > 60) {
         seconds -= 60;
         ++minutes;
      }

      while(minutes > 60) {
         minutes -= 60;
         ++hours;
      }

      while(hours > 24) {
         hours -= 24;
         ++days;
      }

      while(days > 7) {
         days -= 7;
         ++weeks;
      }

      return "§e" + weeks + " Woche(n) " + days + " Tag(e) " + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n)";
   }
}
