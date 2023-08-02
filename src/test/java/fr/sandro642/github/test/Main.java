package fr.sandro642.github.test;

import fr.sandro642.github.UpdaterAPI.UpdaterAPI;

public class Main {

    public static void main(String[] args) {
        UpdaterAPI.getUpdater().initAccessApi("Sandro642", "Updater", "1.0.0", "dzqildsq");
        UpdaterAPI.getUpdater().addCommand("updaterapi", "updaterapi.use");
    }
}
