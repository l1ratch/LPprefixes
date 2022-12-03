package lpprefixes.lpprefixes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TabPrefixCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Команда доступная только для игроков");
            return true;
        }
        Player player = (Player)sender;
        if (!player.hasPermission("LPprefixes.prefix")) {
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("no-perms").replaceAll("&", "§"));
            return true;
        }
        if (args.length == 0) {
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("tabprefix.help").replaceAll("&", "§"));
            return true;
        }
        if (args[0].equalsIgnoreCase("clear")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tab player " + player.getName() + " remove");
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("tabprefix.clear").replaceAll("&", "§"));
        }
        if (args[0].equalsIgnoreCase("set")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tab player " + player.getName() + " tabprefix " + args[1]);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tab player " + player.getName() + " tagprefix " + args[1]);
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("tabprefix.set").replaceAll("&", "§"));
        }
        return false;
    }

}
