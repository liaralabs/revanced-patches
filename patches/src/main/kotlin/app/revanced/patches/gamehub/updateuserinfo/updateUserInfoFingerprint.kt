package app.revanced.patches.gamehub.updateuserinfo

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val updateUserInfoFingerprint = fingerprint {
    returns("V")
    opcodes(
        Opcode.CONST_STRING,     // "uuid"
        Opcode.INVOKE_STATIC,
        Opcode.CONST_STRING,     // "mobile"
        Opcode.INVOKE_STATIC
    )
    strings(
        "uuid",
        "mobile"
    )
    custom { method, _ ->
        method.name == "updateUserInfo" && method.definingClass == "Lcom/xj/common/user/UserManager;"
    }
}
