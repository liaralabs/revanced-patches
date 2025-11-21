package app.revanced.patches.gamehub.exporttofrontend

import app.revanced.patcher.patch.resourcePatch
import org.w3c.dom.Element

val manifestExportGameDetailActivity = resourcePatch {
    execute {
        // Export GameDetailActivity and add intent-filter
        val exportedFlag = "android:exported"
        val targetActivityName = "com.xj.landscape.launcher.ui.gamedetail.GameDetailActivity"

        document("AndroidManifest.xml").use { document ->
            val activities = document.getElementsByTagName("activity")

            for (i in 0 until activities.length) {
                val activityNode = activities.item(i) as? Element ?: continue

                // Only target the specific activity
                val nameAttr = activityNode.getAttribute("android:name")
                if (nameAttr != targetActivityName) continue

                // Set exported="true"
                val exportedAttr = activityNode.getAttributeNode(exportedFlag)
                if (exportedAttr != null) {
                    if (exportedAttr.nodeValue != "true") {
                        exportedAttr.nodeValue = "true"
                    }
                } else {
                    document.createAttribute(exportedFlag).apply { value = "true" }
                        .let(activityNode.attributes::setNamedItem)
                }

                // Add intent-filter
                val intentFilter = document.createElement("intent-filter")

                val action = document.createElement("action")
                action.setAttribute("android:name", "gamehub.lite.LAUNCH_GAME")
                intentFilter.appendChild(action)

                val category = document.createElement("category")
                category.setAttribute("android:name", "android.intent.category.DEFAULT")
                intentFilter.appendChild(category)

                activityNode.appendChild(intentFilter)
            }
        }
    }
}
