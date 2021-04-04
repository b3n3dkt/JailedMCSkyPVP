package me.b3n3dkt;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.google.gson.JsonObject;
import eu.skyrasor.entity.NpcEntity;
import me.b3n3dkt.commands.*;
import me.b3n3dkt.commands.Rang;
import me.b3n3dkt.listener.*;
import me.b3n3dkt.mysql.MySQL;
import me.b3n3dkt.utils.*;
import me.b3n3dkt.utils.PlayerMove;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SkyPvP extends JavaPlugin {

    private ServerConfig scfg = new ServerConfig();
    private static SkyPvP main;
    private static String prefix;
    private ProtocolManager protocolmanager;
    public static Voting activeVote = null;
    private static String noperm;
    public static MessageManager mM;

    @Override
    public void onEnable(){
        if(scfg.exist() == false){
            scfg.newConfig();
        }
        try {
            loadUtils();
        } catch (IOException e) {}
        this.loadProtocolLib();
        (new ClearLag()).startClearlag();
        new Broadcaster(this).startBroadcast();
        MySQL.connect();
        mM = new MessageManager(this);
        (new NpcEntity(new Location(Bukkit.getWorld("world"), -7.5D, 127.0D, -7.5D), "eyJ0aW1lc3RhbXAiOjE1ODY3MTU2MDIwMjMsInByb2ZpbGVJZCI6IjczZDRlMDY4M2E2ZDRjOGI4Zjg1MzMyMzU0Njk1NWM0IiwicHJvZmlsZU5hbWUiOiJNSEZfQ2hlc3QiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzc1ODMwNWU1MjdmY2YwODUyNWZkZmYwN2U0Y2Q2ZTc5Nzc0YWNkZDQyNmNjMjczMjdkNDVkZjhhNWZmODY0MTkifX19", "U1VjGwv8dwjqvcWoQNVJE8pqxIJT2BvmK1X4nrJG2esX1+yL6M7GgCLUAVkkCla50k5IDlrulRQzODpKfWteORbH1ap3JRJUh3Cja3nFJIjNYcd+QsXwSXjkzYoqQ/yfpHiLJZqAmEVyNV5D4NgYjoqioGw7/D3O4pHCKBHeuIgH2q9u7eW11C9Yv24svlKL0OoB4R+WqLl6qEXx6Thq4MS04cwFpvkXKODxAZGPhw0ok8Pf0TioVNtC5qJTC7czggZZ3ivQXRfaKrIH/BY/RqW9BBQ2CcBxMLIyJejEPo1w9gcWHr1HlRwUpBx2wOr3FYqjSJLHP+tZofS8W2oYR+pS4jP3MMe+XcpHwf6gcadsfbOLb9IQ3oHmso+A5xHp9/mfT5EcRLhAHn2FehBzCyG1PkwiA4KBe8OIPCI/UK/bUqt67sHj3mJ6QerY8KqtiRlgKLWH/epvlH/0JmpuIVunZ+4pVCibA4N27JZropQclm3n9IWHJFdkEwrCKPJ4I7kDpl+iA0p8BUrMoyZFWpqsrqCuwEHhAdniFFEMWKEMGVmCxGRj/r8VYsBKWRLr0gf6Irqt3qIQyigNNW4FRBGxBPMsFU5RqrULILNe/pxhy4/udhnggydQUelBU3NXYmwrYRtBVL9ZiiWwHyfH7XGheNKmh63tqh2RSr0/DFw=")).init("§6§lBelohnungen");
        (new NpcEntity(new Location(Bukkit.getWorld("world"), -7.5D, 127.0D, -15.5D), "eyJ0aW1lc3RhbXAiOjE1NTIzMjcxNTM2MTMsInByb2ZpbGVJZCI6Ijg1MmI4ZGZkYjZiMzQ4MWNiYmYwMTM3YjM2YmFlN2JmIiwicHJvZmlsZU5hbWUiOiJaMkk3TzJLOExHNjciLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWEzNjEyZDY5OWMxYzg2YmExMjAzY2MxM2UzY2I2MjI5OWVmMWI4ZTYzYzZjZDA1ZTk0OGU4M2Y3YzNjZGM1NyJ9fX0=", "e7eIA9Msnhwuh3p9PigJg2FKA4n6o9kDd/9pWNqCntm+8lEGFWWBmvaHhURuRs1vZvsxWFIMdTwdwKeGJ7XW4exhiPDffblx9odt3JyyGdAZG7sc8Owv2yG9q1ZB1UUyMICd7z9WWhoFsntYnHdrw4XGncjfEaR/AYaE8pMS5fVDzggyf3w4ffYOqmeKJEzt7XBcBovJKM1ZDRnyWO6O/LM6i/YJnKbuyGQHAAhP7Qtx1OD7sAPXyd7POMhfqK/EVnLOCFsTc6NP/wXNmUFjmAY96/eD5nl9ckuCUYl7kWClUb9oRJSC52SyI5P+YyK5KbWPVFRqK4uqNqOG4+5KTSWb0av3MzFxVOJhuOEtDzCmJhsSKhVXMUD7jPN+nQ5f0QJJm+xoqJZa4iPLots3L6/qOwcW5FHL5xlsObVor7C4vMuaDNb1Ii7dyoUknjdShuC/iiwMohob5NzYK1Wd+TCSki91juzNVPjGR9/kORXE9aMZtbbGWRrrzAbaauFDHdgdgFrLofqywKJer68xkQisfnalqYvKrOFKSYXYGYtMqsDwvtu+VY1upBqZjQsL30Fz7JHp9iyf+m3b4qExrwlB0vBbZ3uZIHb4tclivqfKxym7ESNJOSVlgFn/5J+8IRkk16vYwj+rkFXMFZhMRMvXl6dL3mXj4HCcsptXoXU=")).init("§6§lShop");
        (new NpcEntity(new Location(Bukkit.getWorld("world"), -12.5D, 127.0D, -19.5D), "eyJ0aW1lc3RhbXAiOjE1ODY3MTkyMzQwODAsInByb2ZpbGVJZCI6IjAxM2IwZGQyZjc1MTQxNTY4OTg2NDY4NTgzZjg2NTcyIiwicHJvZmlsZU5hbWUiOiIwY2tyNG1NYyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODBhNzAzMjEwYTc3MTU1YWE4Zjc4ZWI4MThhNDNhMjcwMGFlODI4MDQwNGM4ZmFjYzQ3N2QyYzI2OTM2MDg5IiwibWV0YWRhdGEiOnsibW9kZWwiOiJzbGltIn19fX0=", "i+WUG9bjl106YDZIkfYpiaZqPNLNSiEcTWupm6i41ITNYjTL3AlILm/JoxBCFdJD/wuG+rKKeU6gFNlanuoZAwiHP30SsrrYBfVq9kTSuoyYKPAFWg0cWypfQg9TkLQvVznv6FqvRygnUqvpyqpDF6TzCkexVGfs7BKvWhgCg6krbyLKhhEtJEwIAwlhpF6ju/ROlx3BiQKdWnpYa4yZEagpFRhoiCCq48BDNQ1HB02PuhXUXqczWMuk0PlNomzn/3J3f7HluTkNxESBdk2QgdHc8aRlyvvK9YfRaR/qBDGAMiS0rRUCrhbKb5oO5YeHFZixvzqugRwwNbWVTBSi0a10hQgnVhcEqh90Au705Qjf1yII9UCtDiPpZLcSVAUBqAzwY64MgT9KmKgpH7+OF4B1NugJo7cODJo3yZiU1ulC9XtC7ObzGz8QW/5HrpbnbHYHfFE0udPM1ZsIWxZ326HlW7Tp8NrRA4cmf4LOp2cHs/XItycI9uHzTKhPJGgNmuzR8AIKdEU5PagFmx2vDVVPFnwkQlIxyz5HAGiOT3R2iGMGwx4sNj6QXEySSXfjgqBTRtvmTquaQ9ivXAEFxKQJmVd2WI6S1OYBDNXcg+4ujOjc1SZ32VJCLXfvBaumLPBZr9q76FldAZLX/U7p7a7GSJZHjT9+pkKqqortJ4s=")).init("§6§lKits");
        (new NpcEntity(new Location(Bukkit.getWorld("world"), -18.5D, 127.0D, -22.5D), "eyJ0aW1lc3RhbXAiOjE1NTIzMjcxNTM2MTMsInByb2ZpbGVJZCI6Ijg1MmI4ZGZkYjZiMzQ4MWNiYmYwMTM3YjM2YmFlN2JmIiwicHJvZmlsZU5hbWUiOiJaMkk3TzJLOExHNjciLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWEzNjEyZDY5OWMxYzg2YmExMjAzY2MxM2UzY2I2MjI5OWVmMWI4ZTYzYzZjZDA1ZTk0OGU4M2Y3YzNjZGM1NyJ9fX0=", "e7eIA9Msnhwuh3p9PigJg2FKA4n6o9kDd/9pWNqCntm+8lEGFWWBmvaHhURuRs1vZvsxWFIMdTwdwKeGJ7XW4exhiPDffblx9odt3JyyGdAZG7sc8Owv2yG9q1ZB1UUyMICd7z9WWhoFsntYnHdrw4XGncjfEaR/AYaE8pMS5fVDzggyf3w4ffYOqmeKJEzt7XBcBovJKM1ZDRnyWO6O/LM6i/YJnKbuyGQHAAhP7Qtx1OD7sAPXyd7POMhfqK/EVnLOCFsTc6NP/wXNmUFjmAY96/eD5nl9ckuCUYl7kWClUb9oRJSC52SyI5P+YyK5KbWPVFRqK4uqNqOG4+5KTSWb0av3MzFxVOJhuOEtDzCmJhsSKhVXMUD7jPN+nQ5f0QJJm+xoqJZa4iPLots3L6/qOwcW5FHL5xlsObVor7C4vMuaDNb1Ii7dyoUknjdShuC/iiwMohob5NzYK1Wd+TCSki91juzNVPjGR9/kORXE9aMZtbbGWRrrzAbaauFDHdgdgFrLofqywKJer68xkQisfnalqYvKrOFKSYXYGYtMqsDwvtu+VY1upBqZjQsL30Fz7JHp9iyf+m3b4qExrwlB0vBbZ3uZIHb4tclivqfKxym7ESNJOSVlgFn/5J+8IRkk16vYwj+rkFXMFZhMRMvXl6dL3mXj4HCcsptXoXU=")).init("§6§lRang-Shop");
        register(); this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getConsoleSender().sendMessage("§aSkyPvP System started!");
    }

    public void register() {
        getCommand("kit").setExecutor(new CMD_Kit());
        getCommand("clearchat").setExecutor(new CMD_ClearChat());
        getCommand("clearlag").setExecutor(new CMD_ClearLag());
        getCommand("crash").setExecutor(new CMD_Crash());
        getCommand("enchant").setExecutor(new CMD_Enchant());
        getCommand("event").setExecutor(new CMD_Event());
        getCommand("feed").setExecutor(new CMD_Feed());
        getCommand("fly").setExecutor(new CMD_Fly());
        getCommand("gamemode").setExecutor(new CMD_Gamemode());
        getCommand("globalmute").setExecutor(new CMD_GlobalMute());
        getCommand("heal").setExecutor(new CMD_Heal());
        getCommand("invsee").setExecutor(new CMD_Invsee());
        getCommand("rename").setExecutor(new CMD_Rename());
        getCommand("setspawn").setExecutor(new CMD_SetSpawn());
        getCommand("sign").setExecutor(new CMD_Sign());
        getCommand("spawn").setExecutor(new CMD_Spawn());
        getCommand("stats").setExecutor(new CMD_Stats());
        getCommand("vanish").setExecutor(new CMD_Vanish());
        getCommand("votekick").setExecutor(new CMD_Votekick());
        getCommand("msg").setExecutor(new MSG(this));
        getCommand("reply").setExecutor(new Reply(this));
        getCommand("money").setExecutor(new Money());
        getCommand("eco").setExecutor(new Eco());
        getCommand("pay").setExecutor(new Pay());
        getCommand("pack").setExecutor(new CMD_Pack());
        getCommand("rang").setExecutor(new Rang());
        getCommand("enderchest").setExecutor(new CMD_EnderChest());
        getCommand("discord").setExecutor(new Discord());
        getCommand("update").setExecutor(new Update());

        Bukkit.getPluginManager().registerEvents(new Join_Quit(), this);
        Bukkit.getPluginManager().registerEvents(new Achievements(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerCommand(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerRespawn(), this);
        Bukkit.getPluginManager().registerEvents(new UnknownCommand(), this);
        Bukkit.getPluginManager().registerEvents(new WeatherChange(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick_Belohnungen(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick_Sonstiges(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick_Shop(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick_Kits(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract_KitGutscheine(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract_RangGutscheine(), this);
        Bukkit.getPluginManager().registerEvents(new NPCInteract(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract_Packs(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick_RangShop(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract_EnderChest(), this);
    }

    public void loadUtils() throws IOException{
        prefix = scfg.getPrefix();
        noperm = scfg.getNoPerms();
        main = this;
        MySQL.username = scfg.getUsername();
        MySQL.password = scfg.getPassword();
        MySQL.database = scfg.getDatabase();
        MySQL.host = scfg.getHost();
        MySQL.port = scfg.getPort();

    }

    @Override
    public void onDisable(){
        MySQL.close();
        Bukkit.getConsoleSender().sendMessage("§aLobby System stopped!");
    }

    private void loadProtocolLib() {
        this.protocolmanager = ProtocolLibrary.getProtocolManager();
        this.protocolmanager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, new PacketType[]{Server.TAB_COMPLETE}) {
            public void onPacketSending(PacketEvent e) {
                if (e.getPacketType() == Server.TAB_COMPLETE && !e.getPlayer().isOp()) {
                    e.setCancelled(true);
                }

            }
        });
    }

    public void sendCurrentPlayingGamemode(Player receiver, boolean visible, String gamemodeName) {
        JsonObject object = new JsonObject();
        object.addProperty("show_gamemode", visible);
        object.addProperty("gamemode_name", gamemodeName);
        LabyModProtocol.sendLMCMessage(receiver, "server_gamemode", object);
    }

    public static String getPrefix(){ return prefix; }

    public static String getNoperm(){ return noperm; }

    public static SkyPvP getMain(){ return main; }
}
