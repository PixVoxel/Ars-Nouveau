package com.hollingsworth.arsnouveau.common.items;

import com.hollingsworth.arsnouveau.api.item.ICasterTool;
import com.hollingsworth.arsnouveau.api.spell.ISpellCaster;
import com.hollingsworth.arsnouveau.api.spell.Spell;
import com.hollingsworth.arsnouveau.api.util.ManaUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CasterTome extends ModItem implements ICasterTool {
    public CasterTome(Properties properties) {
        super(properties);
    }

    public CasterTome(Properties properties, String registryName) {
        super(properties, registryName);
    }

    public CasterTome(String registryName) {
        super(registryName);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        ISpellCaster caster = getSpellCaster(stack);
        Spell spell = caster.getSpell();
        spell.setCost(Math.min(spell.getCastingCost()/2, ManaUtil.getMaxMana(playerIn))); // Let even a new player cast 1 charge of a tome
        return caster.castSpell(worldIn, playerIn, handIn, new TranslationTextComponent(""), spell);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip2, ITooltipFlag flagIn) {
        getInformation(stack, worldIn, tooltip2, flagIn);
        tooltip2.add(new TranslationTextComponent("tooltip.ars_nouveau.caster_tome"));
        super.appendHoverText(stack, worldIn, tooltip2, flagIn);
    }
}
