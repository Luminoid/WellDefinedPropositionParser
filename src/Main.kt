import EarleyParser.EarleyParser

/**
 * Created by Ethan on 16/5/4.
 */
fun main(args: Array<String>) {
    var sentence1 = arrayOf("(", "(", "\\not", "(", "(", "A", "_", "{", "1", "}", "\\and", "A", "_", "{", "1", "}", ")", "\\imply",
            "A", "_", "{", "1", "}", ")", ")", "\\or", "A", "_", "{", "1", "}", ")")
    var grammer = SimpleGrammar()
    var parser = EarleyParser(grammer)
    test(sentence1, parser)
}

fun test(sent: Array<String>, parser: EarleyParser) {
    var out = StringBuffer()
    for (i in 0..sent.size - 2)
        out.append(sent[i] + " ")
    out.append(sent[sent.size - 1])
    var sentence = out.toString()
    println("\nSenrtence: \"$sentence\"")
    var successful = parser.parseSentence(sent)
    println("Parse Successful: $successful")
    var charts = parser.charts
    println("Charts produced by the sentence \"$sentence\"")
    for (i in charts.indices) {
        println("Chart $i: ")
        charts[i].chart.forEach { println(it) }
        println()
    }
}