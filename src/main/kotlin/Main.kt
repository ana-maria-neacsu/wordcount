fun main() {
    val latinWordCounter = LatinWordCounter()

    print("Enter text: ")
    val inputText = readLine()

    val wordsCount = latinWordCounter.count(inputText!!)

    println("Number of words: $wordsCount")
}