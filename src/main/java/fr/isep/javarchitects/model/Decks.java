package fr.isep.javarchitects.model;

import java.util.Arrays;
import java.util.List;

public enum Decks {

    D_Alexandrie(Arrays.asList(new Card[]{
            new Card(CardType.CardMaterialWood, CardBack.Alexandrie),
            new Card(CardType.CardMaterialWood, CardBack.Alexandrie),
            new Card(CardType.CardMaterialPaper, CardBack.Alexandrie),
            new Card(CardType.CardMaterialPaper, CardBack.Alexandrie),
            new Card(CardType.CardMaterialBrick, CardBack.Alexandrie),
            new Card(CardType.CardMaterialBrick, CardBack.Alexandrie),
            new Card(CardType.CardMaterialStone, CardBack.Alexandrie),
            new Card(CardType.CardMaterialStone, CardBack.Alexandrie),
            new Card(CardType.CardMaterialGlass, CardBack.Alexandrie),
            new Card(CardType.CardMaterialGold, CardBack.Alexandrie),
            new Card(CardType.CardMaterialGold, CardBack.Alexandrie),
            new Card(CardType.CardMaterialGold, CardBack.Alexandrie),
            new Card(CardType.CardMaterialGold, CardBack.Alexandrie),

                    // science
            new Card(CardType.CardScienceLaw, CardBack.Alexandrie),
            new Card(CardType.CardScienceMechanic, CardBack.Alexandrie),
            new Card(CardType.CardScienceMechanic, CardBack.Alexandrie),
            new Card(CardType.CardScienceArchitect, CardBack.Alexandrie),

                    // war

            new Card(CardType.CardWar_barbarian, CardBack.Alexandrie),
            new Card(CardType.CardWar_centurion, CardBack.Alexandrie),
            new Card(CardType.CardWar_centurion, CardBack.Alexandrie),
            new Card(CardType.CardWar_archer, CardBack.Alexandrie),

                    // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Alexandrie),
            new Card(CardType.CardPolitic_emperor, CardBack.Alexandrie),
            new Card(CardType.CardPolitic_cat, CardBack.Alexandrie),
            new Card(CardType.CardPolitic_cat, CardBack.Alexandrie),
            })),

