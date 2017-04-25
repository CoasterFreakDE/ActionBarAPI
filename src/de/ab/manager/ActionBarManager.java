package de.ab.manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.ab.main.Main;
import de.ab.utils.TitleManager;


public class ActionBarManager {

	public List<String> queue;
	
	public ActionBarManager() {
		queue = new ArrayList<String>();
		schedule();
	}
	
	public void add(String message) {
		queue.add(message);
	}
	
	public void schedule() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(Main.INSTANCE, new Runnable() {
			
			@Override
			public void run() {
				
				if(queue.size() > 0) {
					if(queue.get(0) != null) {
						String send = queue.get(0);
						
						if(send.startsWith("send_")) {
							String player = send.split(" ")[0].replace("send_", "");
							String message = send.replace("send_" + player, " ");
							
							try {
								TitleManager.sendActionBar(Bukkit.getPlayer(player), message);
							} catch (ClassNotFoundException | NoClassDefFoundError e) {
								e.printStackTrace();
							}
						}
						else {
							for(Player p : Bukkit.getOnlinePlayers()) {
								try {
									TitleManager.sendActionBar(p, send);
								} catch (ClassNotFoundException | NoClassDefFoundError e) {
									e.printStackTrace();
								}
							}
						}
						
						queue.remove(0);
					}
				}
			}
		}, 20, 1);
	}
	
}
