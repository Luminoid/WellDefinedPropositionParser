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
        val bs = arrayOf("LP", "S", "BS", "S", "RP")
        val us = arrayOf("LP", "US", "S", "RP")
        val l = arrayOf("L")
        val sRHS = arrayOf(RHS(bs), RHS(us), RHS(l))
        Rules.put("S", sRHS)

        addSimpleRules("LP", arrayOf("("))
        addSimpleRules("RP", arrayOf(")"))
        addSimpleRules("L", arrayOf("Char", "USC", "LB", "N", "RB"))
        addSimpleRules("USC", arrayOf("_"))
        addSimpleRules("LB", arrayOf("{"))
        addSimpleRules("RB", arrayOf("}"))

        val binarySymbol1 = arrayOf("\\and")
        val binarySymbol2 = arrayOf("\\or")
        val binarySymbol3 = arrayOf("\\imply")
        val binarySymbol4 = arrayOf("\\eq")
        val binarySymbolRHS = arrayOf(RHS(binarySymbol1), RHS(binarySymbol2), RHS(binarySymbol3), RHS(binarySymbol4))
        Rules.put("BS", binarySymbolRHS)

        val unarySymbol1 = arrayOf("\\not")
        val unarySymbolRHS = arrayOf(RHS(unarySymbol1))
        Rules.put("US", unarySymbolRHS)

        val character1 = arrayOf("A")
        val character2 = arrayOf("B")
        val character3 = arrayOf("C")
        val character4 = arrayOf("D")
        val character5 = arrayOf("E")
        val character6 = arrayOf("F")
        val character7 = arrayOf("G")
        val character8 = arrayOf("H")
        val character9 = arrayOf("I")
        val character10 = arrayOf("J")
        val character11 = arrayOf("K")
        val character12 = arrayOf("L")
        val character13 = arrayOf("M")
        val character14 = arrayOf("N")
        val character15 = arrayOf("O")
        val character16 = arrayOf("P")
        val character17 = arrayOf("Q")
        val character18 = arrayOf("R")
        val character19 = arrayOf("S")
        val character20 = arrayOf("T")
        val character21 = arrayOf("U")
        val character22 = arrayOf("V")
        val character23 = arrayOf("W")
        val character24 = arrayOf("X")
        val character25 = arrayOf("Y")
        val character26 = arrayOf("Z")
        val characterRHS = arrayOf(RHS(character1), RHS(character2), RHS(character3), RHS(character4), RHS(character5),
                RHS(character6), RHS(character7), RHS(character8), RHS(character9), RHS(character10), RHS(character11),
                RHS(character12), RHS(character13), RHS(character14), RHS(character15), RHS(character16), RHS(character17),
                RHS(character18), RHS(character19), RHS(character20), RHS(character21), RHS(character22), RHS(character23),
                RHS(character24), RHS(character25), RHS(character26))
        Rules.put("Char", characterRHS)

        var n = arrayOf("N")
        var number1 = arrayOf("1")
        var number2 = arrayOf("2")
        var number3 = arrayOf("3")
        var number4 = arrayOf("4")
        var number5 = arrayOf("5")
        var number6 = arrayOf("6")
        var number7 = arrayOf("7")
        var number8 = arrayOf("8")
        var number9 = arrayOf("9")
        var number0 = arrayOf("0")
        var numberRHS = arrayOf(RHS(n), RHS(number1), RHS(number2), RHS(number3), RHS(number4), RHS(number5), RHS(number6),
                RHS(number7), RHS(number8), RHS(number9), RHS(number0))
        Rules.put("N", numberRHS)
    }

    fun initPos() {
        POS.add("BS");
        POS.add("US");
        POS.add("LP");
        POS.add("RP");
        POS.add("USC");
        POS.add("LB");
        POS.add("RB");
        POS.add("N")
        POS.add("Char");

    }

    fun addSimpleRules(lhs: String, rhs: Array<String>) {
        var arrRHS = arrayOf(RHS(rhs))
        Rules.put(lhs, arrRHS)
    }
}