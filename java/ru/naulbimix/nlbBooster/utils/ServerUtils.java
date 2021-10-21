package ru.naulbimix.nlbBooster.utils;

import java.io.*;
import java.nio.file.*;
import java.util.logging.*;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.*;
import net.md_5.bungee.config.*;
import ru.naulbimix.nlbBooster.*;

public class ServerUtils {

    private static Configuration config;
    private static Main plugin = Main.getInstance();

    public static String s(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void Logger(String type, String message) {
        type = type.toUpperCase();
        type = type.equals("ERROR") ? "SEVERE" : (type.equals("WARN") ? "WARNING" : type);
        plugin.getLogger().log(Level.parse(type), s(message));
    }

    public static void saveDefaultConfig() {
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdir();
            }
            File file = new File(plugin.getDataFolder(), "config.yml");
            if (!file.exists()) {
                Files.copy(plugin.getResourceAsStream("config.yml"), file.toPath(), new CopyOption[0]);
            }
            loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfig() {
        loadConfig();
    }

    public static void loadConfig() {
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuration getConfig() {
        return config;
    }
}
