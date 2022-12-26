package fr.isep.javarchitects;

import java.util.ArrayList;
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

    D_Halicarnasse(Arrays.asList(new Card[]{

            new Card(CardType.CardMaterialWood, CardBack.Halicarnasse),
            new Card(CardType.CardMaterialWood, CardBack.Halicarnasse),
            new Card(CardType.CardMaterialPaper, CardBack.Halicarnasse),// 2-1
            new Card(CardType.CardMaterialBrick, CardBack.Halicarnasse),
            new Card(CardType.CardMaterialBrick, CardBack.Halicarnasse),//
            new Card(CardType.CardMaterialStone, CardBack.Halicarnasse),
            new Card(CardType.CardMaterialStone, CardBack.Halicarnasse),//
            new Card(CardType.CardMaterialGlass, CardBack.Halicarnasse),
            new Card(CardType.CardMaterialGlass, CardBack.Halicarnasse), //
            new Card(CardType.CardMaterialGold, CardBack.Halicarnasse),
            new Card(CardType.CardMaterialGold, CardBack.Halicarnasse),
            new Card(CardType.CardMaterialGold, CardBack.Halicarnasse), // 2+1

            // science

            new Card(CardType.CardScienceLaw, CardBack.Halicarnasse),
            new Card(CardType.CardScienceLaw, CardBack.Halicarnasse),//
            new Card(CardType.CardScienceMechanic, CardBack.Halicarnasse), //
            new Card(CardType.CardScienceArchitect, CardBack.Halicarnasse), //

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Halicarnasse), //
            new Card(CardType.CardWar_barbarian, CardBack.Halicarnasse),
            new Card(CardType.CardWar_centurion, CardBack.Halicarnasse),//
            new Card(CardType.CardWar_centurion, CardBack.Halicarnasse),//
            new Card(CardType.CardWar_archer, CardBack.Halicarnasse), //

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Halicarnasse),
            new Card(CardType.CardPolitic_emperor, CardBack.Halicarnasse), //
            new Card(CardType.CardPolitic_cat, CardBack.Halicarnasse),//
            new Card(CardType.CardPolitic_cat, CardBack.Halicarnasse), //
    })),

    D_Ephese(Arrays.asList(new Card[] {
            new Card(CardType.CardMaterialWood, CardBack.Ephese),
            new Card(CardType.CardMaterialWood, CardBack.Ephese),//
            new Card(CardType.CardMaterialPaper, CardBack.Ephese),
            new Card(CardType.CardMaterialPaper, CardBack.Ephese),//
            new Card(CardType.CardMaterialBrick, CardBack.Ephese),
            new Card(CardType.CardMaterialBrick, CardBack.Ephese),//
            new Card(CardType.CardMaterialStone, CardBack.Ephese),
            new Card(CardType.CardMaterialStone, CardBack.Ephese),//
            new Card(CardType.CardMaterialGlass, CardBack.Ephese),
            new Card(CardType.CardMaterialGlass, CardBack.Ephese),//
            new Card(CardType.CardMaterialGold, CardBack.Ephese),
            new Card(CardType.CardMaterialGold, CardBack.Ephese),
            new Card(CardType.CardMaterialGold, CardBack.Ephese),// 2+1

            // science

            new Card(CardType.CardScienceLaw, CardBack.Ephese),
            new Card(CardType.CardScienceLaw, CardBack.Ephese),//
            new Card(CardType.CardScienceMechanic, CardBack.Ephese), //
            new Card(CardType.CardScienceArchitect, CardBack.Ephese),
            new Card(CardType.CardScienceArchitect, CardBack.Ephese),//

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Ephese), //
            new Card(CardType.CardWar_centurion, CardBack.Ephese),
            new Card(CardType.CardWar_centurion, CardBack.Ephese),//
            new Card(CardType.CardWar_archer, CardBack.Ephese), //

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Ephese), //
            new Card(CardType.CardPolitic_cat, CardBack.Ephese),
            new Card(CardType.CardPolitic_cat, CardBack.Ephese),//
    })),

    D_Olympie(Arrays.asList(new Card[] {
            new Card(CardType.CardMaterialWood, CardBack.Olympie), // 2-1
            new Card(CardType.CardMaterialPaper, CardBack.Olympie),
            new Card(CardType.CardMaterialPaper, CardBack.Olympie),//
            new Card(CardType.CardMaterialBrick, CardBack.Olympie),
            new Card(CardType.CardMaterialBrick, CardBack.Olympie),//
            new Card(CardType.CardMaterialStone, CardBack.Olympie),
            new Card(CardType.CardMaterialStone, CardBack.Olympie),//
            new Card(CardType.CardMaterialGlass, CardBack.Olympie),
            new Card(CardType.CardMaterialGlass, CardBack.Olympie),//
            new Card(CardType.CardMaterialGold, CardBack.Olympie),
            new Card(CardType.CardMaterialGold, CardBack.Olympie),
            new Card(CardType.CardMaterialGold, CardBack.Olympie),

            // science

            new Card(CardType.CardScienceLaw, CardBack.Olympie),
            new Card(CardType.CardScienceLaw, CardBack.Olympie),//
            new Card(CardType.CardScienceMechanic, CardBack.Olympie), //
            new Card(CardType.CardScienceArchitect, CardBack.Olympie), //

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Olympie),
            new Card(CardType.CardWar_barbarian, CardBack.Olympie),//
            new Card(CardType.CardWar_centurion, CardBack.Olympie),
            new Card(CardType.CardWar_centurion, CardBack.Olympie),//
            new Card(CardType.CardWar_archer, CardBack.Olympie), //
            // politics
            new Card(CardType.CardPolitic_emperor, CardBack.Olympie), //
            new Card(CardType.CardPolitic_cat, CardBack.Olympie),
            new Card(CardType.CardPolitic_cat, CardBack.Olympie),
            new Card(CardType.CardPolitic_cat, CardBack.Olympie),
    })),

    D_Babylone(Arrays.asList(new Card[] {
            new Card(CardType.CardMaterialWood, CardBack.Babylone),
            new Card(CardType.CardMaterialWood, CardBack.Babylone),//
            new Card(CardType.CardMaterialPaper, CardBack.Babylone),
            new Card(CardType.CardMaterialPaper, CardBack.Babylone),//
            new Card(CardType.CardMaterialBrick, CardBack.Babylone), // 2-1
            new Card(CardType.CardMaterialStone, CardBack.Babylone),
            new Card(CardType.CardMaterialStone, CardBack.Babylone),//
            new Card(CardType.CardMaterialGlass, CardBack.Babylone),
            new Card(CardType.CardMaterialGlass, CardBack.Babylone),//
            new Card(CardType.CardMaterialGold, CardBack.Babylone),
            new Card(CardType.CardMaterialGold, CardBack.Babylone),
            new Card(CardType.CardMaterialGold, CardBack.Babylone),

            // science

            new Card(CardType.CardScienceLaw, CardBack.Babylone), //
            new Card(CardType.CardScienceMechanic, CardBack.Babylone),
            new Card(CardType.CardScienceMechanic, CardBack.Babylone),//
            new Card(CardType.CardScienceArchitect, CardBack.Babylone),
            new Card(CardType.CardScienceArchitect, CardBack.Babylone),

            // war

            new Card(CardType.CardWar_barbarian, CardBack.Babylone), //
            new Card(CardType.CardWar_centurion, CardBack.Babylone),
            new Card(CardType.CardWar_centurion, CardBack.Babylone),//
            new Card(CardType.CardWar_archer, CardBack.Babylone),

            // politics

            new Card(CardType.CardPolitic_emperor, CardBack.Babylone),
            new Card(CardType.CardPolitic_emperor, CardBack.Babylone), //
            new Card(CardType.CardPolitic_cat, CardBack.Babylone), //
            new Card(CardType.CardPolitic_cat, CardBack.Babylone),
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
