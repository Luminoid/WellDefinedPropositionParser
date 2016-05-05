package EarleyParser

/**
 * Created by Ethan on 16/5/3.
 */
public class RHS(var terms: Array<String>) {
    var hasDot = false
    var dot = -1  // the offset of the dot
    val DOT = "@"

    init {
        dot = terms.indexOf(DOT)
        hasDot = if (dot >= 0) true else false
    }

    fun getPriorToDot() = if (hasDot && dot > 0) terms[dot - 1] else ""

    fun getAfterDot() = if (hasDot && dot < terms.size - 1) terms[dot + 1] else ""

    fun isDotLast() = (dot == terms.size - 1)

    fun isDotFirst() = dot == 0

    fun addDot() = RHS(arrayOf(DOT).plus(terms))

    fun addDotLast() = RHS(terms.plus(DOT));

    fun moveDot():RHS{
        var newTerms = terms
        var i = newTerms.indexOf(DOT)
        newTerms[i] = terms[i+1]
        newTerms[i+1] = DOT
        return RHS(newTerms)
    }

    override fun equals(other: Any?): Boolean {
        other?.let {
            var rhs = other as RHS
            for(i in terms.indices){
                if (rhs.terms[i] != terms[i])
                    return false
            }
            return (dot == rhs.dot)
        }
        return false
    }

    override fun toString(): String {
        var str = ""
        for (t in terms)
            str += "$t "
        return str
    }
}