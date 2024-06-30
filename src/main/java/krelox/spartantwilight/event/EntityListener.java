package krelox.spartantwilight.event;

import com.oblivioussp.spartanweaponry.entity.projectile.ThrowingWeaponEntity;
import krelox.spartantoolkit.WeaponItem;
import krelox.spartantwilight.SpartanTwilight;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpartanTwilight.MODID)
public class EntityListener {
    private static final int KNIGHTMETAL_BONUS_DAMAGE = 2;

    @SubscribeEvent
    public static void fieryToolSetFire(LivingAttackEvent event) {
        LivingEntity target = event.getEntityLiving();

        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;
        if (!(attacker.getMainHandItem().getItem() instanceof WeaponItem weapon)) return;

        if (weapon.getMaterial().getBonusTraits().contains(SpartanTwilight.BLAZING.get())) {
            if (!target.fireImmune()) {
                target.setSecondsOnFire(15);
            } else {
                for (int i = 0; i < 20; ++i) {
                    double px = target.getX() + target.level.getRandom().nextFloat() * target.getBbWidth() * 2.0F - target.getBbWidth();
                    double py = target.getY() + target.level.getRandom().nextFloat() * target.getBbHeight();
                    double pz = target.getZ() + target.level.getRandom().nextFloat() * target.getBbWidth() * 2.0F - target.getBbWidth();
                    target.level.addParticle(ParticleTypes.FLAME, px, py, pz, 0.02, 0.02, 0.02);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onKnightmetalToolDamage(LivingHurtEvent event) {
        LivingEntity target = event.getEntityLiving();

        if (!(target.level instanceof ServerLevel level)) return;
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        WeaponItem weapon;
        if (event.getSource().getDirectEntity() instanceof ThrowingWeaponEntity throwing) {
            weapon = (WeaponItem) throwing.getWeaponItem().getItem();
        } else if (attacker.getMainHandItem().getItem() instanceof WeaponItem weaponItem && !attacker.swinging) {
            weapon = weaponItem;
        } else return;

        if (weapon.getMaterial().getBonusTraits().contains(SpartanTwilight.COMBAT_SKILLED.get()) && target.getArmorValue() > 0) {
            if (target.getArmorCoverPercentage() > 0) {
                int moreBonus = (int) (KNIGHTMETAL_BONUS_DAMAGE * target.getArmorCoverPercentage());
                event.setAmount(event.getAmount() + moreBonus);
            } else {
                event.setAmount(event.getAmount() + KNIGHTMETAL_BONUS_DAMAGE);
            }
            // enchantment attack sparkles
            level.getChunkSource().broadcastAndSend(target, new ClientboundAnimatePacket(target, 5));
        }
    }
}
