package fr.sandro642.github.UpdaterAPI;

import fr.sandro642.github.commands.UpdaterCmd;
import fr.sandro642.github.misc.GithubAPI;
import org.bukkit.plugin.Plugin;


/**
 * @Owner Sandro642
 * @Repository UpdaterApi
 * @CurrentVersion 1.0
 * @Description This class is used to update your application.
 * @License MIT
 */

public class UpdaterAPI {

    /**
     * Addition de Spigot Plugin
     * Création de l'instance plugin
     * Création du constructeur Updater pour l'instance plugin
     */

    private Plugin plugin;

    public UpdaterAPI(Plugin plugin) {
        this.plugin = plugin;
        UpdaterCmd.setPlugin(plugin);
        GithubAPI.setPlugin(plugin);
    }

    /**
     * Création de l'instance de la classe Updater
     */

    private static UpdaterAPI updater;


    /**
     * Création des variables de la classe.
     */

    public String owner;
    public String repository;
    public String currentVersion;
    public String accessToken;
    public String nameCommand;
    public String namePermission;


    /**
     * Création de la méthode pour initialiser les variables.
     * @Owner owner, besoin du nom du créateur du repository.
     * @Repo repository, besoin du nom du repository.
     * @Version  currentVersion, besoin de la version actuelle de l'application.
     * @Token accessToken, besoin du token d'accès à l'API Github.
     */

    public void initAccessApi(String owner, String repository, String currentVersion, String accessToken) {
        this.owner = owner;
        this.repository = repository;
        this.currentVersion = currentVersion;
        this.accessToken = accessToken;
    }

    public void initAccessApi(String owner, String repository, String currentVersion) {
        this.owner = owner;
        this.repository = repository;
        this.currentVersion = currentVersion;
    }

    /**
     * Création d'une méthode pour ajouter une commande native au jeu.
     */

    public void addCommand(String nameCommand, String namePermission) {
        // TODO ajouter la commande native au jeu.

        // Initialisation des variables.
        this.nameCommand = nameCommand;
        this.namePermission = namePermission;


        plugin.getServer().getPluginCommand(nameCommand).setExecutor(new UpdaterCmd());
    }


    /**
     * Création d'un getter pour la classe.
     */
    public static UpdaterAPI getUpdater() {
        return updater;
    }

}
