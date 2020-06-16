package theSilverEcho.tweaks.clientTime;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.*;
import net.minecraft.client.network.packet.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.server.command.CommandSource;
import net.minecraft.tag.RegistryTagManager;
import net.minecraft.text.Text;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.UUID;

import static theSilverEcho.tweaks.Tweaks.TIME_TYPE;

public class ClientTimeNetHelper extends ClientPlayNetworkHandler
{

	private final ClientPlayNetworkHandler parent;

	public ClientTimeNetHelper(ClientPlayNetworkHandler parent)
	{
		super(MinecraftClient.getInstance(), (getGuiScreen(parent)), parent.getConnection(), parent.getProfile());
		this.parent = parent;
	}

	private static Screen getGuiScreen(final ClientPlayNetworkHandler parent)
	{
		for (Field field : parent.getClass().getDeclaredFields())
		{
			if (field.getType().equals(Screen.class))
			{
				field.setAccessible(true);
				try
				{
					return (Screen) field.get(parent);
				} catch (Exception e)
				{
					return null;
				}
			}
		}
		return null;
	}


	@Override public ClientCommandSource getCommandSource()
	{
		return this.parent.getCommandSource();
	}

	@Override public void clearWorld()
	{
		this.parent.clearWorld();
	}

	@Override public RecipeManager getRecipeManager()
	{
		return this.parent.getRecipeManager();
	}

	@Override public void onGameJoin(GameJoinS2CPacket packet)
	{
		this.parent.onGameJoin(packet);
	}

	@Override public void onEntitySpawn(EntitySpawnS2CPacket packet)
	{
		this.parent.onEntitySpawn(packet);
	}

	@Override public void onExperienceOrbSpawn(ExperienceOrbSpawnS2CPacket packet)
	{
		this.parent.onExperienceOrbSpawn(packet);
	}

	@Override public void onEntitySpawnGlobal(EntitySpawnGlobalS2CPacket packet)
	{
		this.parent.onEntitySpawnGlobal(packet);
	}

	@Override public void onPaintingSpawn(PaintingSpawnS2CPacket packet)
	{
		this.parent.onPaintingSpawn(packet);
	}

	@Override public void onVelocityUpdate(EntityVelocityUpdateS2CPacket packet)
	{
		this.parent.onVelocityUpdate(packet);
	}

	@Override public void onEntityTrackerUpdate(EntityTrackerUpdateS2CPacket packet)
	{
		this.parent.onEntityTrackerUpdate(packet);
	}

	@Override public void onPlayerSpawn(PlayerSpawnS2CPacket packet)
	{
		this.parent.onPlayerSpawn(packet);
	}

	@Override public void onEntityPosition(EntityPositionS2CPacket packet)
	{
		this.parent.onEntityPosition(packet);
	}

	@Override public void onHeldItemChange(HeldItemChangeS2CPacket packet)
	{
		this.parent.onHeldItemChange(packet);
	}

	@Override public void onEntityUpdate(EntityS2CPacket packet)
	{
		this.parent.onEntityUpdate(packet);
	}

	@Override public void onEntitySetHeadYaw(EntitySetHeadYawS2CPacket packet)
	{
		this.parent.onEntitySetHeadYaw(packet);
	}

	@Override public void onEntitiesDestroy(EntitiesDestroyS2CPacket packet)
	{
		this.parent.onEntitiesDestroy(packet);
	}

	@Override public void onPlayerPositionLook(PlayerPositionLookS2CPacket packet)
	{
		this.parent.onPlayerPositionLook(packet);
	}

	@Override public void onChunkDeltaUpdate(ChunkDeltaUpdateS2CPacket packet)
	{
		this.parent.onChunkDeltaUpdate(packet);
	}

	@Override public void onChunkData(ChunkDataS2CPacket packet)
	{
		this.parent.onChunkData(packet);
	}

	@Override public void onUnloadChunk(UnloadChunkS2CPacket packet)
	{
		this.parent.onUnloadChunk(packet);
	}

	@Override public void onBlockUpdate(BlockUpdateS2CPacket packet)
	{
		this.parent.onBlockUpdate(packet);
	}

	@Override public void onDisconnect(DisconnectS2CPacket packet)
	{
		this.parent.onDisconnect(packet);
	}

