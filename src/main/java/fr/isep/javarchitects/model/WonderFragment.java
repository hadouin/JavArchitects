package fr.isep.javarchitects.model;

public class WonderFragment {

    //attributes
    private final String imagePathFront;
    private final String ImagePathBack;
    private final int floorNumber;
    private boolean triggerEffect;

    //constructor
    public WonderFragment(String imagePathFront, String imagePathBack, int floorNumber, boolean triggerEffect) {
        this.imagePathFront = imagePathFront;
        this.ImagePathBack = imagePathBack;
        this.floorNumber = floorNumber;
        this.triggerEffect = triggerEffect;
    }

}
