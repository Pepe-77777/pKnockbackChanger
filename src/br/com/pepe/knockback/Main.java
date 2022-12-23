package br.com.pepe.knockback;

import br.com.pepe.knockback.commands.Reload;
import br.com.pepe.knockback.events.events;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public FileConfiguration config = this.getConfig();
    public String prefix = "§c§lKnockback§f§lChanger §7§l-> ";
    private static Main main;

    @Override
    public void onEnable() {
        main = this;
        Bukkit.getConsoleSender().sendMessage(prefix + "§aThe plugin is started!");
        config.addDefault("knockback-vertical", 1);
        config.addDefault("knockback-horizontal", 1);
        config.options().copyDefaults(true);
        saveConfig();

        this.getCommand("ReloadKB").setExecutor(new Reload());
        this.getServer().getPluginManager().registerEvents(new events(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§cThe plugin is disabled!");
        HandlerList.unregisterAll(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    public static Main getMain() {
        return main;
    }

}
