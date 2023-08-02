package fr.sandro642.github.test;

import fr.sandro642.github.Updater.Updater;

public class Main {

    public static void main(String[] args) {
        Updater.getUpdater().initAccessApi("Sandro642", "Updater", "1.0.0", "dzqildsq");
        Updater.getUpdater().addCommand("updaterapi", "updaterapi.use");
    }
}
