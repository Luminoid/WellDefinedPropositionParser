import EarleyParser.EarleyParser

/**
 * Created by Ethan on 16/5/4.
 */
fun main(args: Array<String>) {
    var sentence1 = arrayOf("John", "called", "Mary")
    var sentence2 = arrayOf("John", "called", "Mary", "from", "Denver")
    var grammer = SimpleGrammar()
    var parser = EarleyParser(grammer)
    test(sentence1, parser)
    test(sentence2, parser)
}

fun test(sent: Array<String>, parser: EarleyParser){
    var out = StringBuffer()
    for(i in sent.indices)
        out.append(sent[i] + " ")
//    out.append(sent[sent.size-1]+".")
    var sentence = out.toString()
    println("\nSenrtence: \"$sentence\"")
    var successful = parser.parseSentence(sent)
    println("Parse Successful: $successful")
    var charts = parser.charts
    println("Charts produced by the sentence \"$sentence\"")
    for(i in charts.indices){
        println("EarleyParser.Chart $i: ")
        charts[i].chart.forEach { print(it) }
    }
}