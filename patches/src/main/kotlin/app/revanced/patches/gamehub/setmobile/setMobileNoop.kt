package app.revanced.patches.gamehub.setmobile

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Suppress("unused")
val nonNullMobileInfo = bytecodePatch(
    name = "Bypass non-nullable checks in setMobile",
) {
    compatibleWith("com.xiaoji.egggame")

    execute {
        println("Matched method: ${setMobileFingerprint.method.name} in ${setMobileFingerprint.classDef.type}")
        setMobileFingerprint.method.apply {
            val index = setMobileFingerprint.patternMatch!!.endIndex
            //val register = getInstruction<OneRegisterInstruction>(index).registerA
            //println("${index}, ${register}")
            replaceInstruction(
                index, 
                """
                    nop
                    nop
                """
            )
        }
    }
}