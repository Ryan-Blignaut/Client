/*
package theSilverEcho.tweaks.clientTime;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;

import static theSilverEcho.tweaks.Tweaks.SPEED;
import static theSilverEcho.tweaks.Tweaks.TIME_TYPES;

public class ClientTimeCommand
{

	public static ArgumentBuilder<CommandSource, ?> register()
	{
		return Commands.literal("time").requires(cs -> cs.hasPermissionLevel(0)).executes(context -> {
			context.getSource().sendFeedback(new StringTextComponent("Client time is currently: " + TIME_TYPES), false);
			return 0;
		}).then(Commands.literal("day").executes(context -> {
			TIME_TYPES = TimeTypes.DAY;
			context.getSource().sendFeedback(new StringTextComponent("Client time set to day"), false);
			return 0;
		})).then(Commands.literal("sunset").executes(context -> {
			TIME_TYPES = TimeTypes.SUNSET;
			context.getSource().sendFeedback(new StringTextComponent("Client time set to sunset"), false);
			return 0;
		})).then(Commands.literal("night").executes(context -> {
			TIME_TYPES = TimeTypes.NIGHT;
			context.getSource().sendFeedback(new StringTextComponent("Client time set to night"), false);
			return 0;
		})).then(Commands.literal("speed").then(Commands.argument("modifier", IntegerArgumentType.integer(0, 100)).executes(context -> {
			TIME_TYPES = TimeTypes.FAST;
			SPEED = IntegerArgumentType.getInteger(context, "modifier");
			context.getSource().sendFeedback(new StringTextComponent("Client time sped up by: " + SPEED), false);
			return 0;
		}))).then(Commands.literal("reset").executes(context -> {
			TIME_TYPES = TimeTypes.VANILLA;
			context.getSource().sendFeedback(new StringTextComponent("Reset client time"), false);
			return 0;
		}));
	}

}
*/
