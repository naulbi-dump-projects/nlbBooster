package ru.naulbimix.nlbBooster.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import ru.naulbimix.nlbBooster.Main;
import ru.naulbimix.nlbBooster.utils.DataConfig;

public class CommandOnline extends Command {

    public Main plugin = Main.getInstance();
    public DataConfig dataConfig = Main.getDataConfig();

    public CommandOnline() {
        super("online", null, new String[]{"nlbonline", "fakeonline", "list"});
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        if(s.hasPermission(dataConfig.commandOnline)) {
            s.sendMessage(dataConfig.online
                    .replace("$onlineBoost", String.valueOf(plugin.customListener.getFakeOnline()))
                    .replace("$online", String.valueOf(plugin.customListener.getOnline()))
                    .replace("$boost", String.valueOf(dataConfig.boost))
            );
        }else{
            s.sendMessage(dataConfig.noPermission);
        }
    }
}
