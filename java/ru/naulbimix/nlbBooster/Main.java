package ru.naulbimix.nlbBooster;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import ru.naulbimix.nlbBooster.commands.CommandBooster;
import ru.naulbimix.nlbBooster.commands.CommandOnline;
import ru.naulbimix.nlbBooster.listeners.CustomListener;
import ru.naulbimix.nlbBooster.listeners.EventListener;
import ru.naulbimix.nlbBooster.utils.DataConfig;
import ru.naulbimix.nlbBooster.utils.ServerUtils;

public class Main extends Plugin {

    private static Main plugin;
    public static DataConfig dataConfig;
    public static CustomListener customListener;

    @Override
    public void onEnable() {
        plugin = this;
        ServerUtils.Logger("info", "&aЗапуск &7плагина &enlbBooster &7версии &e" + getDescription().getVersion() + " &7от &eNaulbiMIX&7! &f| &6Sponsored by FlatiCommunity (https://t.me/flaticommunity)");
        try {
            ServerUtils.saveDefaultConfig();
            dataConfig = new DataConfig(ServerUtils.getConfig());
            customListener = new CustomListener();
            PluginManager pluginManager = getProxy().getPluginManager();
            pluginManager.registerCommand(this, new CommandBooster());
            pluginManager.registerCommand(this, new CommandOnline());
            pluginManager.registerListener(this, new EventListener());
            ServerUtils.Logger("info", "&7Плагин &enlbBooster &7версии &e" + getDescription().getVersion() + " &7от &eNaulbiMIX &7был &aуспешно &eзапущен!");
        }catch(Exception e) {
            ServerUtils.Logger("error", "&7Произошла &cошибка &7в плагине &enlbBooster&7! Причина ошибки: &eНеизвестно! &7Подробности: &c" + e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        ServerUtils.Logger("info", "&cВыключение &7плагина &enlbBooster &7версии &e" + getDescription().getVersion() + " &7от &eNaulbiMIX &7(t.me/naulbimix)");
    }

    public static Main getInstance() {
        return plugin;
    }

    public static DataConfig getDataConfig() {
        return dataConfig;
    }
}
