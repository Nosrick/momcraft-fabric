package io.github.nosrick.block.entity;

import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.dependency.cardinalcomponents.ModComponents;
import io.github.nosrick.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class BlockEntityResearchAltar extends BlockEntityOwnable implements Tickable {

    public int ticks;
    public float nextPageAngle;
    public float pageAngle;
    public float field_11969;
    public float field_11967;
    public float nextPageTurningSpeed;
    public float pageTurningSpeed;
    public float field_11964;
    public float field_11963;
    public float field_11962;

    protected static final Random RANDOM = new Random();

    public BlockEntityResearchAltar() {
        super(ModComponents.createForBlockEntity(),
                ModBlockEntities.BlockEntities.RESEARCH_ALTAR.blockEntity);
    }

    @Override
    public void tick() {
        this.pageTurningSpeed = this.nextPageTurningSpeed;
        this.field_11963 = this.field_11964;
        PlayerEntity playerEntity = this.world.getClosestPlayer((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D, 3.0D, false);
        if (playerEntity != null) {
            double d = playerEntity.getX() - ((double) this.pos.getX() + 0.5D);
            double e = playerEntity.getZ() - ((double) this.pos.getZ() + 0.5D);
            this.field_11962 = (float) MathHelper.atan2(e, d);
            this.nextPageTurningSpeed += 0.1F;
            if (this.nextPageTurningSpeed < 0.5F || RANDOM.nextInt(40) == 0) {
                float f = this.field_11969;

                do {
                    this.field_11969 += (float) (RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while (f == this.field_11969);
            }
        } else {
            this.field_11962 += 0.02F;
            this.nextPageTurningSpeed -= 0.1F;
        }

        while (this.field_11964 >= 3.1415927F) {
            this.field_11964 -= 6.2831855F;
        }

        while (this.field_11964 < -3.1415927F) {
            this.field_11964 += 6.2831855F;
        }

        while (this.field_11962 >= 3.1415927F) {
            this.field_11962 -= 6.2831855F;
        }

        while (this.field_11962 < -3.1415927F) {
            this.field_11962 += 6.2831855F;
        }

        float g;
        for (g = this.field_11962 - this.field_11964; g >= 3.1415927F; g -= 6.2831855F) {
        }

        while (g < -3.1415927F) {
            g += 6.2831855F;
        }

        this.field_11964 += g * 0.4F;
        this.nextPageTurningSpeed = MathHelper.clamp(this.nextPageTurningSpeed, 0.0F, 1.0F);
        ++this.ticks;
        this.pageAngle = this.nextPageAngle;
        float h = (this.field_11969 - this.nextPageAngle) * 0.4F;
        float i = 0.2F;
        h = MathHelper.clamp(h, -0.2F, 0.2F);
        this.field_11967 += (h - this.field_11967) * 0.9F;
        this.nextPageAngle += this.field_11967;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        IOwnable component = ModComponents.OWNABLE.get(this);
        component.setColour(tag.getInt("ownerColour"));
        component.setOwnerUUID(tag.getString("ownerUUID"));
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        CompoundTag tempTag = super.toTag(tag);
        IOwnable component = ModComponents.OWNABLE.get(this);
        tempTag.putInt("ownerColour", component.getColour());
        tempTag.putString("ownerUUID", component.getOwnerUUID());
        return tempTag;
    }

    @Override
    public void fromClientTag(CompoundTag compoundTag) {
        super.fromClientTag(compoundTag);
        IOwnable component = ModComponents.OWNABLE.get(this);
        compoundTag.putInt("ownerColour", component.getColour());
        compoundTag.putString("ownerUUID", component.getOwnerUUID());
    }

    @Override
    public CompoundTag toClientTag(CompoundTag compoundTag) {
        CompoundTag tempTag = super.toClientTag(compoundTag);
        IOwnable component = ModComponents.OWNABLE.get(this);
        tempTag.putInt("ownerColour", component.getColour());
        tempTag.putString("ownerUUID", component.getOwnerUUID());
        return tempTag;
    }
}
