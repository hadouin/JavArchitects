package fr.isep.javarchitects.core;

import fr.isep.javarchitects.utils.WonderImage;
import fr.isep.javarchitects.utils.WonderImageType;

import java.util.List;

public enum WonderFactory {
    Alexandria{
            @Override
            public Wonder createWonder() {
                return new Wonder(0,"Alexandrie", "Alexandrie", //
                        "Prenez la premi�re carte d'une pioche au choix, n'importe o� sur la table, et posez-la devant vous",
                        DeckFactory.Alexandria,
                        List.of(
                                new WonderFragment(WonderImage.Alexandria.getImage(WonderImageType.FRONT_1), WonderImage.Alexandria.getImage(WonderImageType.BACK_1), 0, false, 4, 2, false),
                                new WonderFragment(WonderImage.Alexandria.getImage(WonderImageType.FRONT_2), WonderImage.Alexandria.getImage(WonderImageType.BACK_2), 1, true, 3, 2, true),
                                new WonderFragment(WonderImage.Alexandria.getImage(WonderImageType.FRONT_3), WonderImage.Alexandria.getImage(WonderImageType.BACK_3), 2, false, 6, 3, false),
                                new WonderFragment(WonderImage.Alexandria.getImage(WonderImageType.FRONT_4), WonderImage.Alexandria.getImage(WonderImageType.BACK_4), 3, true, 5, 3, true),
                                new WonderFragment(WonderImage.Alexandria.getImage(WonderImageType.FRONT_5), WonderImage.Alexandria.getImage(WonderImageType.BACK_5), 4, false, 7, 4, false)
                        ));
            }
    },
    Halicarnassus{
        @Override
        public Wonder createWonder() {
            return new Wonder(1,"Halicarnasse", "Halicarnasse", //
                    "Prenez les 5 premières cartes de la pioche à votre gauche ou à votre droite, choisissez-en 1 et posez-la devant vous" //
                            + "Mélangez-les cartes restantes dans leur pioche",
                    DeckFactory.Halicarnassus,
                    List.of(
                            new WonderFragment(WonderImage.Halicarnassus.getImage(WonderImageType.FRONT_1), WonderImage.Halicarnassus.getImage(WonderImageType.BACK_1), 0, false, 3, 2, false),
                            new WonderFragment(WonderImage.Halicarnassus.getImage(WonderImageType.FRONT_2), WonderImage.Halicarnassus.getImage(WonderImageType.BACK_2), 1, true, 3, 2, true),
                            new WonderFragment(WonderImage.Halicarnassus.getImage(WonderImageType.FRONT_3), WonderImage.Halicarnassus.getImage(WonderImageType.BACK_3), 2, true, 5, 3, true),
                            new WonderFragment(WonderImage.Halicarnassus.getImage(WonderImageType.FRONT_4), WonderImage.Halicarnassus.getImage(WonderImageType.BACK_4), 2, false, 6, 3, false),
                            new WonderFragment(WonderImage.Halicarnassus.getImage(WonderImageType.FRONT_5), WonderImage.Alexandria.getImage(WonderImageType.BACK_5), 3, false, 7, 4, false)
                    ));
        }
    },
    Ephesus{
        @Override
        public Wonder createWonder( ) {
            return new Wonder(2, "Ephese", "Eph�se", //
                    "Prenez la premi�re carte de la pioche centrale et posez-la devant vous",
                    DeckFactory.Ephesus,
                    List.of(
                            new WonderFragment(WonderImage.Ephesus.getImage(WonderImageType.FRONT_1), WonderImage.Ephesus.getImage(WonderImageType.BACK_1), 0, false, 3, 2, false),
                            new WonderFragment(WonderImage.Ephesus.getImage(WonderImageType.FRONT_2), WonderImage.Ephesus.getImage(WonderImageType.BACK_2), 1, true, 3, 2, true),
                            new WonderFragment(WonderImage.Ephesus.getImage(WonderImageType.FRONT_3), WonderImage.Ephesus.getImage(WonderImageType.BACK_3), 1, true, 5, 3, true),
                            new WonderFragment(WonderImage.Ephesus.getImage(WonderImageType.FRONT_4), WonderImage.Ephesus.getImage(WonderImageType.BACK_4), 1, true, 4, 3, false),
                            new WonderFragment(WonderImage.Ephesus.getImage(WonderImageType.FRONT_5), WonderImage.Ephesus.getImage(WonderImageType.BACK_5), 2, false, 7, 4, false)
                    ));
        }},
    Olympia{
        @Override
        public Wonder createWonder() {
            return new Wonder(3, "Olympie", "Olympie", //
                    "Prenez la premi�re carte de la pioche � votre cauche et de celle � votre droite, et posez-les devant vous",
                    DeckFactory.Olympia,
                    List.of(
                            new WonderFragment(WonderImage.Olympia.getImage(WonderImageType.FRONT_1), WonderImage.Olympia.getImage(WonderImageType.BACK_1), 0, false, 3, 2, false),
                            new WonderFragment(WonderImage.Olympia.getImage(WonderImageType.FRONT_2), WonderImage.Olympia.getImage(WonderImageType.BACK_2), 2, true, 2, 2, true),
                            new WonderFragment(WonderImage.Olympia.getImage(WonderImageType.FRONT_3), WonderImage.Olympia.getImage(WonderImageType.BACK_3), 1, false, 5, 3, false),
                            new WonderFragment(WonderImage.Olympia.getImage(WonderImageType.FRONT_4), WonderImage.Olympia.getImage(WonderImageType.BACK_4), 2, true, 5, 3, true),
                            new WonderFragment(WonderImage.Olympia.getImage(WonderImageType.FRONT_5), WonderImage.Olympia.getImage(WonderImageType.BACK_5), 3, false, 7, 4, false)
                    ));
        }},
    Babylon {
        @Override
        public Wonder createWonder() {
            return new Wonder(4, "Babylone", "Babylone", //
                    "Choisissez 1 jeton Progr�s parmi les 4 disponibles, et posez-le devant vous",
                    DeckFactory.Babylon,
                    List.of(
                            new WonderFragment(WonderImage.Babylon.getImage(WonderImageType.FRONT_1), WonderImage.Babylon.getImage(WonderImageType.BACK_1), 0, false, 3, 2, false),
                            new WonderFragment(WonderImage.Babylon.getImage(WonderImageType.FRONT_2), WonderImage.Babylon.getImage(WonderImageType.BACK_2), 1, true, 0, 2, true),
                            new WonderFragment(WonderImage.Babylon.getImage(WonderImageType.FRONT_3), WonderImage.Babylon.getImage(WonderImageType.BACK_3), 2, false, 5, 3, false),
                            new WonderFragment(WonderImage.Babylon.getImage(WonderImageType.FRONT_4), WonderImage.Babylon.getImage(WonderImageType.BACK_4), 3, false, 5, 3, true),
                            new WonderFragment(WonderImage.Babylon.getImage(WonderImageType.FRONT_5), WonderImage.Babylon.getImage(WonderImageType.BACK_5), 3, true, 7, 4, false)
                    ));
        }},
    Rhodes{
        @Override
        public Wonder createWonder() {
            return new Wonder(5, "Rhodes", "Rhodes", //
                    "Ajoutez 1 Bouclier � votre total de Boucliers",
                    DeckFactory.Rhodes,
                    List.of(
                            new WonderFragment(WonderImage.Rhodes.getImage(WonderImageType.FRONT_1), WonderImage.Rhodes.getImage(WonderImageType.BACK_1), 0, false, 4, 2, false),
                            new WonderFragment(WonderImage.Rhodes.getImage(WonderImageType.FRONT_2), WonderImage.Rhodes.getImage(WonderImageType.BACK_2), 0, true, 4, 2, true),
                            new WonderFragment(WonderImage.Rhodes.getImage(WonderImageType.FRONT_3), WonderImage.Rhodes.getImage(WonderImageType.BACK_3), 1, false, 5, 3, false),
                            new WonderFragment(WonderImage.Rhodes.getImage(WonderImageType.FRONT_4), WonderImage.Rhodes.getImage(WonderImageType.BACK_4), 2, true, 6, 3, true),
                            new WonderFragment(WonderImage.Rhodes.getImage(WonderImageType.FRONT_5), WonderImage.Rhodes.getImage(WonderImageType.BACK_5), 3, false, 7, 4, false)
                    ));
        }
    },
    Gizeh{
        @Override
        public Wonder createWonder() {
            return new Wonder(6, "Gizeh", "Gizeh", //
                    "Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles",
                    DeckFactory.Gizeh,
                    List.of(
                            new WonderFragment(WonderImage.Gizeh.getImage(WonderImageType.FRONT_1), WonderImage.Gizeh.getImage(WonderImageType.BACK_1), 0, false, 4, 2, false),
                            new WonderFragment(WonderImage.Gizeh.getImage(WonderImageType.FRONT_2), WonderImage.Gizeh.getImage(WonderImageType.BACK_2), 1, false, 5, 2, true),
                            new WonderFragment(WonderImage.Gizeh.getImage(WonderImageType.FRONT_3), WonderImage.Gizeh.getImage(WonderImageType.BACK_3), 2, false, 6, 3, false),
                            new WonderFragment(WonderImage.Gizeh.getImage(WonderImageType.FRONT_4), WonderImage.Gizeh.getImage(WonderImageType.BACK_4), 3, false, 7, 3, true),
                            new WonderFragment(WonderImage.Gizeh.getImage(WonderImageType.FRONT_5), WonderImage.Gizeh.getImage(WonderImageType.BACK_5), 4, false, 8, 4, true)
                    ));
        }
    };

    public abstract Wonder createWonder();
}
