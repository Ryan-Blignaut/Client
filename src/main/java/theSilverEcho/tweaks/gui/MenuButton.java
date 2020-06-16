package theSilverEcho.tweaks.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import org.lwjgl.opengl.GL11;
import theSilverEcho.tweaks.Tweaks;

import java.awt.*;

public class MenuButton extends GuiHelper implements Drawable, Element
{

	protected double xOffset;
	protected double yOffset;

	protected final double x;
	protected final double y;
	protected final double width;
	protected final double height;
	protected final String text;
	protected final MenuButton.PressAction onPress;
	private final Color color = new Color(123, 255, 122, 255);

	public MenuButton(double x, double y, double width, double height, String text, PressAction onPress)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.onPress = onPress;
	}

	@Override public void render(int mouseX, int mouseY, float delta)
	{
		//		if (checked)
		//			color = new Color(0, 0, 255, 255);
		//		else
		//			color = new Color(0, 255, 0, 255);
		fill(GL11.GL_QUADS, x + xOffset, y + yOffset, x + width + xOffset, y + height + yOffset, color.getRGB());
		TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
		Tweaks.renderer.drawString(text, ((float) (x + xOffset)), (float) ((float) (y + height / 2-textRenderer.fontHeight) + yOffset), -1,false,1);
//		textRenderer.draw(text, ((float) (x + xOffset)), (float) ((float) (y + height / 2-textRenderer.fontHeight) + yOffset), -1);
	}

	@Override public boolean mouseClicked(double mouseX, double mouseY, int button)
	{
		if (this.isMouseOver(mouseX, mouseY))
		{
			onPress();
			return true;
		}
		return false;
	}

	public void onPress()
	{
		this.onPress.onPress(this);
	}

	@Override public boolean isMouseOver(double mouseX, double mouseY)
	{
		return mouseX >= this.x + xOffset && mouseY >= this.y + yOffset && mouseX < (this.x + this.width + xOffset) && mouseY < (this.y + this.height + yOffset);
	}

	public interface PressAction
	{
		void onPress(MenuButton button);
	}

	protected MenuButton setXOffset(double xOffset)
	{
		this.xOffset = xOffset;
		return this;
	}

	public MenuButton setYOffset(double yOffset)
	{
		this.yOffset = yOffset;
		return this;
	}
}
