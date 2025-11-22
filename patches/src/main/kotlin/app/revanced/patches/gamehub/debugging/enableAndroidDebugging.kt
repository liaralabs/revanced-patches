package app.revanced.patches.gamehub.debugging

import app.revanced.patcher.patch.resourcePatch
import org.w3c.dom.Element

val enableAndroidDebuggingPatch = resourcePatch(
    name = "Enable debugging",
    description = "Enables Android debugging capabilities. This can slow down the app. Allows access to app data.",
    use = false,
) {
    compatibleWith("com.xiaoji.egggame")
    execute {
        document("AndroidManifest.xml").use { document ->
            val applicationNode =
                document
                    .getElementsByTagName("application")
                    .item(0) as Element

            // set application as debuggable
            applicationNode.setAttribute("android:debuggable", "true")
        }
    }
}