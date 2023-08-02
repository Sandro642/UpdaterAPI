package fr.sandro642.github.misc;


import fr.sandro642.github.Updater.Updater;
import fr.sandro642.github.commands.UpdaterCmd;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Owner Sandro642
 * @Repository UpdaterApi
 * @CurrentVersion 1.0
 * @Description This class is used to update your application.
 * @License MIT
 */

public class GithubAPI {

    /**
     * Création de l'instance de la classe GithubAPI
     */

    private static GithubAPI githubAPI;


    /**
     * Ajout de l'instance plugin.
     */

    private Plugin plugin;
    public static void setPlugin(Plugin plugin) {
        GithubAPI.setPlugin(plugin);
    }


    /**
     * Création d'une méthode booléen pour vérifier si la version est plus récente.
     */

    public boolean isNewerVersion(String newVersion, String currentVersion) {
        // Mettez en œuvre une logique pour comparer les versions ici
        // Par exemple, vous pouvez séparer les numéros de version et les comparer individuellement.
        // Pour cet exemple, nous allons simplement comparer les chaînes.
        return newVersion.compareTo(currentVersion) > 0;
    }


    /**
     * Création d'une méthode pour télécharger la mise à jour.
     */

    public void downloadUpdate(String downloadUrl) throws IOException {
        // Récupérer le répertoire du plugin
        File pluginFile = plugin.getDataFolder().getParentFile();
        // Créer un nouveau fichier pour stocker la mise à jour
        File updateFile = new File(pluginFile, Updater.getUpdater().repository + "-update.jar");

        // Ouvrir une connexion pour télécharger le fichier à partir de l'URL
        try (InputStream in = new URL(downloadUrl).openStream();
             FileOutputStream out = new FileOutputStream(updateFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            // Lire les données depuis l'URL et les écrire dans le fichier de mise à jour
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }


    /**
     * Création d'un getter pour la classe.
     */

    public static GithubAPI getGithubAPI() {
        return githubAPI;
    }
}
