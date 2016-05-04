package EarleyParser

/**
 * Created by Ethan on 16/5/3.
 */
class State(var lhs: String, var rhs: RHS, var i: Int, var j: Int) {
    fun getPriorToDot() = rhs.getPriorToDot()
    fun getAfterDot() = rhs.getAfterDot()
    fun isDotLast() = rhs.isDotLast()
}