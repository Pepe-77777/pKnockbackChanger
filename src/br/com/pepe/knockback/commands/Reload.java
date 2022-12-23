package br.com.pepe.knockback.commands;

import br.com.pepe.knockback.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Main.getMain().reloadConfig();
        sender.sendMessage(Main.getMain().prefix + "§aSuccess!");

        return true;
    }
}
