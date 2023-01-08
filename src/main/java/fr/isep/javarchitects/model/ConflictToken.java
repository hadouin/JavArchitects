package fr.isep.javarchitects.model;

public class ConflictToken {
    private String imageRessource;
    private boolean isPeace;

    public ConflictToken(boolean isPeace){
        this.isPeace = isPeace;
        updateImage();
    }

    public void setWar(){
        isPeace = false;
        updateImage();
    }

    public void setPeace(){
        isPeace = true;
        updateImage();
    }

    private void updateImage(){
        if (this.isPeace){
            this.imageRessource = "/images/tokens/token-conflict-peace.png";
        } else {
            this.imageRessource = "/images/tokens/token-conflict-war.png";
        }
    }

    public String getImage() {
        return this.imageRessource;
    }
}
