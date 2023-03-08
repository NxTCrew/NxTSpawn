package nxt.extensions.commands

import nxt.base.reflection.types.NxTCommand
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@NxTCommand(
    namespace = "nxt-utils",
    name = "spawn",
    description = "Teleport to the spawn",
    usage = "/spawn",
    aliases = ["hub"],
)
class SpawnCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("§cOnly players can execute this command!")
            return true
        }

        sender.teleport(sender.world.spawnLocation)
        sender.playSound(sender, Sound.ENTITY_FOX_TELEPORT, 0.2f, 1.4f)
        return true
    }
}