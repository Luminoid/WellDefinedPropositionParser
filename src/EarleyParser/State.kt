package EarleyParser

import java.util.*

/**
 * Created by Ethan on 16/5/3.
 */
class State(var lhs: String, var rhs: RHS, var i: Int, var j: Int, src: State?) {

    var srcs = Vector<State>()

    init {
        src?.let {
            srcs.add(src)
        }
    }

    fun getPriorToDot() = rhs.getPriorToDot()
    fun getAfterDot() = rhs.getAfterDot()
    fun isDotLast() = rhs.isDotLast()

    override fun equals(other: Any?): Boolean {
        other?.let {
            var s = other as State
            return (lhs == s.lhs && rhs == s.rhs && i == s.i && j == s.j)
        }
        return false
    }

    override fun toString() = "$lhs\t->$rhs\t[$i, $j]"
}