package app.revanced.patches.gamehub.fixemaillogin

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Suppress("unused")
val fixEmailLogin = bytecodePatch(
    name = "Fix email login",
    description = "Fixes null attribute errors during email logins in 5.3.x by bypassing non-null checks in login flow",
    use = false
) {
    compatibleWith("com.xiaoji.egggame")

    execute {
        //println("Matched method: ${updateUserInfoFingerprint.method.name} in ${updateUserInfoFingerprint.classDef.type}")
        updateUserInfoFingerprint.method.apply {
            val index = updateUserInfoFingerprint.patternMatch!!.endIndex
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
        //println("Matched method: ${setMobileFingerprint.method.name} in ${setMobileFingerprint.classDef.type}")
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