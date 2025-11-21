package app.revanced.patches.gamehub.exporttofrontend

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Suppress("unused")
val frontEndExportPatch = bytecodePatch(
    name = "Front-end Export",
    description = "Sets exported=true and adds intent-filter for GameDetailActivity, patches gameDetailActivity to avoid NumberFormatException",
    use = true,
) {
    execute {
        dependsOn(manifestExportGameDetailActivity)
        // patch gameDetailActivity to avoid NumberFormatException
        //println("Matched method: ${GameDetailActivityFingerprint.method.name} in ${GameDetailActivityFingerprint.classDef.type}")
        GameDetailActivityFingerprint.method.apply {
            val index = GameDetailActivityFingerprint.patternMatch!!.startIndex + 5
            val register = getInstruction<OneRegisterInstruction>(index).registerA
            //println("${index}, ${register}")
            replaceInstruction(
                index, 
                """
                    const-string v$register, "0"
                """
            )
        }
    }
}
