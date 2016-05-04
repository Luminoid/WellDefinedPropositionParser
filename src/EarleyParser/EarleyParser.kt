package EarleyParser

/**
 * Created by Ethan on 16/5/3.
 */
class EarleyParser(var grammer: Grammer) {
    lateinit var sentence: Array<String>  // the sentence to be parsed
    lateinit var charts: Array<Chart>     // the evolving states of the chart

    fun parseSentence(s: Array<String>): Boolean {
        sentence = s
        charts = Array(sentence.size + 1, { i -> Chart() })
        var start1 = arrayOf("@", "S")
        var startRHS = RHS(start1)
        var start = State("$", startRHS, 0, 0)
        charts[0].addState(start)
        for (i in charts.indices)
            for (j in charts[i].chart.indices) {
                var st = charts[i].getState(j)
                st?.let {
                    var next_term = st.getAfterDot()
                    if (st.isDotLast())     // complete
                        completer(st)
                    else
                        if (grammer.isPartOfSpeech(next_term))
                            scanner(st)     // non-terminal
                        else
                            predictor(st)   // terminal
                }
            }

        var fin = arrayOf("S", "@")
        var finRHS = RHS(fin)
        var finish = State("$", finRHS, 0, sentence.size)
        var last = charts[sentence.size].getState(charts[sentence.size].chart.size - 1)
        return finish == last
    }

    private fun predictor(s: State) {
        var lhs = s.getAfterDot()
        var rhs = grammer.getRHS(lhs)
        var j = s.j
        rhs?.let {
            for (i in rhs.indices) {
                var ns = State(lhs, rhs[i].addDot(), j, j)
                charts[j].addState(ns)
            }
        }
    }

    private fun scanner(s: State) {
        var lhs = s.getAfterDot()
        var rhs = grammer.getRHS(lhs)
        var i = s.i
        var j = s.j

        rhs?.let {
            for (a in rhs.indices) {
                var terms = rhs[a].terms
                if (terms.size == 1 && j < sentence.size && terms[0] == sentence[j]) {
                    var ns = State(lhs, rhs[a].addDotLast(), j, j + 1)
                    charts[j + 1].addState(ns)
                }
            }
        }
    }

    private fun completer(s: State) {
        var lhs = s.lhs
        for (a in charts[s.i].chart.indices) {
            var st = charts[s.i].getState(a)
            st?.let {
                var after = st.getAfterDot()
                if (lhs == after) {
                    var ns = State(st.lhs, st.rhs.moveDot(), s.i, s.j)
                    charts[s.j].addState(ns)
                }
            }
        }
    }
}