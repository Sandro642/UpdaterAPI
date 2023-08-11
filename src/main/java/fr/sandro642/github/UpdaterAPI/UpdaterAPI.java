package fr.sandro642.github.UpdaterAPI;

import fr.sandro642.github.commands.UpdaterCmd;
import fr.sandro642.github.misc.GithubAPI;
import org.bukkit.plugin.Plugin;


/**
 * @Owner Sandro642
 * @Version 1.0
 * @Description Api Main Class
 * @Date 19/02/2021
 * @Name UpdaterAPI
 * @Package fr.sandro642.github.UpdaterAPI
 * @Class SkymCoreAPI
 * @Project UpdaterAPI
 * @License MIT License
 */

public class UpdaterAPI {

    /**
     * Différentes variables qui sont utiles ?
     * @Plugin plugin
     * @String owner
     * @String repository
     * @String currentVersion
     * @String accessToken
     * @String nameCommand
     * @String namePermission
     */

    private Plugin plugin;
    private String owner;
    private String repository;
    private String currentVersion;
    private String accessToken;
    private String nameCommand;
    private String namePermission;
    private String namePlugin;


    /**
     * Constructeur de la classe UpdaterAPI
     * @param plugin
     */

    public UpdaterAPI(Plugin plugin) {
        this.plugin = plugin;
        this.owner = "";
        this.repository = "";
        this.currentVersion = "";
        this.accessToken = "";
        this.nameCommand = "";
        this.namePermission = "";
        this.namePlugin = "";

        UpdaterCmd.setPlugin(plugin);
        GithubAPI.setPlugin(plugin);
    }


    /**
     * Initialisation de l'API
     * @param owner
     * @param repository
     * @param currentVersion
     * @param accessToken
     */

    private static UpdaterAPI updater;


    /**
     * Initialisation de l'API
     * @param owner
     * @param repository
     * @param currentVersion
     * @param accessToken
     */

    public void initAccessApi(String owner, String repository, String currentVersion, String accessToken, String namePlugin) {
        this.owner = owner;
        this.repository = repository;
        this.currentVersion = currentVersion;
        this.accessToken = accessToken;
        this.namePlugin = namePlugin;
    }


    /**
     * Initialisation de l'API
     * @param owner
     * @param repository
     * @param currentVersion
     */

    public void initAccessApi(String owner, String repository, String currentVersion, String namePlugin) {
        initAccessApi(owner, repository, currentVersion, null, namePlugin);
    }


    /**
     * Initialisation de l'API
     * @param nameCommand
     * @param namePermission
     */

    public void addCommand(String nameCommand, String namePermission) {
        this.nameCommand = nameCommand;
        this.namePermission = namePermission;

        plugin.getServer().getPluginCommand(nameCommand).setExecutor(new UpdaterCmd(plugin));
    }


    /**
     * Initialisation de l'API
     * @return updater
     */

    public static UpdaterAPI getUpdater() {
        return updater;
    }


    /**
     * Initialisation de l'API
     * @return owner
     */

    public String getOwner() {
        return owner;
    }


    /**
     * Initialisation de l'API
     * @return repository
     */

    public String getRepository() {
        return repository;
    }


    /**
     * Initialisation de l'API
     * @return currentVersion
     */

    public String getCurrentVersion() {
        return currentVersion;
    }


    /**
     * Initialisation de l'API
     * @return accessToken
     */

    public String getAccessToken() {
        return accessToken;
    }


    /**
     * Initialisation de l'API
     * @return nameCommand
     */

    public String getNameCommand() {
        return nameCommand;
    }


    /**
     * Initialisation de l'API
     * @return namePermission
     */

    public String getNamePermission() {
        return namePermission;
    }


    /**
     * Initialisation de l'API
     * @return namePlugin
     */

    public String getNamePlugin() {
        return namePlugin;
    }
}
