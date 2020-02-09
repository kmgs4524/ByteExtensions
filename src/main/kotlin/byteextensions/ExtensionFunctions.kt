package byteextensions

import java.lang.Math.pow
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.experimental.and
import kotlin.math.pow

private val HEX_CHARS = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

fun Byte.toHexString(): String {
    val mostSignificantFourBitsNum = this.toInt() shr 4 and 0xf
    val leastSignificantFourBitsNum = this.toInt() and 0xf
    val mostSignificantDigit = HEX_CHARS[mostSignificantFourBitsNum]
    val leastSignificantDigit = HEX_CHARS[leastSignificantFourBitsNum]
    return "0x$mostSignificantDigit$leastSignificantDigit"
}

fun ByteArray.toHexString(): String {
    val builder = StringBuilder()
    this.forEachIndexed { index, byte ->
        builder.append(byte.toHexString())
        if (index != this.lastIndex) builder.append('-')
    }
    return builder.toString()
}

fun Int.toBytes(byteOrder: ByteOrder = ByteOrder.LITTLE_ENDIAN): ByteArray {
    return ByteBuffer.allocate(4)
            .order(byteOrder)
            .putInt(this)
            .array()
}

fun ByteArray.toInt(): Int {
    var intValue: Int = 0
    intValue = intValue or this[0].toInt() and 0xff
    intValue = intValue or (this[1].toInt() and 0xff shl 8)
    intValue = intValue or (this[2].toInt() and 0xff shl 16)
    intValue = intValue or (this[3].toInt() and 0xff shl 24)
    return intValue
}

fun ByteArray.lastOf(byteCount: Int): ByteArray {
    val byteBuffer = ByteBuffer.allocate(byteCount)
    for (i in byteCount downTo 1) {
        byteBuffer.put(this[size - i])
    }
    return byteBuffer.array()
}
