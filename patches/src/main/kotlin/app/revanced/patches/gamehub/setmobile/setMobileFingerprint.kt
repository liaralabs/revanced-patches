package app.revanced.patches.gamehub.setmobile

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

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