	@Override public void onDisconnected(Text reason)
	{
		this.parent.onDisconnected(reason);
	}

	@Override public void sendPacket(Packet<?> packet)
	{
		this.parent.sendPacket(packet);
	}

	@Override public void onItemPickupAnimation(ItemPickupAnimationS2CPacket packet)
	{
		this.parent.onItemPickupAnimation(packet);
	}

	@Override public void onChatMessage(ChatMessageS2CPacket packet)
	{
		this.parent.onChatMessage(packet);
	}

	@Override public void onEntityAnimation(EntityAnimationS2CPacket packet)
	{
		this.parent.onEntityAnimation(packet);
	}

	@Override public void onMobSpawn(MobSpawnS2CPacket packet)
	{
		this.parent.onMobSpawn(packet);
	}

	@Override public void onPlayerSpawnPosition(PlayerSpawnPositionS2CPacket packet)
	{
		this.parent.onPlayerSpawnPosition(packet);
	}

	@Override public void onEntityPassengersSet(EntityPassengersSetS2CPacket packet)
	{
		this.parent.onEntityPassengersSet(packet);
	}

	@Override public void onEntityAttach(EntityAttachS2CPacket packet)
	{
		this.parent.onEntityAttach(packet);
	}

	@Override public void onEntityStatus(EntityStatusS2CPacket packet)
	{
		this.parent.onEntityStatus(packet);
	}

	@Override public void onHealthUpdate(HealthUpdateS2CPacket packet)
	{
		this.parent.onHealthUpdate(packet);
	}

	@Override public void onExperienceBarUpdate(ExperienceBarUpdateS2CPacket packet)
	{
		this.parent.onExperienceBarUpdate(packet);
	}

	@Override public void onPlayerRespawn(PlayerRespawnS2CPacket packet)
	{
		this.parent.onPlayerRespawn(packet);
	}

	@Override public void onExplosion(ExplosionS2CPacket packet)
	{
		this.parent.onExplosion(packet);
	}

	@Override public void onGuiOpen(GuiOpenS2CPacket packet)
	{
		this.parent.onGuiOpen(packet);
	}

	@Override public void onOpenContainer(OpenContainerS2CPacket packet)
	{
		this.parent.onOpenContainer(packet);
	}

	@Override public void onGuiSlotUpdate(GuiSlotUpdateS2CPacket packet)
	{
		this.parent.onGuiSlotUpdate(packet);
	}

	@Override public void onGuiActionConfirm(ConfirmGuiActionS2CPacket packet)
	{
		this.parent.onGuiActionConfirm(packet);
	}

	@Override public void onInventory(InventoryS2CPacket packet)
	{
		this.parent.onInventory(packet);
	}

	@Override public void onSignEditorOpen(SignEditorOpenS2CPacket packet)
	{
		this.parent.onSignEditorOpen(packet);
	}

	@Override public void onBlockEntityUpdate(BlockEntityUpdateS2CPacket packet)
	{
		this.parent.onBlockEntityUpdate(packet);
	}

	@Override public void onGuiUpdate(GuiUpdateS2CPacket packet)
	{
		this.parent.onGuiUpdate(packet);
	}

	@Override public void onEquipmentUpdate(EntityEquipmentUpdateS2CPacket packet)
	{
		this.parent.onEquipmentUpdate(packet);
	}

	@Override public void onGuiClose(GuiCloseS2CPacket packet)
	{
		this.parent.onGuiClose(packet);
	}

	@Override public void onBlockAction(BlockActionS2CPacket packet)
	{
		this.parent.onBlockAction(packet);
	}

	@Override public void onBlockDestroyProgress(BlockBreakingProgressS2CPacket packet)
	{
		this.parent.onBlockDestroyProgress(packet);
	}

	@Override public void onGameStateChange(GameStateChangeS2CPacket packet)
	{
		this.parent.onGameStateChange(packet);
	}

	@Override public void onMapUpdate(MapUpdateS2CPacket packet)
	{
		this.parent.onMapUpdate(packet);
	}

	@Override public void onWorldEvent(WorldEventS2CPacket packet)
	{
		this.parent.onWorldEvent(packet);
	}

