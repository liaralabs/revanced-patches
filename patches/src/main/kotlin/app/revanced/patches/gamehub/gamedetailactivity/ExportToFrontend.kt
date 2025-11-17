package app.revanced.patches.gamehub.gamedetailactivity

import com.revanced.patcher.patch.Patch
import com.revanced.patcher.patch.BytecodePatch
import com.revanced.patcher.patch.PatchException
import com.revanced.patcher.data.BytecodeContext
import com.revanced.patcher.util.smali.buildConstString

@Patch(
    name = "GameDetailActivity Fix",
    description = "Patches GameDetailActivity issues for front-end export",
    compatiblePackages = ["com.xiaoji.egggame"]
)
object ModifyGetStringTypePatch : BytecodePatch(
    fingerprints = setOf(GameDetailActivityFingerprint)
) {
    override fun execute(context: BytecodeContext) {
        val match = GameDetailActivityFingerprint.result
            ?: throw PatchException("Fingerprint not found")

        val method = match.method
        val impl = method.implementation
            ?: throw PatchException("Method has no implementation")

        val insns = impl.instructions
        val startIndex = match.scanResult.startIndex

        // Instruction order in your smali:
        //  startIndex + 0 → const-string vX, "type"
        //  startIndex + 1 → const-string vY, ""
        //  startIndex + 2 → invoke-virtual

        val oldConst = insns[startIndex + 1]

        // Replace empty string "" with "1" (or anything you want)
        val newConst = buildConstString(
            register = oldConst.registerA,
            string = "0"
        )

        insns[startIndex + 1] = newConst
    }
}
