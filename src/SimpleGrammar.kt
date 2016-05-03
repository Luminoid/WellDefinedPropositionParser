import java.util.*

/**
 * Created by Ethan on 16/5/3.
 */
class SimpleGrammer: Grammer{
    constructor(Rules: Map<String, Array<RHS>>, POS: Vector<String>): super(Rules, POS){
        initRules()
        initPos()
    }

    fun initRules(){
    }

    fun initPos(){
        POS.add("S");
    }
}