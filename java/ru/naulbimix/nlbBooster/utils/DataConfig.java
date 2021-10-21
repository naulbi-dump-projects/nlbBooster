package ru.naulbimix.nlbBooster.utils;

import net.md_5.bungee.config.Configuration;

public class DataConfig {

    public String noPermission, usage, newValue, online, permissionBooster, noBoostValue, commandOnline;
    public double boost;
    public Configuration config;

    public DataConfig(Configuration configuration) {
        this.config = configuration;
        this.noPermission = ServerUtils.s(this.config.getString("messages.noPermission"));
        this.usage = ServerUtils.s(this.config.getString("messages.usage"));
        this.newValue = ServerUtils.s(this.config.getString("messages.newValue"));
        this.commandOnline = ServerUtils.s(this.config.getString("settings.permission.online"));
        this.noBoostValue = ServerUtils.s(this.config.getString("messages.noBoostValue"));
        this.online = ServerUtils.s(this.config.getString("messages.online"));
        this.permissionBooster = this.config.getString("settings.permission.booster");
        this.boost = this.config.getDouble("settings.boost");
    }

    public double getBoost() {
        return this.config.getDouble("settings.boost");
    }

    public void setBoost(double value) {
        this.boost = value;
        this.config.set("settings.boost", value);
    }
}
