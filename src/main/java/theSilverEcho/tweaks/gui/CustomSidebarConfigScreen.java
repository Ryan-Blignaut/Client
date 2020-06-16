package theSilverEcho.tweaks.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import theSilverEcho.tweaks.Tweaks;
import theSilverEcho.tweaks.config.Config;
import theSilverEcho.tweaks.config.ModSlider;

public class CustomSidebarConfigScreen extends Screen
{
	private boolean dragging;
	private int lastX;
	private int lastY;

	public CustomSidebarConfigScreen()
	{
		super(new LiteralText("SidebarConfig1"));
	}

	@Override public void render(int mouseX, int mouseY, float delta)
	{
		super.render(mouseX, mouseY, delta);
		if (dragging)
		{
			Config.setSidebarXOffset(Config.getSidebarXOffset() + mouseX - lastX);
			Config.setSidebarYOffset(Config.getSidebarYOffset() + mouseY - lastY);
		}
		lastX = mouseX;
		lastY = mouseY;
	}

	@Override protected void init()
	{
		super.init();

		int center = this.width / 2 - 150 / 2;

		ModSlider redSlider = new ModSlider(center, 20, Config.getSidebarRed(), "Red");
		redSlider.setRunnable(() -> Config.setSidebarRed((int) (redSlider.getSliderValue() * 255)));
		this.addButton(redSlider);

		ModSlider greenSlider = new ModSlider(center, 40, Config.getSidebarGreen(), "Green");
		greenSlider.setRunnable(() -> Config.setSidebarGreen((int) (greenSlider.getSliderValue() * 255)));
		this.addButton(greenSlider);

		ModSlider blueSlider = new ModSlider(center, 60, Config.getSidebarBlue(), "Blue");
		blueSlider.setRunnable(() -> Config.setSidebarBlue((int) (blueSlider.getSliderValue() * 255)));
		this.addButton(blueSlider);

		ModSlider alphaSlider = new ModSlider(center, 80, Config.getSidebarAlpha(), "alpha");
		alphaSlider.setRunnable(() -> Config.setSidebarAlpha((int) (alphaSlider.getSliderValue() * 255)));
		this.addButton(alphaSlider);

	/*	ModSlider sizeSlider = new ModSlider(center, 100, Config.getSidebarSize(), "size");
		sizeSlider.setRunnable(() -> Config.setSidebarSize((float) (sizeSlider.getSliderValue()*2)));
		this.addButton(sizeSlider);*/

	}

	//	@Override public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY)
	//	{
	//		super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
	//		boolean mouseIn = Tweaks.customSidebar.isMouseIn((int) mouseX, (int) mouseY);
	//		if (mouseIn && Tweaks.customSidebar != null)
	//		{
	//
	//			//			Config.setSidebarXOffset(
	//			//					(int) (Config.getSidebarXOffset() + (mouseX * scale  /*/ scale*//* + Math.signum(deltaX)*scale*//*Math.signum(deltaX)*/)));
	//			//			Config.setSidebarYOffset((int) (/*Config.getSidebarYOffset() +*/ (scale)));
	//			return true;
	//		}
	//		//		Config.setSidebarYOffset(0);
	//		//		Config.setSidebarXOffset(0);
	//
	//		return true;
	//	}

	@Override public boolean mouseClicked(double mouseX, double mouseY, int button)
	{
		super.mouseClicked(mouseX, mouseY, button);
		if (Tweaks.customSidebar.isMouseIn(mouseX, mouseY))
			dragging = true;
		return true;
	}

	@Override public boolean mouseReleased(double mouseX, double mouseY, int button)
	{
		super.mouseReleased(mouseX, mouseY, button);
		dragging = false;
		return true;
	}

	@Override public boolean mouseScrolled(double d, double e, double amount)
	{

		if (Tweaks.customSidebar.isMouseIn(((int) d), ((int) e)))
		{
			if (Config.getSidebarSize() + 0.1 * Math.signum(amount) > 0.5 && Config.getSidebarSize() + 0.1 * Math.signum(amount) < 3)
				Config.setSidebarSize((float) (Config.getSidebarSize() + 0.1 * Math.signum(amount)));

		}
		return true;
	}
}
