package com.hollingsworth.arsnouveau.client.renderer.tile;

import com.hollingsworth.arsnouveau.ArsNouveau;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GenericModel<T extends IAnimatable> extends AnimatedGeoModel<T> {
    public String path;

    public ResourceLocation modelLocation;
    public ResourceLocation textLoc;
    public ResourceLocation animationLoc;

    public GenericModel(String name){
        this.modelLocation = new ResourceLocation(ArsNouveau.MODID , "geo/" + name + ".geo.json");
        this.textLoc = new ResourceLocation(ArsNouveau.MODID, "textures/blocks/" + name + ".png");
        this.animationLoc = new ResourceLocation(ArsNouveau.MODID , "animations/" + name + "_animations.json");
    }

    @Override
    public ResourceLocation getModelLocation(T iAnimatable) {
        return modelLocation;
    }

    @Override
    public ResourceLocation getTextureLocation(T iAnimatable) {
        return textLoc;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(T iAnimatable) {
        return animationLoc;
    }
}