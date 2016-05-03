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

    fun moveDot() = terms.dropWhile { it -> it == DOT }
}