package nxt.extensions

import de.fruxz.ascend.extension.logging.getItsLogger
import nxt.base.extensions.types.NxTExtension

class NxTSpawn : NxTExtension() {

    override fun onLoad() {
        getItsLogger().info("NxTSpawn ${pluginInfo.version} loaded")
    }

    override fun onEnable() {
        getItsLogger().info("NxTSpawn ${pluginInfo.version} enabled")
    }

    override fun onDisable() {
        getItsLogger().info("NxTSpawn ${pluginInfo.version} disabled")
    }
}