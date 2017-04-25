package de.ab.api;

import org.bukkit.entity.Player;

import de.ab.main.Main;

public class ActionAPI {

	/**
	 * Send a private Actionbar message to a player
	 * @param p
	 * @param message
	 */
	public static void sendMessage(Player p, String message) {
		broadcast("send_" + p.getName() + " " + message);
	}
	
	/**
	 * Send a message to all players on the server
	 * @param message
	 */
	public static void broadcast(String message) {
		Main.getAbm().add(message);
	}
}
