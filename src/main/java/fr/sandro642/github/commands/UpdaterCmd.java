package fr.sandro642.github.commands;

import fr.sandro642.github.Updater.Updater;
import fr.sandro642.github.misc.GithubAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GitHub;


/**
 * @Owner Sandro642
 * @Repository UpdaterApi
 * @CurrentVersion 1.0
 * @Description This class is used to update your application.
 */

public class UpdaterCmd implements CommandExecutor {

    /**
     * Ajout de l'instance plugin.
     */

    private Plugin plugin;
    public static void setPlugin(Plugin plugin) {
        UpdaterCmd.setPlugin(plugin);
    }


    /**
     * Création de la commande native.
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase(Updater.getUpdater().nameCommand)) {
            if (sender.hasPermission(Updater.getUpdater().namePermission)) return true;

            sender.sendMessage("Vérification des mises à jour...");

            try {

                // Connexion anonyme à l'API GitHub
                GitHub github = GitHub.connect(Updater.getUpdater().owner, Updater.getUpdater().accessToken);
                GHRelease latestRelease = github.getRepository(Updater.getUpdater().owner + "/" + Updater.getUpdater().repository).getLatestRelease();

                // Extraire le numéro de version sans le "v" du début
                String latestVersion = latestRelease.getTagName().substring(1);

                // Comparer les versions pour vérifier s'il y a une nouvelle version disponible
                if (GithubAPI.getGithubAPI().isNewerVersion(latestVersion, Updater.getUpdater().currentVersion)) {
                    sender.sendMessage("Nouvelle version trouvée : " + latestVersion);
                    // Télécharger la mise à jour
                    GithubAPI.getGithubAPI().downloadUpdate(latestRelease.getAssets().get(0).getBrowserDownloadUrl());
                    sender.sendMessage("La mise à jour a été téléchargée et installée.");
                } else {
                    sender.sendMessage("Votre plugin est à jour!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }



        return false;
    }
}