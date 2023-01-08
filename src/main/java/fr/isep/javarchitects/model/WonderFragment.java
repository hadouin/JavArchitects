package fr.isep.javarchitects.model;

public class WonderFragment {

    //attributes
    private final String imagePathFront;
    private final String ImagePathBack;
    private final int floorNumber;
    private boolean triggerEffect;
    private int VP;
    private int resourceCount;
    private boolean matchingResources;

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

}
