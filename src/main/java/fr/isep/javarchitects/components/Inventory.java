package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.Card;
import fr.isep.javarchitects.model.CardCategory;
import fr.isep.javarchitects.model.PlayerVisible;
import fr.isep.javarchitects.utils.Icons;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Inventory extends VBox {

    private HBox materialLine = new HBox();
    private HBox scienceLine = new HBox();
    private Label playerName = new Label("Player's name");
    private HBox warTokens = new HBox();
    private HBox gloryWarPoints = new HBox();
    private ImageView cat = new ImageView();

    public Inventory() {

        initInventory();
        this.gotTheCatOrNot(false);
/*
        ImageView IMA1 = new ImageView(Icons.STONE.image);
        ImageView IMA2 = new ImageView(Icons.ARCHITECT.image);
        IMA1.setFitHeight(40);
        IMA1.setPreserveRatio(true);
        IMA2.setFitHeight(40);
        IMA2.setPreserveRatio(true);
        scienceLine.getChildren().add(IMA1);



        materialLine.getChildren().add(IMA2);

        ImageView IMA3 = new ImageView(Icons.BATTLE_TOKEN_3.image);
        IMA3.setFitHeight(40);
        IMA3.setPreserveRatio(true);
        ImageView IMA4 = new ImageView(Icons.VP_2.image);
        IMA4.setFitHeight(40);
        IMA4.setPreserveRatio(true);
        ImageView IMA5 = new ImageView(Icons.BATTLE_TOKEN.image);
        IMA5.setFitHeight(40);
        IMA5.setPreserveRatio(true);
        ImageView IMA6 = new ImageView(Icons.VP.image);
        IMA6.setFitHeight(40);
        IMA6.setPreserveRatio(true);
        warTokens.getChildren().add(IMA3);
        gloryWarPoints.getChildren().add(IMA4);
        warTokens.getChildren().add(IMA5);
        gloryWarPoints.getChildren().add(IMA6);
*/
    }
    private void initInventory() {
        this.setPrefSize(250, 100);
        this.setStyle("-fx-padding: 0;" +
                "-fx-background-color: lightgrey;" +
                "-fx-background-radius: 5;" +
                "-fx-border-style: solid;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 0;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: grey;");

        HBox linesCatHBox = new HBox();
        linesCatHBox.getChildren().add(setMaterialScienceVbox());
        linesCatHBox.getChildren().add(setPointsVbox());
        linesCatHBox.getChildren().add(cat);
        cat.setPreserveRatio(true);
        cat.setFitHeight(90);
        linesCatHBox.setAlignment(Pos.CENTER);
        this.getChildren().add(playerName);
        this.getChildren().add(linesCatHBox);
        this.setAlignment(Pos.CENTER);
    }
    private VBox setMaterialScienceVbox() {
        scienceLine.setMinSize(150, 47);
        scienceLine.setStyle("-fx-padding: 0;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");

        materialLine.setPrefWidth(150);
        materialLine.setPrefHeight(47);
        materialLine.setMinSize(150, 47);
        materialLine.setStyle("-fx-padding: 0;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");
        for (int i = 0; i < 5; i++) {
            materialLine.getChildren().add(new ImageView());
            ((ImageView) materialLine.getChildren().get(i)).setFitHeight(40);
            ((ImageView) materialLine.getChildren().get(i)).setPreserveRatio(true);

            scienceLine.getChildren().add(new ImageView());
            ((ImageView) scienceLine.getChildren().get(i)).setFitHeight(40);
            ((ImageView) scienceLine.getChildren().get(i)).setPreserveRatio(true);
        }

        for (int j = 0; j < 2; j++) {
            warTokens.getChildren().add(new ImageView());
            ((ImageView) warTokens.getChildren().get(j)).setFitHeight(40);
            ((ImageView) warTokens.getChildren().get(j)).setPreserveRatio(true);

            gloryWarPoints.getChildren().add(new Pane());
            ((Pane) gloryWarPoints.getChildren().get(j)).setMaxHeight(40);
            // ((Pane) gloryWarPoints.getChildren().get(j)).set(true);
        }

        VBox materialScienceHbox = new VBox();
        materialScienceHbox.getChildren().add(materialLine);
        materialScienceHbox.getChildren().add(scienceLine);

        // materialScienceHbox.setPadding(new Insets(20));
        return materialScienceHbox;
    }

    private VBox setPointsVbox() {
        warTokens.setPrefWidth(90);
        warTokens.setPrefHeight(47);
        warTokens.setMinSize(90, 47);
        warTokens.setStyle("-fx-padding: 0;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");
        gloryWarPoints.setPrefWidth(90);
        gloryWarPoints.setPrefHeight(47);
        gloryWarPoints.setMinSize(90, 47);
        gloryWarPoints.setStyle("-fx-padding: 0;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");

        VBox pointsHbox = new VBox();
        pointsHbox.getChildren().add(warTokens);
        pointsHbox.getChildren().add(gloryWarPoints);



        return pointsHbox;
    }

    public void gotTheCatOrNot(boolean gotIt) {
        Image catDisplay = gotIt ? new Image(getClass().getResourceAsStream("/images/tokens/token-cat.png")) : null;
        cat.setImage(catDisplay);
    }

    private void addMaterials(Icons icons) {
        Image image = icons.image;
        int index = 0;
        for (int i = materialLine.getChildren().size() -1; i >= 0; i--) {
            if (((ImageView) materialLine.getChildren().get(i)).getImage() == null) {
                index = i;
            }
        }

        ((ImageView) materialLine.getChildren().get(index)).setImage(image);

    }

    private void addScience(Icons icons) {
        Image image = icons.image;
        int index = 0;
        for (int i = scienceLine.getChildren().size() -1; i >= 0; i--) {
            if (((ImageView) scienceLine.getChildren().get(i)).getImage() == null) {
                index = i;
            }
        }

        ((ImageView) scienceLine.getChildren().get(index)).setImage(image);
    }

    private void addPoints(Icons icons) {
        Image image = icons.image;
        int index = 0;
        for (int i = gloryWarPoints.getChildren().size() -1; i >= 0; i--) {
            if (((ImageView) gloryWarPoints.getChildren().get(i)).getImage() == null) {
                index = i;
            }
        }

        ((ImageView) gloryWarPoints.getChildren().get(index)).setImage(image);
    }

    private void addWarTokens(Icons icon) {
        Image image = icon.image;
        int index;
        if (icon == Icons.SHIELD) {
            index = 0;
        }
        else {
            index = 1;
        }

        ((ImageView) warTokens.getChildren().get(index)).setImage(image);
    }

    public void addIcons(Icons icons) {
        if(icons.y == 0 && icons.x < 6) {
            addMaterials(icons);
        }
        else if (icons.y == 1 && 2 < icons.x && icons.x < 6) {
            addScience(icons);
        }
        else if (icons.y == 1 && icons.x < 4) {
            addWarTokens(icons);
        }
        else if (icons.y == 0 && icons.x > 5) {
            addPoints(icons);
        }
    }

    public void updateInventory (PlayerVisible player) {
        playerName.setText(player.name);
        for (Card card : player.cards) {

            if (card.getFront().cardCategory == CardCategory.MaterialCard) {
                Icons icon = card.front.material.icon;
                addIcons(icon);
            }
            else if (card.getFront().cardCategory == CardCategory.ProgressCard) {
                Icons icon = card.front.scienceCategory.icon;
                addIcons(icon);
            }
            else if (card.getFront().cardCategory == CardCategory.WarCard) {
                int cornCount = card.front.cornCount; // a utiliser pour changer le nombre de Corn sur la view.
                if (cornCount == 0) {
                    Icons icon = Icons.SHIELD;
                    addIcons(icon);
                }
                else {
                    Icons icon = Icons.SHIELD_HORN;
                    addIcons(icon);
                }
            }
            else if (card.getFront().cardCategory == CardCategory.PoliticCard) {
                pointCounter pointCounter = new pointCounter(Icons.VP, player.gloryPoint + card.front.laurelCount);
                gloryWarPoints.getChildren().add(pointCounter);
                if(card.front.cat) {
                    gotTheCatOrNot(true);
                }
            }
        }
    }

 }