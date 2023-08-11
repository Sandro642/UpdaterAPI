package fr.sandro642.github.commands;

import fr.sandro642.github.UpdaterAPI.UpdaterAPI;
import fr.sandro642.github.misc.GithubAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GitHub;


/**
 * @Owner Sandro642
 * @Version 1.0
 * @Description Updater Command
 * @Date 19/02/2021
 * @Name UpdaterCmd
 * @Package fr.sandro642.github.commands
 * @Class UpdaterCmd
 * @Project UpdaterAPI
 * @License MIT License
 */

public class UpdaterCmd implements CommandExecutor {


    /**
     * @Plugin plugin
     */

    private Plugin plugin;


    /**
     * Constructeur de la classe UpdaterCmd
     * @param plugin
     */

    public UpdaterCmd(Plugin plugin) {
        this.plugin = plugin;
    }


    /**
     * @param plugin
     */

    public static void setPlugin(Plugin plugin) {
        // Updated to set the plugin for the GithubAPI class
        GithubAPI.setPlugin(plugin);
    }


    /**
     * @param sender
     * @param command
     * @param label
     * @param args
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase(UpdaterAPI.getUpdater().getNameCommand())) {
            if (sender.hasPermission(UpdaterAPI.getUpdater().getNamePermission())) return true;

            sender.sendMessage("Vérification des mises à jour...");

            try {
                // Connexion anonyme à l'API GitHub
                GitHub github = GitHub.connect(UpdaterAPI.getUpdater().getOwner(), UpdaterAPI.getUpdater().getAccessToken());
                GHRelease latestRelease = github.getRepository(UpdaterAPI.getUpdater().getOwner() + "/" + UpdaterAPI.getUpdater().getRepository()).getLatestRelease();

                // Extraire le numéro de version sans le "v" du début
                String latestVersion = latestRelease.getTagName().substring(1);

                // Comparer les versions pour vérifier s'il y a une nouvelle version disponible
                if (GithubAPI.getGithubAPI().isNewerVersion(latestVersion, UpdaterAPI.getUpdater().getCurrentVersion())) {
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