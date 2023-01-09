package fr.isep.javarchitects.model;

public class WonderFragment {

    //attributes
    private final String imagePathFront;
    private final String ImagePathBack;
    private final int floorNumber;
    private final boolean triggerEffect;
    private final int VP;
    private final int resourceCount;
    private final boolean matchingResources;
    private boolean isbuilt = false;

    //constructor
    public WonderFragment(String imagePathFront, String imagePathBack, int floorNumber, boolean triggerEffect, int vp, int resourceCount, boolean matchingResources) {
        this.imagePathFront = imagePathFront;
        this.ImagePathBack = imagePathBack;
        this.floorNumber = floorNumber;
        this.triggerEffect = triggerEffect;
        this.VP = vp;
        this.resourceCount = resourceCount;
        this.matchingResources = matchingResources;
    }

    public String getImagePath(){
        return isbuilt ? this.imagePathFront : this.ImagePathBack;
    }

    public void build(){
        this.isbuilt = true;
    }

}
