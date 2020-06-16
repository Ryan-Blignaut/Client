package theSilverEcho.tweaks.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import theSilverEcho.tweaks.config.Config;
import theSilverEcho.tweaks.cosmetic.Brightness;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuScreen extends Screen
{
	private final List<MenuButton> menuButtonList = new ArrayList<>();
	private static final double scale = MinecraftClient.getInstance().getWindow().getScaleFactor();
	private boolean dragging;
	private int lastX;
	private int lastY;
	private boolean keyDown;
	private int menuYOffset;
	private int menuXOffset;

	@Override protected void init()
	{
		super.init();
		menuButtonList.add(new MenuButton(123, 32, 50, 10, "render", button -> System.out.println("wow")));
		menuButtonList.add(new MenuButton(123, 32, 50, 10, "Settings", button -> System.out.println("wow")));

		menuButtonList.add(new MenuCheckBoxButton(24, 24, 6, 6, "test", Config.isBrightnessEnabled(), button ->
		{
			Brightness.toggleBrightness();
			button.setChecked(Config.isBrightnessEnabled());
		}));


		//		menuButtonList.add(new MenuButton(1, 1, 54, 54, "test", button -> System.out.println("r")));

	}

	public MenuScreen()
	{
		super(new LiteralText("test"));
	}

	@Override public void render(int mouseX, int mouseY, float delta)
	{
		menuYOffset = Config.getMenuYOffset();
		menuXOffset = Config.getMenuXOffset();
		if (dragging && keyDown)
		{
			Config.setMenuXOffset(menuXOffset + mouseX - lastX);
			Config.setMenuYOffset(menuYOffset + mouseY - lastY);
		}
		lastX = mouseX;
		lastY = mouseY;

		// own imp ->		super.render(mouseX, mouseY, delta);
		GL11.glLineWidth(2);
		GuiHelper.fill(GL11.GL_QUADS, menuXOffset, menuYOffset, menuXOffset + (550) / scale, menuYOffset + (650) / scale,
				new Color(32, 32, 38).getRGB());
		GuiHelper.fill(GL11.GL_QUADS, menuXOffset + 10 / scale, menuYOffset + 45 / scale, menuXOffset + (550 - 12) / scale,
				menuYOffset + (650 - 12) / scale, new Color(22, 22, 28).getRGB());
		GuiHelper.fill(GL11.GL_QUADS, menuXOffset, menuYOffset + 30 / scale, menuXOffset + (549) / scale, menuYOffset + (6 + 30) / scale,
				/*new Color(73, 73, 82).getRGB()+*/ Color.CYAN.getRGB());
		GuiHelper.fill(GL11.GL_LINE_LOOP, menuXOffset, menuYOffset, menuXOffset + (550) / scale, menuYOffset + (650) / scale,
				new Color(27, 27, 33).getRGB());
		GuiHelper.fill(GL11.GL_LINE_LOOP, menuXOffset + 10 / scale, menuYOffset + 45 / scale, menuXOffset + (550 - 12) / scale,
				menuYOffset + (650 - 12) / scale, new Color(36, 36, 41).getRGB());

		GuiHelper.fill(GL11.GL_QUADS, menuXOffset + 24 / scale, menuYOffset + 60 / scale, menuXOffset + (243) / scale, menuYOffset + (249) / scale,
				new Color(20, 20, 20).getRGB());
		GuiHelper.fill(GL11.GL_QUADS, menuXOffset + 25 / scale, menuYOffset + 61 / scale, menuXOffset + (242) / scale, menuYOffset + (248) / scale,
				new Color(73, 73, 86).getRGB());
		GuiHelper.fill(GL11.GL_QUADS, menuXOffset + 26 / scale, menuYOffset + 62 / scale, menuXOffset + (241) / scale, menuYOffset + (247) / scale,
				new Color(33, 33, 39).getRGB());
		GL11.glLineWidth(1);


		menuButtonList.forEach(menuButton -> menuButton.setXOffset(menuXOffset).setYOffset(menuYOffset).render(mouseX, mouseY, delta));

	}

	@Override public boolean mouseClicked(double mouseX, double mouseY, int button)
	{
		if (isMouseOver(mouseX, mouseY))
			dragging = true;
		return super.mouseClicked(mouseX, mouseY, button);
	}

	@Override public boolean mouseReleased(double mouseX, double mouseY, int button)
	{
		menuButtonList.forEach(menuButton -> menuButton.mouseClicked(mouseX, mouseY, button));
		dragging = false;
		return super.mouseReleased(mouseX, mouseY, button);
	}

	@Override public boolean keyPressed(int keyCode, int scanCode, int modifiers)
	{
		if (keyCode == GLFW.GLFW_KEY_LEFT_CONTROL)
			keyDown = true;
		return super.keyPressed(keyCode, scanCode, modifiers);
	}

	@Override public boolean keyReleased(int keyCode, int scanCode, int modifiers)
	{
		if (keyCode == GLFW.GLFW_KEY_LEFT_CONTROL)
			keyDown = false;
		return super.keyReleased(keyCode, scanCode, modifiers);
	}

	@Override public boolean isMouseOver(double mouseX, double mouseY)
	{
		return mouseX >= Config.getMenuXOffset() / scale && mouseY >= Config.getMenuYOffset() / scale && mouseX < (Config
				.getMenuXOffset() + (550) / scale) && mouseY < (Config.getMenuYOffset() + (650) / scale);
	}

	@Override public boolean isPauseScreen()
	{
		return false;
	}

	@Override public void onClose()
	{
		super.onClose();
	}

	//	@Override public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY)
	//	{
	//		if (isMouseOver(mouseX, mouseY) && button == 0)
	//		{
	//			xOffset = (float) (mouseX);
	//			yOffset = (float) (mouseY);
	//		}
	//		return false;
	//	}
}
