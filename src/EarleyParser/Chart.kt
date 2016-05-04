package EarleyParser

import java.util.*

/**
 * Created by Ethan on 16/5/3.
 */
class Chart() {
    var chart = Vector<State>()
    fun addState(s: State) {
        if (!chart.contains(s))
            chart.add(s)
    }

    fun getState(i: Int) = if (i < 0 || i >= chart.size) null else chart[i]
}