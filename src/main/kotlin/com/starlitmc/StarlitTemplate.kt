package com.starlitmc

import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.server.MinecraftServer
import net.minecraft.server.dedicated.MinecraftDedicatedServer
import net.minecraft.server.network.ServerPlayNetworkHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object StarlitTemplate : DedicatedServerModInitializer {
    val logger: Logger = LoggerFactory.getLogger("Template")
    lateinit var server: MinecraftDedicatedServer

    override fun onInitializeServer() {
        registerListeners()
        initCommands()
        logger.info("StarlitPlaceholder initialized")
    }
    private fun registerListeners() {
        ServerLifecycleEvents.SERVER_STARTED.register { server ->
            StarlitTemplate.server = server as MinecraftDedicatedServer
        }
        ServerPlayConnectionEvents.JOIN.register {
            handler: ServerPlayNetworkHandler,
            _: PacketSender?,
            _: MinecraftServer? ->
        }
    }
    private fun initCommands() {
        // here we define any commands based on the val assigned in their file
        exampleCommand
    }
}
