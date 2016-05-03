import java.util.*

/**
 * Created by Ethan on 16/5/3.
 */
open class Grammer(var Rules: Map<String, Array<RHS>>, var POS: Vector<String>){
    fun getRHS(lhs: String) = if(Rules.containsKey(lhs)) Rules.get(lhs) else null

    fun isPartOfSpeech(s: String) = POS.contains(s)


}