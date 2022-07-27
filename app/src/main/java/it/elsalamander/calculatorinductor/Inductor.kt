package it.elsalamander.calculatorinductor

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import it.elsalamander.calculatorinductor.layout.FragmentIndutance
import it.elsalamander.loaderclass.AbstractLoadClass
import it.elsalamander.loaderclass.Holder
import it.elsalamander.loaderclass.OnStartUpExtension
import it.elsalamander.loaderclass.calculator.execute.operator.Operator

class Inductor : AbstractLoadClass(MyOperation()), OnStartUpExtension {

    override fun getTitle(): String {
        return "Calculator Inductor"
    }

    override fun getDescription(): String {
        return "Specializzata per induttanze"
    }

    override fun getFragment(context: Context): Fragment {
        return FragmentIndutance(context)
    }

    override fun doOnStartUp(param: Holder, newLoad: Boolean) {
        class MyOperator : Operator("%", 3, 2){
            override fun execute(sx: Double?, dx: Double?): Double {
                Log.d("Operazione %", "$sx % $dx")
                return sx!! % dx!!
            }
        }

        MyOperator()
    }
}