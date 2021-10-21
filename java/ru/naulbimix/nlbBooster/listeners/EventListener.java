package ru.naulbimix.nlbBooster.listeners;

import net.md_5.bungee.api.*;
import net.md_5.bungee.event.*;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.*;
import ru.naulbimix.nlbBooster.Main;

public class EventListener implements Listener {

    public static CustomListener customListener = Main.customListener;

    @EventHandler(priority = EventPriority.HIGH)
    public void onProxyPing(ProxyPingEvent e) {
        ServerPing ping = e.getResponse();
        ServerPing.Players players = ping.getPlayers();
        customListener.setOnline(players.getOnline());
        ping.getPlayers().setOnline(customListener.getFakeOnline());
        ping.setPlayers(players);
        e.setResponse(ping);
    }
}