package lpprefixes.lpprefixes;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class LPprefixes extends JavaPlugin {
    private static LPprefixes instance;
    private static String prefix = "§6[§aLPprefixes§6]§b ";

    @Override
    public void onEnable() {
        log("-----------------------------");
        log("Плагин LPprefixes включен!   ");
        log("Написал: Link_play           ");
        log("-----------------------------");
        instance = this;
        saveDefaultConfig();
        registerCommands();
    }

    public static LPprefixes getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        log("-----------------------------");
        log("Плагин LPprefixes выключен!  ");
        log("Написал: Link_play           ");
        log("-----------------------------");
    }

    public void registerCommands() {
        getCommand("prefix").setExecutor((CommandExecutor)new PrefixCommand());
        getCommand("lpprefixes").setExecutor((CommandExecutor)new PLreload());
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(String.valueOf(getPrefix()) + message);
    }

    public static String getPrefix() {
        return prefix;
    }

}
