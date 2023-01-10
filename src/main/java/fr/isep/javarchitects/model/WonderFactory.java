package fr.isep.javarchitects.model;

import java.util.List;

public enum WonderFactory {
    Alexandria{
            @Override
            public Wonder createWonder() {
                return new Wonder(0,"Alexandrie", "Alexandrie", //
                        "Prenez la premi�re carte d'une pioche au choix, n'importe o� sur la table, et posez-la devant vous",
                        List.of(
                                new WonderFragment("/images/wonders/alexandrie/piece-front-alexandrie-1.png", "/images/wonders/alexandrie/piece-back-alexandrie-1.png", 0, false, 4, 2, false),
                                new WonderFragment("/images/wonders/alexandrie/piece-front-alexandrie-2.png", "/images/wonders/alexandrie/piece-back-alexandrie-2.png", 1, true, 3, 2, true),
                                new WonderFragment("/images/wonders/alexandrie/piece-front-alexandrie-3.png", "/images/wonders/alexandrie/piece-back-alexandrie-3.png", 2, false, 6, 3, false),
                                new WonderFragment("/images/wonders/alexandrie/piece-front-alexandrie-4.png", "/images/wonders/alexandrie/piece-back-alexandrie-4.png", 3, true, 5, 3, true),
                                new WonderFragment("/images/wonders/alexandrie/piece-front-alexandrie-5.png", "/images/wonders/alexandrie/piece-back-alexandrie-5.png", 4, false, 7, 4, false)
                        ));
            }
    },
    Halicarnassus{
        @Override
        public Wonder createWonder() {
            return new Wonder(1,"Halicarnasse", "Halicarnasse", //
                    "Prenez les 5 premières cartes de la pioche à votre gauche ou à votre droite, choisissez-en 1 et posez-la devant vous" //
                            + "Mélangez-les cartes restantes dans leur pioche",
                    List.of(
                            new WonderFragment("/images/wonders/halicarnasse/piece-front-halicarnasse-1.png", "/images/wonders/halicarnasse/piece-back-halicarnasse-1.png", 0, false, 3, 2, false),
                            new WonderFragment("/images/wonders/halicarnasse/piece-front-halicarnasse-2.png", "/images/wonders/halicarnasse/piece-back-halicarnasse-2bis.png", 1, true, 3, 2, true),
                            new WonderFragment("/images/wonders/halicarnasse/piece-front-halicarnasse-3.png", "/images/wonders/halicarnasse/piece-back-halicarnasse-3.png", 2, true, 5, 3, true),
                            new WonderFragment("/images/wonders/halicarnasse/piece-front-halicarnasse-4.png", "/images/wonders/halicarnasse/piece-back-halicarnasse-4.png", 2, false, 6, 3, false),
                            new WonderFragment("/images/wonders/halicarnasse/piece-front-halicarnasse-5.png", "/images/wonders/halicarnasse/piece-back-halicarnasse-5.png", 3, false, 7, 4, false)
                    ));
        }
    },
    Ephesus{
        @Override
        public Wonder createWonder( ) {
            return new Wonder(2, "Ephese", "Eph�se", //
                    "Prenez la premi�re carte de la pioche centrale et posez-la devant vous",
                    List.of(
                            new WonderFragment("/images/wonders/ephese/piece-front-ephese-1.png", "/images/wonders/ephese/piece-back-ephese-1.png", 0, false, 3, 2, false),
                            new WonderFragment("/images/wonders/ephese/piece-front-ephese-2.png", "/images/wonders/ephese/piece-back-ephese-2.png", 1, true, 3, 2, true),
                            new WonderFragment("/images/wonders/ephese/piece-front-ephese-3.png", "/images/wonders/ephese/piece-back-ephese-3.png", 1, true, 5, 3, true),
                            new WonderFragment("/images/wonders/ephese/piece-front-ephese-4.png", "/images/wonders/ephese/piece-back-ephese-4.png", 1, true, 4, 3, false),
                            new WonderFragment("/images/wonders/ephese/piece-front-ephese-5.png", "/images/wonders/ephese/piece-back-ephese-5.png", 2, false, 7, 4, false)
                    ));
        }},
    Olympia{
        @Override
        public Wonder createWonder() {
            return new Wonder(3, "Olympie", "Olympie", //
                    "Prenez la premi�re carte de la pioche � votre cauche et de celle � votre droite, et posez-les devant vous",
                    List.of(
                            new WonderFragment("/images/wonders/olympie/piece-front-olympie-1.png", "/images/wonders/olympie/piece-back-olympie-1.png", 0, false, 3, 2, false),
                            new WonderFragment("/images/wonders/olympie/piece-front-olympie-2.png", "/images/wonders/olympie/piece-back-olympie-2.png", 2, true, 2, 2, true),
                            new WonderFragment("/images/wonders/olympie/piece-front-olympie-3.png", "/images/wonders/olympie/piece-back-olympie-3.png", 1, false, 5, 3, false),
                            new WonderFragment("/images/wonders/olympie/piece-front-olympie-4.png", "/images/wonders/olympie/piece-back-olympie-4.png", 2, true, 5, 3, true),
                            new WonderFragment("/images/wonders/olympie/piece-front-olympie-5.png", "/images/wonders/olympie/piece-back-olympie-5.png", 3, false, 7, 4, false)
                    ));
        }},
    Babylonia{
        @Override
        public Wonder createWonder() {
            return new Wonder(4, "Babylone", "Babylone", //
                    "Choisissez 1 jeton Progr�s parmi les 4 disponibles, et posez-le devant vous",
                    List.of(
                            new WonderFragment("/images/wonders/babylon/piece-front-babylon-1.png", "/images/wonders/babylon/piece-back-babylon-1.png", 0, false, 3, 2, false),
                            new WonderFragment("/images/wonders/babylon/piece-front-babylon-2.png", "/images/wonders/babylon/piece-back-babylon-2.png", 1, true, 0, 2, true),
                            new WonderFragment("/images/wonders/babylon/piece-front-babylon-3.png", "/images/wonders/babylon/piece-back-babylon-3.png", 2, false, 5, 3, false),
                            new WonderFragment("/images/wonders/babylon/piece-front-babylon-4.png", "/images/wonders/babylon/piece-back-babylon-5.png", 3, false, 5, 3, true),
                            new WonderFragment("/images/wonders/babylon/piece-front-babylon-5.png", "/images/wonders/babylon/piece-back-babylon-4.png", 3, true, 7, 4, false)
                    ));
        }},
    Rhodes{
        @Override
        public Wonder createWonder() {
            return new Wonder(5, "Rhodes", "Rhodes", //
                    "Ajoutez 1 Bouclier � votre total de Boucliers",
                    List.of(
                            new WonderFragment("/images/wonders/rhodes/piece-front-rhodes-1.png", "/images/wonders/rhodes/piece-back-rhodes-1.png", 0, false, 4, 2, false),
                            new WonderFragment("/images/wonders/rhodes/piece-front-rhodes-2.png", "/images/wonders/rhodes/piece-back-rhodes-2.png", 0, true, 4, 2, true),
                            new WonderFragment("/images/wonders/rhodes/piece-front-rhodes-3.png", "/images/wonders/rhodes/piece-back-rhodes-3.png", 1, false, 5, 3, false),
                            new WonderFragment("/images/wonders/rhodes/piece-front-rhodes-4.png", "/images/wonders/rhodes/piece-back-rhodes-4.png", 2, true, 6, 3, true),
                            new WonderFragment("/images/wonders/rhodes/piece-front-rhodes-5.png", "/images/wonders/rhodes/piece-back-rhodes-5.png", 3, false, 7, 4, false)
                    ));
        }
    },
    Gizeh{
        @Override
        public Wonder createWonder() {
            return new Wonder(6, "Gizeh", "Gizeh", //
                    "Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles",
                    List.of(
                            new WonderFragment("/images/wonders/giseh/piece-front-giseh-1.png", "/images/wonders/giseh/piece-back-giseh-1.png", 0, false, 4, 2, false),
                            new WonderFragment("/images/wonders/giseh/piece-front-giseh-2.png", "/images/wonders/giseh/piece-back-giseh-2.png", 1, false, 5, 2, true),
                            new WonderFragment("/images/wonders/giseh/piece-front-giseh-3.png", "/images/wonders/giseh/piece-back-giseh-3.png", 2, false, 6, 3, false),
                            new WonderFragment("/images/wonders/giseh/piece-front-giseh-4.png", "/images/wonders/giseh/piece-back-giseh-4.png", 3, false, 7, 3, true),
                            new WonderFragment("/images/wonders/giseh/piece-front-giseh-5.png", "/images/wonders/giseh/piece-back-giseh-5.png", 4, false, 8, 4, true)
                    ));
        }
    };

    public abstract Wonder createWonder();
}
