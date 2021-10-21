package ru.naulbimix.nlbBooster.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import ru.naulbimix.nlbBooster.Main;
import ru.naulbimix.nlbBooster.utils.DataConfig;

public class CommandBooster extends Command {

    public DataConfig dataConfig = Main.getDataConfig();

    public CommandBooster() {
        super("booster", null, new String[]{"nlbbooster"});
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        if(s.hasPermission(dataConfig.permissionBooster)) {
            if(args.length == 1) {
                int value;
                try{
                    value = (int) Math.round(Double.parseDouble(args[0]));
                    dataConfig.setBoost(value);
                    s.sendMessage(dataConfig.newValue
                            .replace("$value", String.valueOf(value))
                    );
                }catch(Exception e) {
                    s.sendMessage(dataConfig.noBoostValue);
                }
            }else{
                s.sendMessage(dataConfig.usage);
            }
        }else{
            s.sendMessage(dataConfig.noPermission);
        }
    }
}
