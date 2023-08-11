package fr.sandro642.github.misc;

import fr.sandro642.github.UpdaterAPI.UpdaterAPI;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.net.URL;


/**
 * @Owner Sandro642
 * @Version 1.0
 * @Description Github API
 * @Date 19/02/2021
 * @Name GithubAPI
 * @Package fr.sandro642.github.misc
 * @Class GithubAPI
 * @Project UpdaterAPI
 * @License MIT License
 */

public class GithubAPI {


    /**
     * @GithubAPI githubAPI
     * @Plugin plugin
     */

    private static GithubAPI githubAPI;


    /**
     * Constructeur de la classe GithubAPI
     * @param plugin
     */

    private Plugin plugin;


    /**
     * @param plugin
     */

    private GithubAPI(Plugin plugin) {
        this.plugin = plugin;
    }


    /**
     * @param plugin
     */

    public static void setPlugin(Plugin plugin) {
        githubAPI = new GithubAPI(plugin);
    }


    /**
     * @param newVersion
     * @param currentVersion
     * @return
     */

    public boolean isNewerVersion(String newVersion, String currentVersion) {
        return newVersion.compareTo(currentVersion) > 0;
    }


    /**
     * @param downloadUrl
     * @throws IOException
     */

    public void downloadUpdate(String downloadUrl) throws IOException {
        File pluginFile = plugin.getDataFolder().getParentFile();
        File updateFile = new File(pluginFile, UpdaterAPI.getUpdater().getNamePlugin() + "-update.jar");

        try (InputStream in = new URL(downloadUrl).openStream();
             FileOutputStream out = new FileOutputStream(updateFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }


    /**
     * @return
     */

    public static GithubAPI getGithubAPI() {
        return githubAPI;
    }
}
