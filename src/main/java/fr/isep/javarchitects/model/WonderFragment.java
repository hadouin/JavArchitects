package fr.isep.javarchitects.model;

import javafx.scene.image.Image;

public class WonderFragment {

    //attributes
    private final Image imageFront;
    private final Image imageBack;
    private final int floorNumber;
    private final boolean triggerEffect;
    private final int VP;
    private final int resourceCount;
    private final boolean matchingResources;
    private boolean isbuilt = false;

    //constructor
    public WonderFragment(Image imageFront, Image imageBack, int floorNumber, boolean triggerEffect, int vp, int resourceCount, boolean matchingResources) {
        this.imageFront = imageFront;
        this.imageBack = imageBack;
        this.floorNumber = floorNumber;
        this.triggerEffect = triggerEffect;
        this.VP = vp;
        this.resourceCount = resourceCount;
        this.matchingResources = matchingResources;
    }

    public Image getImage(){
        return isbuilt ? this.imageFront : this.imageBack;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean isTriggerEffect() {
        return triggerEffect;
    }

    public int getVP() {
        return VP;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public boolean isMatchingResources() {
        return matchingResources;
    }

    public boolean getIsBuilt() {
        return isbuilt;
    }

    public void build(){
        this.isbuilt = true;
    }

    @Override
    public String toString() {
        return "floor:"+floorNumber+"|resCount:"+resourceCount+"|matching:"+matchingResources+"|isBuilt:"+isbuilt;
    }
}
