package fr.isep.javarchitects.Fenetres;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FenetreDemarage {

    private GamePlayFieldWindow gamePlayField;
    private AnchorPane mainPane;
    private Stage stage;
    private Scene mainScene;
    private ArrayList <Label> l_Joueurs = new ArrayList <Label>();
    private ArrayList<TextField> listeJoueurs = new ArrayList<TextField>();
    private Label l_NbJoueurs;
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1000;

    public FenetreDemarage(GamePlayFieldWindow fp) {
        initialisationFenetreDemarage(fp);

    }

    private void initialisationFenetreDemarage(GamePlayFieldWindow gamePlayField) {
        this.gamePlayField = gamePlayField;
        mainPane = new AnchorPane();

        VBox root = new VBox();
        //MotionBlur motionBlur = new MotionBlur();
        //motionBlur.setRadius(100);
        //motionBlur.setAngle(40);
        root.setPadding(new Insets(10,10,10,10));
        root.setSpacing(5);
        l_NbJoueurs = new Label("Noms des joueurs (2 minimum) :");
        l_NbJoueurs.setStyle("-fx-font-size:20");
        l_NbJoueurs.setTextFill(Color.web("#5F0404"));
        ImageView imageView1=new ImageView();
        // imageView1.setFitHeight(100);
        // imageView1.setFitWidth(1000.0);
        AnchorPane.setBottomAnchor(root, 100.);
        AnchorPane.setRightAnchor(root, 20.);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);


        // imageView1.setImage(new Image(getClass().getResourceAsStream("/images/Titre.png")));

        root.getChildren().add(imageView1);
        //VBox.setMargin((imageView1), new Insets(30,0,0,100));

        GridPane grilleJoueur = new GridPane();
        grilleJoueur.setPadding(new Insets(10));
        grilleJoueur.setVgap(30);
        grilleJoueur.setHgap(25);
        //VBox.setMargin((grilleJoueur), new Insets(100, 10, 10, 100));

        grilleJoueur.add(l_NbJoueurs, 0,0, 3, 1);

        //final Color shadowColor = Color.BLACK.deriveColor(0, 0, 0, 1);
        //DropShadow dropShadow = new DropShadow(BlurType.THREE_PASS_BOX, shadowColor, 2, 1, 0,0);
        //grilleJoueur.setEffect(dropShadow);

        for(int i=0; i<7; i++) {
            listeJoueurs.add(new TextField(i<2?"Joueur "+(i+1):""));
            //listeJoueurs.get(i).setEffect(dropShadow);
            listeJoueurs.get(i).setPromptText("Nom du joueur "+(i+1));
            listeJoueurs.get(i).setPrefWidth(250);

            //listeJoueurs.get(i).setMaxWidth();

            grilleJoueur.add(listeJoueurs.get(i),0, i+1, 3, 1);

        }

        root.getChildren().add(grilleJoueur);
        grilleJoueur.setAlignment(Pos.CENTER);
        Button b_Valider = new Button("Valider");
        b_Valider.setDefaultButton(true);
        b_Valider.setStyle("-fx-font-size:16");
        VBox.setMargin((b_Valider), new Insets(30,0,10,120));

        b_Valider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<String> nomJoueur = new ArrayList<String>();
                for(int i=0; i<7; i++) {
                    if(listeJoueurs.get(i).getText() != null && !listeJoueurs.get(i).getText().isEmpty())
                        nomJoueur.add(listeJoueurs.get(i).getText());
                }
                if(nomJoueur.size()>=2) {
                    // choix = 1;
                    gamePlayField.setPartie(nomJoueur.size(), nomJoueur);
                    gamePlayField.getMainStage().show();
                    stage.close();
                }
                event.consume();
            }
        });


        root.getChildren().add(b_Valider);
        //b_Valider.setEffect(dropShadow);

        mainPane.getChildren().add(root);

        mainScene = new Scene(mainPane,WIDTH, HEIGHT);
        stage = new Stage();
        stage.setScene(mainScene);
    }
    /*
    private void createBackgroud() {
        gridPane1 = new GridPane();
        gridPane2 = new GridPane();

        for (int i = 0; i < 12; i++) {
            ImageView backGroundImage1 = new ImageView(new Image(getClass().getResourceAsStream(BACKGROUND_IMAGE)));
            ImageView backGroundImage2 = new ImageView(new Image(getClass().getResourceAsStream(BACKGROUND_IMAGE)));
            GridPane.setConstraints(backGroundImage1, i% 3, i / 3);
            GridPane.setConstraints(backGroundImage1, i% 3, i / 3);
            gridPane1.getChildren().add(backGroundImage1);
            gridPane2.getChildren().add(backGroundImage2);

        }
        gridPane2.setLayoutY(-1024);

        mainPane.getChildren().addAll(gridPane1, gridPane2);

    }


    private void moveBackground() {
        gridPane1.setLayoutY(gridPane1.getLayoutY() + 0.5);
        gridPane2.setLayoutY(gridPane2.getLayoutY() + 0.5);

        if (gridPane1.getLayoutY() >= 1024) {
            gridPane1.setLayoutY(-1024);
        }

        if (gridPane2.getLayoutY() >= 1024) {
            gridPane2.setLayoutY(-1024);
        }
    }

    private void gameLoop() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                moveBackground();
            }
        };

        gameTimer.start();
    }


     */
    public Stage getStage() {
        return stage;
    }

}
