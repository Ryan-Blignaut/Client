package theSilverEcho.tweaks.mixin;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import theSilverEcho.tweaks.Tweaks;
import theSilverEcho.tweaks.cosmetic.GLSLSandboxShader;
import theSilverEcho.tweaks.gui.CustomButton;
import theSilverEcho.tweaks.gui.GuiHelper;
import theSilverEcho.tweaks.gui.ParticleSystem;
import theSilverEcho.tweaks.notification.NotificationManager;

import java.awt.*;
import java.io.IOException;

@Mixin(TitleScreen.class) public abstract class TitleScreenMixin extends Screen
{
	private static final Identifier Background = new Identifier("tweaks", "textures/ui/back.jpg");
//	private GLSLSandboxShader backgroundShader;
//	private long initTime = System.currentTimeMillis();

	protected TitleScreenMixin(Text title)
	{
		super(title);
	}

	@Shadow
	@Final
	private boolean doBackgroundFade;
	@Shadow private long backgroundFadeStart;
	private ParticleSystem particleSystem;
	private CustomButton test123;

	@Inject(method = "init", at = @At(value = "HEAD"), cancellable = true) public void init(CallbackInfo ci)
	{
		//		ci.cancel();
		/*try
		{
			this.backgroundShader = new GLSLSandboxShader("/w.fsh");
			initTime = System.currentTimeMillis();
		} catch (IOException e)
		{
			throw new IllegalStateException("Failed to load backgound shader", e);
		}*/
				particleSystem = new ParticleSystem(100, 2, true, true);
		//		test123 = new CurstomButton(32, 10, 10, 2, "test123");

	}

	@Inject(method = "tick", at = @At(value = "RETURN"), cancellable = true) public void tick(CallbackInfo ci)
	{
	}

	/**
	 * @author silver
	 */
	@Overwrite public void render(int mouseX, int mouseY, float delta)
	{

		//		this.backgroundShader.useShader(this.width, this.height, mouseX, mouseY, (System.currentTimeMillis() - initTime) / 1000f);

		//		GL11.glBegin(GL11.GL_QUADS);

		//		GL11.glVertex2f(-1f, -1f);
		//		GL11.glVertex2f(-1f, 1f);
		//		GL11.glVertex2f(1f, 1f);
		//		GL11.glVertex2f(1f, -1f);

		//		GL11.glEnd();
		//		// Unbind shader
		//		GL20.glUseProgram(0);

		//		// Stuff enabled done by the skybox rendering

		//		//						this.mc.getTextureManager().bindTexture(minecraftTitleTextures);
		//		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

		if (this.backgroundFadeStart == 0L && this.doBackgroundFade)
		{
			this.backgroundFadeStart = Util.getMeasuringTimeMs();
		}

		float f = this.doBackgroundFade ? (float) (Util.getMeasuringTimeMs() - this.backgroundFadeStart) / 1000.0F : 1.0F;
		fill(0, 0, this.width, this.height, -1);
		//		this.backgroundRenderer.render(delta, MathHelper.clamp(f, 0.0F, 1.0F));
		minecraft.getTextureManager().bindTexture(Background);
		RenderSystem.enableBlend();
		RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, this.doBackgroundFade ? (float) MathHelper.ceil(MathHelper.clamp(f, 0.0F, 1.0F)) : 1.0F);
		blit(0, 0, this.width, this.height, 0.0F, 0.0F, 16, 128, 16, 128);
		float g = this.doBackgroundFade ? MathHelper.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
		int l = MathHelper.ceil(g * 255.0F) << 24;
		if ((l & -67108864) != 0)
		{
			int scaledWidth = MinecraftClient.getInstance().getWindow().getScaledWidth();

			GuiHelper.fillGradient(GL11.GL_QUADS, scaledWidth - scaledWidth / 6, 0, scaledWidth,
					MinecraftClient.getInstance().getWindow().getScaledHeight(), new Color(255, 255, 255, 12).getRGB(),
					new Color(0, 255, 255, 20).getRGB());

			//			Tweaks.fontUtils.drawString(string, 2, this.height - 10, 16777215 | l);

			//			char[] chars = new char[256];
			//			Font arial = new Font("Comic Sans MS", Font.PLAIN, 20);
			//			System.out.println(arial.getName());
			//			GlyphPage glyphPage = new GlyphPage(arial, true, true);
			//			glyphPage.generateGlyphPage(chars);
			//			glyphPage.setupTexture();
			//			Tweaks.renderer = new GlyphPageFontRenderer(glyphPage, glyphPage, glyphPage, glyphPage);

			//			System.out.println(Tweaks.renderer == null);
			//			System.out.println(Tweaks.renderer.getFontHeight());
			//			System.out.println(Tweaks.renderer.fontRandom);
//			RenderSystem.pushMatrix();
//			RenderSystem.scalef(0.1375f, 0.1375F, 0);
//			Tweaks.renderer.drawString(string, 2, 10, -1, false, 1F);
//			RenderSystem.popMatrix();

			//									this.drawString(this.font, string, 2, this.height - 10, 16777215 | l);
//			test123.render(mouseX, mouseY, delta);

		}

		for (AbstractButtonWidget abstractButtonWidget : this.buttons)
		{
			abstractButtonWidget.setAlpha(g);
		}

		particleSystem.tick(delta);
		particleSystem.render(mouseX, mouseY);

		super.render(mouseX, mouseY, delta);
		NotificationManager.render(mouseX, mouseY);

		//			if (this.areRealmsNotificationsEnabled() && g >= 1.0F) {
		//				this.realmsNotificationGui.render(mouseX, mouseY, delta);
		//			}

	}
}
