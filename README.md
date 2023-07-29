## :hammer_and_wrench: UpdaterAPI

L'API :package: **UpdaterAPI** :pick: a été conçue pour simplifier la mise à jour :arrows_counterclockwise: de votre projet Minecraft. Vous pouvez désormais mettre à jour facilement votre JAR Minecraft en utilisant une commande simple.

### :gear: Fonctionnalités principales

1. **Mise à jour automatique** : Une simple commande et l'API recherche automatiquement et télécharge la dernière version du JAR disponible dans notre référentiel centralisé.

2. **Importation automatique** : La dernière version du JAR est importée directement dans votre projet Minecraft.

3. **Personnalisation des paramètres** : Vous pouvez personnaliser la mise à jour en fournissant les informations suivantes lors de l'initialisation de la méthode :

   - *Owner du référentiel* :nom_badge: : Indiquez le nom du propriétaire du référentiel où se trouve le JAR souhaité.
   - *Nom du référentiel* :file_folder: : Spécifiez le nom du référentiel contenant la dernière version du JAR.
   - *Version actuelle* :1234: : Fournissez la version actuelle de votre JAR dans votre projet.
   - *Token d'accès* :closed_lock_with_key: : Si vous utilisez un référentiel privé, vous pouvez générer un jeton d'accès et l'associer à votre compte ou au référentiel pour permettre la mise à jour.
   - *Nom de la commande* :computer: : Vous pouvez personnaliser le nom de la commande utilisée pour déclencher la mise à jour.
   - *Permission d'accès* :lock_with_ink_pen: : Pour contrôler l'accès à la commande de mise à jour, vous pouvez définir des permissions.

### :rocket: Exemple d'utilisation

Pour mettre à jour votre JAR Minecraft, utilisez la commande suivante :

```bash
/api/updatejar
--owner=monProprio
--repo=monRepo
--currentVersion=1.0.0
--token=monTokenSecret
--commandName=updatejar
--permission=updatejar.access
```

Une fois cette commande exécutée, l'API effectuera les étapes suivantes :

    Recherche du JAR le plus récent dans le référentiel "monRepo" appartenant à "monProprio".

    Comparaison de la version actuelle de votre projet (1.0.0) avec la dernière version disponible.

    Téléchargement et importation automatiques du JAR mis à jour si une version plus récente est trouvée.

    Affichage d'un message confirmant la mise à jour réussie.

Maintenant, vous êtes prêt à profiter de la simplicité de notre API MinecraftJarUpdater pour garder votre projet Minecraft toujours à jour avec le dernier JAR disponible dans notre référentiel centralisé. Amusez-vous bien ! :video_game: :tada:

# Maven
```
 <repositories>
    <repository>
        <id>Sandro642</id>
        <url>https://sandro642.github.io/gradle</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>fr.Sandro642</groupId>
        <artifactId>updaterapi</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

# Gradle
```
repositories {
    maven {
        url 'https://sandro642.github.io/gradle'
    }
}

dependencies {
    implementation 'fr.sandro642:updaterapi:1.0.0'
}
```