	@Override public void onAdvancements(AdvancementUpdateS2CPacket packet)
	{
		this.parent.onAdvancements(packet);
	}

	@Override public void onSelectAdvancementTab(SelectAdvancementTabS2CPacket packet)
	{
		this.parent.onSelectAdvancementTab(packet);
	}

	@Override public void onCommandTree(CommandTreeS2CPacket packet)
	{
		this.parent.onCommandTree(packet);
	}

	@Override public void onStopSound(StopSoundS2CPacket packet)
	{
		this.parent.onStopSound(packet);
	}

	@Override public void onCommandSuggestions(CommandSuggestionsS2CPacket packet)
	{
		this.parent.onCommandSuggestions(packet);
	}

	@Override public void onSynchronizeRecipes(SynchronizeRecipesS2CPacket packet)
	{
		this.parent.onSynchronizeRecipes(packet);
	}

	@Override public void onLookAt(LookAtS2CPacket packet)
	{
		this.parent.onLookAt(packet);
	}

	@Override public void onTagQuery(TagQueryResponseS2CPacket packet)
	{
		this.parent.onTagQuery(packet);
	}

	@Override public void onStatistics(StatisticsS2CPacket packet)
	{
		this.parent.onStatistics(packet);
	}

	@Override public void onUnlockRecipes(UnlockRecipesS2CPacket packet)
	{
		this.parent.onUnlockRecipes(packet);
	}

	@Override public void onEntityPotionEffect(EntityPotionEffectS2CPacket packet)
	{
		this.parent.onEntityPotionEffect(packet);
	}

	@Override public void onSynchronizeTags(SynchronizeTagsS2CPacket packet)
	{
		this.parent.onSynchronizeTags(packet);
	}

	@Override public void onCombatEvent(CombatEventS2CPacket packet)
	{
		this.parent.onCombatEvent(packet);
	}

	@Override public void onDifficulty(DifficultyS2CPacket packet)
	{
		this.parent.onDifficulty(packet);
	}

	@Override public void onSetCameraEntity(SetCameraEntityS2CPacket packet)
	{
		this.parent.onSetCameraEntity(packet);
	}

	@Override public void onWorldBorder(WorldBorderS2CPacket packet)
	{
		this.parent.onWorldBorder(packet);
	}

	@Override public void onTitle(TitleS2CPacket packet)
	{
		this.parent.onTitle(packet);
	}

	@Override public void onPlayerListHeader(PlayerListHeaderS2CPacket packet)
	{
		this.parent.onPlayerListHeader(packet);
	}

	@Override public void onRemoveEntityEffect(RemoveEntityEffectS2CPacket packet)
	{
		this.parent.onRemoveEntityEffect(packet);
	}

	@Override public void onPlayerList(PlayerListS2CPacket packet)
	{
		this.parent.onPlayerList(packet);
	}

	@Override public void onKeepAlive(KeepAliveS2CPacket packet)
	{
		this.parent.onKeepAlive(packet);
	}

	@Override public void onPlayerAbilities(PlayerAbilitiesS2CPacket packet)
	{
		this.parent.onPlayerAbilities(packet);
	}

	@Override public void onPlaySound(PlaySoundS2CPacket packet)
	{
		this.parent.onPlaySound(packet);
	}

	@Override public void onPlaySoundFromEntity(PlaySoundFromEntityS2CPacket packet)
	{
		this.parent.onPlaySoundFromEntity(packet);
	}

	@Override public void onPlaySoundId(PlaySoundIdS2CPacket packet)
	{
		this.parent.onPlaySoundId(packet);
	}

	@Override public void onResourcePackSend(ResourcePackSendS2CPacket packet)
	{
		this.parent.onResourcePackSend(packet);
	}

	@Override public void onBossBar(BossBarS2CPacket packet)
	{
		this.parent.onBossBar(packet);
	}

	@Override public void onCooldownUpdate(CooldownUpdateS2CPacket packet)
	{
		this.parent.onCooldownUpdate(packet);
	}

	@Override public void onVehicleMove(VehicleMoveS2CPacket packet)
	{
		this.parent.onVehicleMove(packet);
	}

	@Override public void onOpenWrittenBook(OpenWrittenBookS2CPacket packet)
	{
		this.parent.onOpenWrittenBook(packet);
	}

