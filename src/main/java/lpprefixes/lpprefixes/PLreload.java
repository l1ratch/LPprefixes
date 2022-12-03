package lpprefixes.lpprefixes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PLreload implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if (player.hasPermission("LPprefixes.Admin")){
            if (args.length == 0) {
                sender.sendMessage("§a§lДоступные аргументы: §6§l/lpprefixes reload | help");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                LPprefixes.getInstance().reloadConfig();
                sender.sendMessage("§aКонфиг плагина LPprefixes перезагружен! §bСоздатель: vk.com/l1nkplay");
                return true;
            }
            if (args[0].equalsIgnoreCase("help")) {
                List<String> list = LPprefixes.getInstance().getConfig().getStringList("helps");
                for (String s : list) {
                    player.sendMessage(s);
                }
            }
            if (args[0].equalsIgnoreCase("on")) {
                if(args[1].equalsIgnoreCase("all")){
                    LPprefixes.getInstance().getConfig().set("prefix.Allow", true);
                }
                if(args[1].equalsIgnoreCase("tab")){
                    LPprefixes.getInstance().getConfig().set("tabprefix.Allow", true);
                }
                if(args[1].equalsIgnoreCase("chat")){
                    LPprefixes.getInstance().getConfig().set("chatprefix.Allow", true);
                }
            }
            if (args[0].equalsIgnoreCase("off")) {
                if(args[1].equalsIgnoreCase("all")){
                    LPprefixes.getInstance().getConfig().set("prefix.Allow", false);
                }
                if(args[1].equalsIgnoreCase("tab")){
                    LPprefixes.getInstance().getConfig().set("tabprefix.Allow", false);
                }
                if(args[1].equalsIgnoreCase("chat")){
                    LPprefixes.getInstance().getConfig().set("chatprefix.Allow", false);
                }
            }
        } else {
            player.sendMessage(LPprefixes.getInstance().getConfig().getString("no-permsReload").replaceAll("&", "§"));
        }
        return true;
    }

}
