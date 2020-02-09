package byteextensions

import junit.framework.Assert.assertEquals
import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

class LibraryTest {

    @Test fun testSomeLibraryMethod() {
        val num = 20

        assertEquals("0x14", num.toByte().toHexString())
    }

    @Test fun testByteArrayToHexString() {
        val bytes = byteArrayOf(0x01, 0x20, 0x03)
        val hex = bytes.toHexString()

        assertEquals("0x01-0x20-0x03", hex)
    }

    @Test fun should_int_1000_return_0xe8_0x03() {
        val actualBytes = 1000.toBytes()
        val expectedBytes = byteArrayOf(0xe8.toByte(), 0x03.toByte(), 0x00, 0x00)

        assertArrayEquals(expectedBytes, actualBytes)
    }

    @Test fun should_bytes_of_1000_in_little_endian_return_1000_in_int() {
        val bytesOfOneThousand = byteArrayOf(0xe8.toByte(), 0x03, 0x00, 0x00)
        val actualValue = bytesOfOneThousand.toInt()
        val expectedValue = 1000

        assertEquals(expectedValue, actualValue)
    }

    @Test fun should_return_last_2_bytes() {
        val bytes = byteArrayOf(0x02, 0x03, 0x04, 0x05)
        val expectedBytes = byteArrayOf(0x04, 0x05)
        assertArrayEquals(expectedBytes, bytes.lastOf(2))
    }
}
