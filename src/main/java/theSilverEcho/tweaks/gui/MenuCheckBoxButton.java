package theSilverEcho.tweaks.gui;

import org.lwjgl.opengl.GL11;
import theSilverEcho.tweaks.Tweaks;

import java.awt.*;

public class MenuCheckBoxButton extends MenuButton
{
	private boolean checked;
	protected final MenuCheckBoxButton.PressAction onPress;

	public MenuCheckBoxButton(double x, double y, double width, double height, String text, boolean checked, PressAction onPress)
	{
		super(x, y, width, height, text, null);
		this.onPress = onPress;
		this.checked = checked;
	}

	@Override public void render(int mouseX, int mouseY, float delta)
	{
		Color color;
		if (checked)
			color = new Color(180, 180, 184, 255);
		else
			color = new Color(73, 74, 82, 255);
		fill(GL11.GL_QUADS, this.x - 0.5 + xOffset, this.y - 0.5 + yOffset, this.x + this.width + 0.5 + xOffset, this.y + this.height + 0.5 + yOffset,
				new Color(26, 26, 32).getRGB());
		fill(GL11.GL_QUADS, this.x + xOffset, this.y + yOffset, this.x + this.width + xOffset, this.y + this.height + yOffset, color.getRGB());

		Tweaks.renderer.drawString(text, ((float) (x + width + xOffset)), (float) (yOffset + (y + Tweaks.renderer.getFontHeight()) * 2), -1, false,
				1);
	}

	public void setChecked(boolean checked)
	{
		this.checked = checked;
	}

	@Override public void onPress()
	{
		this.onPress.onPress(this);
	}

	public interface PressAction
	{
		void onPress(MenuCheckBoxButton button);
	}
}
