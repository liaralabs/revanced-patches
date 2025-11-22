package app.revanced.patches.gamehub.fixemaillogin

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

internal val setMobileFingerprint = fingerprint {
    returns("V")
    opcodes(
        Opcode.CONST_STRING,     // "value"
        Opcode.INVOKE_STATIC
    )
    custom { method, _ ->
        method.name == "setMobile" && method.definingClass == "Lcom/xj/common/user/UserManager;"
    }
}