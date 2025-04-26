## IMPLEMENTATION DE PDF
1. Il faut ajouté :
   - La dépendance dans le **build.gradle** (Module) : `implementation(libs.android.pdf.viewer)`
   - La version utilisée dans le fichier *libs.versions.toml* section `[versions] : `githubAndroidPdfViewerVersion = "3.2.0-beta.1"`
   - La librairie dans la section `[libraries]`: `android-pdf-viewer = { module = "com.github.mhiew:android-pdf-viewer", version.ref = "githubAndroidPdfViewerVersion" }`
   - Dans le fichier `settings.gradle.kts`: ajoute `maven(url = "https://jitpack.io")` dans la section `repositories` de `dependencyResolutionManagement`
puis synchroniser le projet.