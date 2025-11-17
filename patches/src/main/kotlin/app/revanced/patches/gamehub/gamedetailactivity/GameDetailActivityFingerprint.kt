package app.revanced.patches.gamehub.gamedetailactivity

import com.revanced.patcher.fingerprint.Fingerprint
import com.revanced.patcher.fingerprint.MethodFingerprint
import com.revanced.patcher.fingerprint.match.Match
import com.revanced.patcher.fingerprint.method.impl.MethodFingerprintImpl
import com.revanced.patcher.data.Opcode

object GameDetailActivityFingerprint : Fingerprint(
    name = "GameDetailActivityFingerprintFingerprint",
    strings = listOf("type", ""),   // matches both const-string literals
    opcodeSequence = listOf(
        Opcode.CONST_STRING,        // v7, "type"
        Opcode.CONST_STRING,        // v8, ""
        Opcode.INVOKE_VIRTUAL       // BaseBundle->getString()
    )
)
