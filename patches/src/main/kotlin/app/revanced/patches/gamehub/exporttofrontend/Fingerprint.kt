package app.revanced.patches.gamehub.exporttofrontend

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val GameDetailActivityFingerprint = fingerprint {
    returns("V")
    opcodes(
        Opcode.CONST_STRING,     // "id"
        Opcode.CONST_STRING,     // "0"
        Opcode.INVOKE_VIRTUAL,   // getString(String, String)
        Opcode.MOVE_RESULT_OBJECT, // move-result-object v10

        Opcode.CONST_STRING,     // "type"
        Opcode.CONST_STRING,     // ""
        Opcode.INVOKE_VIRTUAL,   // getString(String, String)
        Opcode.MOVE_RESULT_OBJECT  // move-result-object v7
    )
    custom { method, _ ->
        method.name == "initView" && method.definingClass == "Lcom/xj/landscape/launcher/ui/gamedetail/GameDetailActivity;"
    }
}
