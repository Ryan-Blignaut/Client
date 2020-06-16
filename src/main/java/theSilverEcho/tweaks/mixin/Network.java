package theSilverEcho.tweaks.mixin;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.packet.CommandTreeS2CPacket;
import net.minecraft.client.network.packet.WorldTimeUpdateS2CPacket;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.command.CommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
import static theSilverEcho.tweaks.Tweaks.TIME_TYPE;

@Mixin(ClientPlayNetworkHandler.class) public abstract class Network
{

	@Shadow private CommandDispatcher<CommandSource> commandDispatcher;

//	@Shadow public abstract void onWorldTimeUpdate(WorldTimeUpdateS2CPacket packet);

	@Inject(method = "<init>", at = @At("RETURN")) private void init(MinecraftClient client, Screen screen, ClientConnection connection,
			GameProfile profile, CallbackInfo ci)
	{
		commandDispatcher.register(literal("config"));
	}

	@Shadow private MinecraftClient client;
	@Shadow private ClientWorld world;

	/*@Inject(method = "onWorldTimeUpdate", at = @At("HEAD"), cancellable = true) private void run(WorldTimeUpdateS2CPacket packet, CallbackInfo ci)
	{
		ci.cancel();
		this.world.setTime(packet.getTime());
		switch (TIME_TYPE)
		{
		case DAY:
			this.world.setTimeOfDay(-6000L);
			break;
		case SUNSET:
			this.world.setTimeOfDay(-22880L);
			break;
		case NIGHT:
			this.world.setTimeOfDay(-18000L);
			break;
		case FAST:
			this.world.setTimeOfDay(packet.getTimeOfDay()*2);
			break;
		case VANILLA:
			this.world.setTimeOfDay(packet.getTimeOfDay());
			break;
		}
	}*/

	@Inject(method = "onCommandTree", at = @At("RETURN")) private void onCommandTree(CommandTreeS2CPacket packet, CallbackInfo ci)
	{
		commandDispatcher.register(literal("config"));
	}

}
