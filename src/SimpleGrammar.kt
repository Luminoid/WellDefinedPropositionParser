import EarleyParser.Grammer
import EarleyParser.RHS

/**
 * Created by Ethan on 16/5/3.
 */
class SimpleGrammar : Grammer {
    constructor() : super() {
        initRules()
        initPos()
    }

    fun initRules() {
        val s1 = arrayOf<String>("NP", "VP")
        val sRHS = arrayOf<RHS>(RHS(s1))
        Rules.put("S", sRHS)
        val np1 = arrayOf<String>("NP", "PP")
        val np2 = arrayOf<String>("Noun")
        val npRHS = arrayOf<RHS>(RHS(np1), RHS(np2))
        Rules.put("NP", npRHS)
        val vp1 = arrayOf<String>("Verb", "NP")
        val vp2 = arrayOf<String>("VP", "PP")
        val vpRHS = arrayOf<RHS>(RHS(vp1), RHS(vp2))
        Rules.put("VP", vpRHS)
        val pp1 = arrayOf<String>("Prep", "NP")
        val ppRHS = arrayOf<RHS>(RHS(pp1))
        Rules.put("PP", ppRHS)
        val noun1 = arrayOf<String>("John")
        val noun2 = arrayOf<String>("Mary")
        val noun3 = arrayOf<String>("Denver")
        val nounRHS = arrayOf<RHS>(RHS(noun1), RHS(noun2), RHS(noun3))
        Rules.put("Noun", nounRHS)
        val verb = arrayOf<String>("called")
        val verbRHS = arrayOf<RHS>(RHS(verb))
        Rules.put("Verb", verbRHS)
        val prep = arrayOf<String>("from")
        val prepRHS = arrayOf<RHS>(RHS(prep))
        Rules.put("Prep", prepRHS)
    }

    fun initPos() {
        POS.add("Noun");
        POS.add("Verb");
        POS.add("Prep");
    }
}