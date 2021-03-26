# KotlinCheatSheet

Frequently used functions for reading data from console

    fun readln(): String = readLine()!!
    fun readlnInt(): Int = readln().toInt()
    
    fun readlnStrings(): List<String> = readln().split(' ')
    fun readlnInts(): List<Int> = readln().split(' ').map { it.toInt() }
    
    fun readIntArray(): IntArray = readln().split(' ').run { IntArray(size) { get(it).toInt() } }
    fun readArray(): Array<Int> = readLine()!!.split(' ').map { it.toInt() }.toTypedArray()
    fun readlnIntArray(n: Int): IntArray = IntArray(n) { readln().toInt() }
    
    fun readIntArray2d(rows: Int, cols: Int): Array<IntArray> = Array(rows) {
        readln().split(' ').run { IntArray(size) { get(it).toInt() } }
            .also { require(it.size == cols) }
    }

    fun readArray2d(rows: Int, cols: Int, default: Int = 0): Array<Array<Int>> {
        val arrayOfArray = Array(rows) { Array(cols) { default } }
        for (i in 0 until (rows)) {
            arrayOfArray[i] = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
                .also { require(it.size == cols) }
        }
        return arrayOfArray
    }
    
Add-ons

    fun readlnByte() = readln().toByte()
    fun readlnShort() = readln().toShort()
    fun readlnLong() = readln().toLong()
    fun readlnFloat() = readln().toFloat()
    fun readlnDouble() = readln().toDouble()
    fun readlnBigInt(radix: Int = 10) = readln().toBigInteger(radix)
    fun readlnBigDecimal() = readln().toBigDecimal()

    fun lineSequence(limit: Int = Int.MAX_VALUE) =
        generateSequence { readLine() }.constrainOnce().take(limit)

    fun readlnBytes() = readlnStrings().map { it.toByte() }
    fun readlnShorts() = readlnStrings().map { it.toShort() }
    fun readlnLongs() = readlnStrings().map { it.toLong() }
    fun readlnFloats() = readlnStrings().map { it.toFloat() }
    fun readlnDoubles() = readlnStrings().map { it.toDouble() }

    fun readByteArray() = readlnStrings().run { ByteArray(size) { get(it).toByte() } }
    fun readShortArray() = readlnStrings().run { ShortArray(size) { get(it).toShort() } }
    fun readLongArray() = readlnStrings().run { LongArray(size) { get(it).toLong() } }
    fun readFloatArray() = readlnStrings().run { FloatArray(size) { get(it).toFloat() } }
    fun readDoubleArray() = readlnStrings().run { DoubleArray(size) { get(it).toDouble() } }


    fun readlnByteArray(n: Int) = ByteArray(n) { readlnByte() }
    fun readlnShortArray(n: Int) = ShortArray(n) { readlnShort() }
    fun readlnLongArray(n: Int) = LongArray(n) { readlnLong() }
    fun readlnFloatArray(n: Int) = FloatArray(n) { readlnFloat() }
    fun readlnDoubleArray(n: Int) = DoubleArray(n) { readlnDouble() }

    fun readByteArray2d(rows: Int, cols: Int) =
        Array(rows) { readByteArray().also { require(it.size == cols) } }

    fun readShortArray2d(rows: Int, cols: Int) =
        Array(rows) { readShortArray().also { require(it.size == cols) } }

    fun readLongArray2d(rows: Int, cols: Int) =
        Array(rows) { readLongArray().also { require(it.size == cols) } }

    fun readFloatArray2d(rows: Int, cols: Int) =
        Array(rows) { readFloatArray().also { require(it.size == cols) } }

    fun readDoubleArray2d(rows: Int, cols: Int) =
        Array(rows) { readDoubleArray().also { require(it.size == cols) } }

    fun isWhiteSpace(c: Char) = c in " \r\n\t"

JVM-only targeting functions

    // readString() via sequence is slightly faster than Scanner
    fun readString() = generateSequence { System.`in`.read().toChar() }.dropWhile { isWhiteSpace(it) }
                       .takeWhile { !isWhiteSpace(it) }.joinToString("")

    fun readByte() = readString().toByte()
    fun readShort() = readString().toShort()
    fun readInt() = readString().toInt()
    fun readLong() = readString().toLong()
    fun readFloat() = readString().toFloat()
    fun readDouble() = readString().toDouble()
    fun readBigInt(radix: Int = 10) = readString().toBigInteger(radix)
    fun readBigDecimal() = readString().toBigDecimal()

    fun readBytes(n: Int) = generateSequence { readByte() }.take(n)
    fun readShorts(n: Int) = generateSequence { readShort() }.take(n)
    fun readInts(n: Int) = generateSequence { readInt() }.take(n)
    fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
    fun readFloats(n: Int) = generateSequence { readFloat() }.take(n)
    fun readDoubles(n: Int) = generateSequence { readDouble() }.take(n)
