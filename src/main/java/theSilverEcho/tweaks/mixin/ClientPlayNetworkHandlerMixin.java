package theSilverEcho.tweaks.mixin;

import net.fabricmc.fabric.api.event.network.C2SPacketTypeCallback;
import net.minecraft.client.network.packet.WorldTimeUpdateS2CPacket;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.server.network.packet.ChatMessageC2SPacket;
import net.minecraft.util.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

import static theSilverEcho.tweaks.Tweaks.TIME_TYPE;

@Mixin(WorldTimeUpdateS2CPacket.class) public abstract class ClientPlayNetworkHandlerMixin
{
	@Shadow private long time;
	@Shadow private long timeOfDay;

	@Inject(method = "write", at = @At("HEAD")) public void WorldTimeUpdateS2CPacket(PacketByteBuf buf, CallbackInfo ci)
	{
		ci.cancel();
		buf.writeLong(this.time);
		System.out.println("ww");
		switch (TIME_TYPE)
		{
		case DAY:
			buf.writeLong(-6000L);
			break;
		case SUNSET:
			buf.writeLong(-22880L);
			break;
		case NIGHT:
			buf.writeLong(-18000L);
			break;
		case FAST:
			buf.writeLong(this.timeOfDay * 2);
			break;
		default:
			buf.writeLong(this.timeOfDay);
		}
	}


	/*	if (!(TIME_TYPE == TimeTypes.VANILLA))
		{
//			ci.cancel();
			this.time = time;
			switch (TIME_TYPE)
			{
			case DAY:
				this.timeOfDay = -6000L;
				break;
			case SUNSET:
				this.timeOfDay = -22880L;
				break;
			case NIGHT:
				this.timeOfDay = -18000L;
				break;
			case FAST:
				this.timeOfDay = timeOfDay * 2;
			default:
				this.timeOfDay = timeOfDay;
			}
		}*/

	@Shadow public abstract void apply(ClientPlayPacketListener clientPlayPacketListener);

	@Shadow public abstract void read(PacketByteBuf buf) throws IOException;

	//	@Shadow public abstract void write(PacketByteBuf buf) throws IOException;

	@Shadow public abstract long getTime();

	@Shadow public abstract long getTimeOfDay();
}
