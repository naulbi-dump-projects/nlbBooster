package ru.naulbimix.nlbBooster.listeners;

import net.md_5.bungee.BungeeCord;
import ru.naulbimix.nlbBooster.Main;
import ru.naulbimix.nlbBooster.utils.DataConfig;

public class CustomListener {

    private int fakeOnline;
    private int online;
    private BungeeCord bungeeCord;
    private static DataConfig dataConfig = Main.dataConfig;

    public CustomListener() {
        bungeeCord = BungeeCord.getInstance();
        this.online = bungeeCord.getOnlineCount();
        boostOnline();
    }

    public void setFakeOnline(int fakeOnline) {
        this.fakeOnline = fakeOnline;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getOnline() {
        setOnline(bungeeCord.getOnlineCount());
        return online;
    }

    public int getFakeOnline() {
        boostOnline();
        return fakeOnline;
    }

    public void boostOnline() {
        this.fakeOnline =  (int)Math.round(((double)this.online) * dataConfig.boost);
    }
}
