package lpprefixes.lpprefixes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PrefixCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Команда доступная только для игроков");
            return true;
        }
        Player player = (Player)sender;
        if (args.length == 0) {
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("no-args").replaceAll("&", "§"));
            return true;
        }
        if (args[0].equalsIgnoreCase("help")) {
            List<String> list = LPprefixes.getInstance().getConfig().getStringList("help");
            for (String s : list) {
                player.sendMessage(s);
            }
            return true;
        }
        if (args[0].equalsIgnoreCase("all") && LPprefixes.getInstance().getConfig().getBoolean("prefix.Allow") && player.hasPermission("LPprefixes.all")) {
            if (args.length < 2) {
                player.sendMessage("§cДоступные аргументы: clear | set");
                return true;
            }
            if (args[1].equalsIgnoreCase("clear")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " meta clear");
                player.sendMessage(LPprefixes.getInstance().getConfig().getString("prefix.clear").replaceAll("&", "§"));
                return true;
            }
            if (args[1].equalsIgnoreCase("set")) {
                if (args.length < 3){
                    player.sendMessage("§cУкажите префикс! /prefix all set [префикс]");
                    return true;
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " meta clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " meta addprefix 999 " + args[2]);
                player.sendMessage(LPprefixes.getInstance().getConfig().getString("prefix.set").replaceAll("&", "§"));
                return true;
            }
        }
        if(!player.hasPermission("LPprefixes.all")){
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("no-perm").replaceAll("&", "§"));
        }
        //
        if (args[0].equalsIgnoreCase("tab") && LPprefixes.getInstance().getConfig().getBoolean("tabprefix.Allow") && player.hasPermission("LPprefixes.tab")) {
            if (args.length < 2) {
                player.sendMessage("§cДоступные аргументы: clear | set");
                return true;
            }
            if (args[1].equalsIgnoreCase("clear")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tab player " + player.getName() + " remove");
                player.sendMessage(LPprefixes.getInstance().getConfig().getString("tabprefix.clear").replaceAll("&", "§"));
                return true;
            }
            if (args[1].equalsIgnoreCase("set")) {
                if (args.length < 3){
                    player.sendMessage("§cУкажите префикс! /prefix tab set [префикс]");
                    return true;
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tab player " + player.getName() + " tabprefix " + args[2]);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tab player " + player.getName() + " tagprefix " + args[2]);
                player.sendMessage(LPprefixes.getInstance().getConfig().getString("tabprefix.set").replaceAll("&", "§"));
                return true;
            }
        }
        if(!player.hasPermission("LPprefixes.tab")){
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("no-perm").replaceAll("&", "§"));
        }
        //
        if (args[0].equalsIgnoreCase("chat") && LPprefixes.getInstance().getConfig().getBoolean("chatprefix.Allow") && player.hasPermission("LPprefixes.chat")) {
            if (args.length < 2) {
                player.sendMessage("§cДоступные аргументы: clear | set");
                return true;
            }
            if (args[1].equalsIgnoreCase("clear")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chatty:prefix " + player.getName() + " clear");
                player.sendMessage(LPprefixes.getInstance().getConfig().getString("chatprefix.clear").replaceAll("&", "§"));
                return true;
            }
            if (args[1].equalsIgnoreCase("set")) {
                if (args.length < 3){
                    player.sendMessage("§cУкажите префикс! /prefix chat set [префикс]");
                    return true;
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chatty:prefix " + player.getName() + " " + args[2]);
                player.sendMessage(LPprefixes.getInstance().getConfig().getString("chatprefix.set").replaceAll("&", "§"));
                return true;
            }
        }
        if(!player.hasPermission("LPprefixes.chat")){
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("no-perm").replaceAll("&", "§"));
        }
        return true;
    }

}