	@Override public void onCustomPayload(CustomPayloadS2CPacket packet)
	{
		this.parent.onCustomPayload(packet);
	}

	@Override public void onScoreboardObjectiveUpdate(ScoreboardObjectiveUpdateS2CPacket packet)
	{
		this.parent.onScoreboardObjectiveUpdate(packet);
	}

	@Override public void onScoreboardPlayerUpdate(ScoreboardPlayerUpdateS2CPacket packet)
	{
		this.parent.onScoreboardPlayerUpdate(packet);
	}

	@Override public void onScoreboardDisplay(ScoreboardDisplayS2CPacket packet)
	{
		this.parent.onScoreboardDisplay(packet);
	}

	@Override public void onTeam(TeamS2CPacket packet)
	{
		this.parent.onTeam(packet);
	}

	@Override public void onParticle(ParticleS2CPacket packet)
	{
		this.parent.onParticle(packet);
	}

	@Override public void onEntityAttributes(EntityAttributesS2CPacket packet)
	{
		this.parent.onEntityAttributes(packet);
	}

	@Override public void onCraftFailedResponse(CraftFailedResponseS2CPacket packet)
	{
		this.parent.onCraftFailedResponse(packet);
	}

	@Override public void onLightUpdate(LightUpdateS2CPacket packet)
	{
		this.parent.onLightUpdate(packet);
	}

	@Override public void onSetTradeOffers(SetTradeOffersS2CPacket packet)
	{
		this.parent.onSetTradeOffers(packet);
	}

	@Override public void onChunkLoadDistance(ChunkLoadDistanceS2CPacket packet)
	{
		this.parent.onChunkLoadDistance(packet);
	}

	@Override public void onChunkRenderDistanceCenter(ChunkRenderDistanceCenterS2CPacket packet)
	{
		this.parent.onChunkRenderDistanceCenter(packet);
	}

	@Override public void onPlayerActionResponse(PlayerActionResponseS2CPacket packet)
	{
		this.parent.onPlayerActionResponse(packet);
	}

	@Override public ClientConnection getConnection()
	{
		return this.parent.getConnection();
	}

	@Override public Collection<PlayerListEntry> getPlayerList()
	{
		return this.parent.getPlayerList();
	}

	@Override public PlayerListEntry getPlayerListEntry(UUID uuid)
	{
		return this.parent.getPlayerListEntry(uuid);
	}

	@Override public PlayerListEntry getPlayerListEntry(String profileName)
	{
		return this.parent.getPlayerListEntry(profileName);
	}

	@Override public GameProfile getProfile()
	{
		return this.parent.getProfile();
	}

	@Override public ClientAdvancementManager getAdvancementHandler()
	{
		return this.parent.getAdvancementHandler();
	}

	@Override public CommandDispatcher<CommandSource> getCommandDispatcher()
	{
		return this.parent.getCommandDispatcher();
	}

	@Override public ClientWorld getWorld()
	{
		return this.parent.getWorld();
	}

	@Override public RegistryTagManager getTagManager()
	{
		return this.parent.getTagManager();
	}

	@Override public DataQueryHandler getDataQueryHandler()
	{
		return this.parent.getDataQueryHandler();
	}

	@Override public UUID getSessionId()
	{
		return this.parent.getSessionId();
	}

	@Override public void onWorldTimeUpdate(WorldTimeUpdateS2CPacket packet)
	{

		switch (TIME_TYPE)
		{
		case DAY:
			this.parent.onWorldTimeUpdate(new WorldTimeUpdateS2CPacket(packet.getTimeOfDay(), -6000L, true));
			break;
		case SUNSET:
			this.parent.onWorldTimeUpdate(new WorldTimeUpdateS2CPacket(packet.getTimeOfDay(), -22880L, true));
			break;
		case NIGHT:
			this.parent.onWorldTimeUpdate(new WorldTimeUpdateS2CPacket(packet.getTimeOfDay(), -18000L, true));
			break;
		case VANILLA:
			this.parent.onWorldTimeUpdate(packet);
			break;
		}
	}
	public void onNetworkTick()
	{
		((ClientTimeNetHelper) this.parent).onNetworkTick();
	}

}
