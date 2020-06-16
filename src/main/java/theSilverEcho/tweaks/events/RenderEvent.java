package theSilverEcho.tweaks.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.util.math.MatrixStack;

public interface RenderEvent
{
	Event<RenderEvent> EVENT = EventFactory.createArrayBacked(RenderEvent.class, (listeners) -> (matrices, partialTicks) ->
	{
		for (RenderEvent listener : listeners)
		{
			listener.render(matrices, partialTicks);
		}
	});

	void render(MatrixStack matrices, float partialTicks);

}
