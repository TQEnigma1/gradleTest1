package com.starlitmc

import com.mojang.brigadier.context.CommandContext
import com.starlitmc.extensions.failure
import com.starlitmc.extensions.getArgument
import com.starlitmc.extensions.sendMessage
import com.starlitmc.extensions.success
import net.minecraft.server.command.ServerCommandSource
import net.silkmc.silk.commands.command

private val logger =
    StarlitTemplate
        .logger // if you need to log something grab the main logger and then logger.info or .debug
// .debug only shows up when its setup, .info will always show in console

val exampleCommand =
    command("example") { // main command node with autocomplete
        runs { runMain(this) }
        literal(
            "sub1") { // any literals will get suggested with autocomplete after their previous node
            // we run our logic here, passing the context in with "this"
            runs { runSub1(this) }
        }
        argument<String>("sub2") { sub2
            -> // here we pass in the argument to be used inside the lambda
            // this will suggest the player argument options with autocomplete, it can be a call to
            // a function that returns a list
            suggestList { listOf("hello", "world") }
            // we use the argument passed in here, its a function call to resolve the argument
            // alternatively the utils has ctx.getArgument for any unsupported arg types like
            // ServerPlayerEntity, use this
            // inside the function and dont pass in the argument
            runs { runSub2(this, sub2()) }
        }
    }

private fun runMain(ctx: CommandContext<ServerCommandSource>): Int {
    // we always pass down commandContext, this has our crucial info... its the... command
    // context...
    val player =
        ctx.source?.player
            ?: return ctx.failure(
                "if they arent we can send them a failure telling them they must be a player to use it")

    player.sendMessage("test")
    return ctx.success(
        "if the command succeeds we send a success",
        true) // the boolean logs the command success to file, eg for staff abuse etc etc, it
    // defaults to false if not included
}

private fun runSub1(ctx: CommandContext<ServerCommandSource>) {}

private fun runSub2(ctx: CommandContext<ServerCommandSource>, ourStringArgument: String) {
    val ourStringArgumentAlternative = ctx.getArgument<String>("sub2")
}