    D_Halicarnassus(Arrays.asList(new Card[]{

            new Card(CardType.CardMaterialWood, CardBack.Halicarnassus),
            new Card(CardType.CardMaterialWood, CardBack.Halicarnassus),
            new Card(CardType.CardMaterialPaper, CardBack.Halicarnassus),// 2-1
            new Card(CardType.CardMaterialBrick, CardBack.Halicarnassus),
            new Card(CardType.CardMaterialBrick, CardBack.Halicarnassus),//
            new Card(CardType.CardMaterialStone, CardBack.Halicarnassus),
            new Card(CardType.CardMaterialStone, CardBack.Halicarnassus),//
            new Card(CardType.CardMaterialGlass, CardBack.Halicarnassus),
            new Card(CardType.CardMaterialGlass, CardBack.Halicarnassus), //
            new Card(CardType.CardMaterialGold, CardBack.Halicarnassus),
            new Card(CardType.CardMaterialGold, CardBack.Halicarnassus),
            new Card(CardType.CardMaterialGold, CardBack.Halicarnassus), // 2+1

            // science

            new Card(CardType.CardScienceLaw, CardBack.Halicarnassus),
            new Card(CardType.CardScienceLaw, CardBack.Halicarnassus),//
            new Card(CardType.CardScienceMechanic, CardBack.Halicarnassus), //
            new Card(CardType.CardScienceArchitect, CardBack.Halicarnassus), //

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Halicarnassus), //
            new Card(CardType.CardWar_barbarian, CardBack.Halicarnassus),
            new Card(CardType.CardWar_centurion, CardBack.Halicarnassus),//
            new Card(CardType.CardWar_centurion, CardBack.Halicarnassus),//
            new Card(CardType.CardWar_archer, CardBack.Halicarnassus), //

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Halicarnassus),
            new Card(CardType.CardPolitic_emperor, CardBack.Halicarnassus), //
            new Card(CardType.CardPolitic_cat, CardBack.Halicarnassus),//
            new Card(CardType.CardPolitic_cat, CardBack.Halicarnassus), //
    })),

    D_Ephesus(Arrays.asList(new Card[] {
            new Card(CardType.CardMaterialWood, CardBack.Ephesus),
            new Card(CardType.CardMaterialWood, CardBack.Ephesus),//
            new Card(CardType.CardMaterialPaper, CardBack.Ephesus),
            new Card(CardType.CardMaterialPaper, CardBack.Ephesus),//
            new Card(CardType.CardMaterialBrick, CardBack.Ephesus),
            new Card(CardType.CardMaterialBrick, CardBack.Ephesus),//
            new Card(CardType.CardMaterialStone, CardBack.Ephesus),
            new Card(CardType.CardMaterialStone, CardBack.Ephesus),//
            new Card(CardType.CardMaterialGlass, CardBack.Ephesus),
            new Card(CardType.CardMaterialGlass, CardBack.Ephesus),//
            new Card(CardType.CardMaterialGold, CardBack.Ephesus),
            new Card(CardType.CardMaterialGold, CardBack.Ephesus),
            new Card(CardType.CardMaterialGold, CardBack.Ephesus),// 2+1

            // science

            new Card(CardType.CardScienceLaw, CardBack.Ephesus),
            new Card(CardType.CardScienceLaw, CardBack.Ephesus),//
            new Card(CardType.CardScienceMechanic, CardBack.Ephesus), //
            new Card(CardType.CardScienceArchitect, CardBack.Ephesus),
            new Card(CardType.CardScienceArchitect, CardBack.Ephesus),//

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Ephesus), //
            new Card(CardType.CardWar_centurion, CardBack.Ephesus),
            new Card(CardType.CardWar_centurion, CardBack.Ephesus),//
            new Card(CardType.CardWar_archer, CardBack.Ephesus), //

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Ephesus), //
            new Card(CardType.CardPolitic_cat, CardBack.Ephesus),
            new Card(CardType.CardPolitic_cat, CardBack.Ephesus),//
    })),

    D_Olympia(Arrays.asList(new Card[] {
            new Card(CardType.CardMaterialWood, CardBack.Olympia), // 2-1
            new Card(CardType.CardMaterialPaper, CardBack.Olympia),
            new Card(CardType.CardMaterialPaper, CardBack.Olympia),//
            new Card(CardType.CardMaterialBrick, CardBack.Olympia),
            new Card(CardType.CardMaterialBrick, CardBack.Olympia),//
            new Card(CardType.CardMaterialStone, CardBack.Olympia),
            new Card(CardType.CardMaterialStone, CardBack.Olympia),//
            new Card(CardType.CardMaterialGlass, CardBack.Olympia),
            new Card(CardType.CardMaterialGlass, CardBack.Olympia),//
            new Card(CardType.CardMaterialGold, CardBack.Olympia),
            new Card(CardType.CardMaterialGold, CardBack.Olympia),
            new Card(CardType.CardMaterialGold, CardBack.Olympia),

            // science

            new Card(CardType.CardScienceLaw, CardBack.Olympia),
            new Card(CardType.CardScienceLaw, CardBack.Olympia),//
            new Card(CardType.CardScienceMechanic, CardBack.Olympia), //
            new Card(CardType.CardScienceArchitect, CardBack.Olympia), //

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Olympia),
            new Card(CardType.CardWar_barbarian, CardBack.Olympia),//
            new Card(CardType.CardWar_centurion, CardBack.Olympia),
            new Card(CardType.CardWar_centurion, CardBack.Olympia),//
            new Card(CardType.CardWar_archer, CardBack.Olympia), //
            // politics
            new Card(CardType.CardPolitic_emperor, CardBack.Olympia), //
            new Card(CardType.CardPolitic_cat, CardBack.Olympia),
            new Card(CardType.CardPolitic_cat, CardBack.Olympia),
            new Card(CardType.CardPolitic_cat, CardBack.Olympia),
    })),

    D_Babylonia(Arrays.asList(new Card[] {
            new Card(CardType.CardMaterialWood, CardBack.Babylonia),
            new Card(CardType.CardMaterialWood, CardBack.Babylonia),//
            new Card(CardType.CardMaterialPaper, CardBack.Babylonia),
            new Card(CardType.CardMaterialPaper, CardBack.Babylonia),//
            new Card(CardType.CardMaterialBrick, CardBack.Babylonia), // 2-1
            new Card(CardType.CardMaterialStone, CardBack.Babylonia),
            new Card(CardType.CardMaterialStone, CardBack.Babylonia),//
            new Card(CardType.CardMaterialGlass, CardBack.Babylonia),
            new Card(CardType.CardMaterialGlass, CardBack.Babylonia),//
            new Card(CardType.CardMaterialGold, CardBack.Babylonia),
            new Card(CardType.CardMaterialGold, CardBack.Babylonia),
            new Card(CardType.CardMaterialGold, CardBack.Babylonia),

            // science

            new Card(CardType.CardScienceLaw, CardBack.Babylonia), //
            new Card(CardType.CardScienceMechanic, CardBack.Babylonia),
            new Card(CardType.CardScienceMechanic, CardBack.Babylonia),//
            new Card(CardType.CardScienceArchitect, CardBack.Babylonia),
            new Card(CardType.CardScienceArchitect, CardBack.Babylonia),

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Babylonia), //
            new Card(CardType.CardWar_centurion, CardBack.Babylonia),
            new Card(CardType.CardWar_centurion, CardBack.Babylonia),//
            new Card(CardType.CardWar_archer, CardBack.Babylonia),

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Babylonia),
            new Card(CardType.CardPolitic_emperor, CardBack.Babylonia), //
            new Card(CardType.CardPolitic_cat, CardBack.Babylonia), //
            new Card(CardType.CardPolitic_cat, CardBack.Babylonia),
    })),

    D_Rhodes(Arrays.asList(new Card[] {
            // material
            new Card(CardType.CardMaterialWood, CardBack.Rhodes),
            new Card(CardType.CardMaterialWood, CardBack.Rhodes),//
            new Card(CardType.CardMaterialPaper, CardBack.Rhodes),
            new Card(CardType.CardMaterialPaper, CardBack.Rhodes),
            new Card(CardType.CardMaterialBrick, CardBack.Rhodes),
            new Card(CardType.CardMaterialBrick, CardBack.Rhodes),//
            new Card(CardType.CardMaterialStone, CardBack.Rhodes),
            new Card(CardType.CardMaterialStone, CardBack.Rhodes),//
            new Card(CardType.CardMaterialGlass, CardBack.Rhodes),
            new Card(CardType.CardMaterialGlass, CardBack.Rhodes), //
            new Card(CardType.CardMaterialGold, CardBack.Rhodes), //
            new Card(CardType.CardMaterialGold, CardBack.Rhodes), //

            // science

            new Card(CardType.CardScienceLaw, CardBack.Rhodes), //
            new Card(CardType.CardScienceMechanic, CardBack.Rhodes),
            new Card(CardType.CardScienceMechanic, CardBack.Rhodes), //
            new Card(CardType.CardScienceArchitect, CardBack.Rhodes), //

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Rhodes),
            new Card(CardType.CardWar_barbarian, CardBack.Rhodes), //
            new Card(CardType.CardWar_centurion, CardBack.Rhodes),//
            new Card(CardType.CardWar_centurion, CardBack.Rhodes), //
            new Card(CardType.CardWar_archer, CardBack.Rhodes), //

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Rhodes),
            new Card(CardType.CardPolitic_emperor, CardBack.Rhodes), //
            new Card(CardType.CardPolitic_cat, CardBack.Rhodes),//
            new Card(CardType.CardPolitic_cat, CardBack.Rhodes),
    })),

    D_Gizeh(Arrays.asList(new Card [] {
            // material
            new Card(CardType.CardMaterialWood, CardBack.Gizeh),
            new Card(CardType.CardMaterialWood, CardBack.Gizeh),//
            new Card(CardType.CardMaterialPaper, CardBack.Gizeh),
            new Card(CardType.CardMaterialPaper, CardBack.Gizeh),//
            new Card(CardType.CardMaterialBrick, CardBack.Gizeh), // 2-1
            new Card(CardType.CardMaterialStone, CardBack.Gizeh),
            new Card(CardType.CardMaterialStone, CardBack.Gizeh),//
            new Card(CardType.CardMaterialGlass, CardBack.Gizeh),
            new Card(CardType.CardMaterialGlass, CardBack.Gizeh),//
            new Card(CardType.CardMaterialGold, CardBack.Gizeh),
            new Card(CardType.CardMaterialGold, CardBack.Gizeh),
            new Card(CardType.CardMaterialGold, CardBack.Gizeh),

            // science

            new Card(CardType.CardScienceLaw, CardBack.Gizeh), //
            new Card(CardType.CardScienceMechanic, CardBack.Gizeh), //
            new Card(CardType.CardScienceArchitect, CardBack.Gizeh),
            new Card(CardType.CardScienceArchitect, CardBack.Gizeh),//
            // war
            new Card(CardType.CardWar_barbarian, CardBack.Gizeh),
            new Card(CardType.CardWar_barbarian, CardBack.Gizeh), //
            new Card(CardType.CardWar_centurion, CardBack.Gizeh),//
            new Card(CardType.CardWar_centurion, CardBack.Gizeh), //ù

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Gizeh),
            new Card(CardType.CardPolitic_emperor, CardBack.Gizeh), //
            new Card(CardType.CardPolitic_cat, CardBack.Gizeh),//
            new Card(CardType.CardPolitic_cat, CardBack.Gizeh), //
            new Card(CardType.CardPolitic_cat, CardBack.Gizeh), //
    })),

    D_milieu(Arrays.asList(
            // material
            new Card(CardType.CardMaterialWood, CardBack.CentralDeck), //
            new Card(CardType.CardMaterialWood, CardBack.CentralDeck),
            new Card(CardType.CardMaterialWood, CardBack.CentralDeck),
            new Card(CardType.CardMaterialWood, CardBack.CentralDeck),
            new Card(CardType.CardMaterialPaper, CardBack.CentralDeck), //
            new Card(CardType.CardMaterialPaper, CardBack.CentralDeck),
            new Card(CardType.CardMaterialPaper, CardBack.CentralDeck),
            new Card(CardType.CardMaterialPaper, CardBack.CentralDeck),
            new Card(CardType.CardMaterialBrick, CardBack.CentralDeck), //
            new Card(CardType.CardMaterialBrick, CardBack.CentralDeck),
            new Card(CardType.CardMaterialBrick, CardBack.CentralDeck),
            new Card(CardType.CardMaterialBrick, CardBack.CentralDeck),
            new Card(CardType.CardMaterialStone, CardBack.CentralDeck), //
            new Card(CardType.CardMaterialStone, CardBack.CentralDeck),
            new Card(CardType.CardMaterialStone, CardBack.CentralDeck),
            new Card(CardType.CardMaterialStone, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGlass, CardBack.CentralDeck), //
            new Card(CardType.CardMaterialGlass, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGlass, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGlass, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGold, CardBack.CentralDeck), //
            new Card(CardType.CardMaterialGold, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGold, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGold, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGold, CardBack.CentralDeck),
            new Card(CardType.CardMaterialGold, CardBack.CentralDeck),

            // science

            new Card(CardType.CardScienceLaw, CardBack.CentralDeck), //
            new Card(CardType.CardScienceLaw, CardBack.CentralDeck),
            new Card(CardType.CardScienceLaw, CardBack.CentralDeck),
            new Card(CardType.CardScienceLaw, CardBack.CentralDeck),
            new Card(CardType.CardScienceMechanic, CardBack.CentralDeck), //
            new Card(CardType.CardScienceMechanic, CardBack.CentralDeck),
            new Card(CardType.CardScienceMechanic, CardBack.CentralDeck),
            new Card(CardType.CardScienceMechanic, CardBack.CentralDeck),
            new Card(CardType.CardScienceArchitect, CardBack.CentralDeck), //
            new Card(CardType.CardScienceArchitect, CardBack.CentralDeck),
            new Card(CardType.CardScienceArchitect, CardBack.CentralDeck),
            new Card(CardType.CardScienceArchitect, CardBack.CentralDeck),
    //
            // war

            new Card(CardType.CardWar_barbarian, CardBack.CentralDeck), //
            new Card(CardType.CardWar_barbarian, CardBack.CentralDeck),
            new Card(CardType.CardWar_barbarian, CardBack.CentralDeck),
            new Card(CardType.CardWar_barbarian, CardBack.CentralDeck),
            new Card(CardType.CardWar_centurion, CardBack.CentralDeck), //
            new Card(CardType.CardWar_centurion, CardBack.CentralDeck),
            new Card(CardType.CardWar_centurion, CardBack.CentralDeck),
            new Card(CardType.CardWar_centurion, CardBack.CentralDeck),
            new Card(CardType.CardWar_archer, CardBack.CentralDeck), //
            new Card(CardType.CardWar_archer, CardBack.CentralDeck),

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.CentralDeck), //
            new Card(CardType.CardPolitic_emperor, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_emperor, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_emperor, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck), //
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck),
            new Card(CardType.CardPolitic_cat, CardBack.CentralDeck)

    ));

    public List<Card> listeCartes;

    private Decks(List listeCartes) {
        this.listeCartes = listeCartes;
    }

    public List<Card> getListeCartes() {
        return listeCartes;
    }

}
