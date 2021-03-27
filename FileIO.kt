val file = File("test.txt")
// create file
if (!file.exists()) {
    file.createNewFile()
}

//write to file
file.writeText("Prachi") // Overwrite writing string, default "UTF-8"
file.appendText("Naik") // Append to write string, default "UTF-8"
file.appendBytes(ByteArray(2).apply {
    set(0, '1'.toByte())
    set(1, '2'.toByte())
})

//write to file using buffer write object
val writeBuffer = file.bufferedWriter(Charset.defaultCharset(), 10)
writeBuffer.write("wjx")
writeBuffer.flush()
writeBuffer.append(" say")
writeBuffer.newLine()
writeBuffer.close()

//read from file
val wholeContent = file.readText(Charset.forName("UTF-8")) // Get the entire file content in UTF-8 encoding format
val charList = file.readLines(Charset.forName("UTF-8")) // returns a list of strings holding each line of the file in UTF-8 encoding format
val fileBytes: ByteArray = file.readBytes() // returns the character array of the file
file.forEachLine { println(it) } //read file line by line

//read from file using buffer read object
val readBuffer = file.bufferedReader(Charset.defaultCharset(), 10)
println(readBuffer.readText())
