package nxt.extensions.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent

class OnJoinListener : Listener {

    @EventHandler
    fun onChat(event: AsyncPlayerChatEvent) {
        event.format = "§b<Spawn> §a${event.player.name} §7» §f${event.message}"
    }

    @EventHandler(priority = org.bukkit.event.EventPriority.HIGHEST)
    fun onPlayerJoin(event: PlayerJoinEvent): Unit = with(event) {
        player.performCommand("spawn")
        joinMessage = "§b<Spawn> §a${player.name} joined the game"
    }

    @EventHandler(priority = org.bukkit.event.EventPriority.HIGHEST)
    fun onPlayerQuit(event: org.bukkit.event.player.PlayerQuitEvent): Unit = with(event) {
        quitMessage = "§c${player.name} left the game"
    }
}