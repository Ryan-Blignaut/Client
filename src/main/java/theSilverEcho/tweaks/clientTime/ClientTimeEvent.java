/*
package theSilverEcho.tweaks.clientTime;

import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.network.INetHandler;
import net.minecraft.network.listener.PacketListener;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import theSilverEcho.tweaks.Tweaks;

public class ClientTimeEvent
{
	public static final MinecraftClient instance = MinecraftClient.getInstance();
	@SubscribeEvent public static void time(TickEvent.ClientTickEvent event)
	{
		if (instance.world != null)
		{

			PacketListener parent = instance.player.networkHandler.getConnection().getPacketListener();

			if (!(parent instanceof ClientTimeNetHelper ))
			{
				instance.player.networkHandler.getConnection()
						.setPacketListener(new ClientTimeNetHelper((ClientPlayNetworkHandler) parent));
			}
//			if (Tweaks.TIME_TYPES == TimeTypes.FAST)
//				Tweaks.proxy.getClientWorld().setDayTime((long)(System.currentTimeMillis() * Tweaks.SPEED % 24000.0));
		}
	}

}
*/
