package de.ab.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.ab.manager.ActionBarManager;

public class Main extends JavaPlugin {

	public static Main INSTANCE;
	public static String PREFIX;
	private static ActionBarManager abm;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		PREFIX = "§6§l┃ §eActionBarAPI §7§o";
		
		setAbm(new ActionBarManager());
		
		Bukkit.getConsoleSender().sendMessage(PREFIX + "§a§oAPI enabled.");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(PREFIX + "§c§oAPI disabled.");
	}

	public static ActionBarManager getAbm() {
		return abm;
	}

	public static void setAbm(ActionBarManager abm) {
		Main.abm = abm;
	}
}
