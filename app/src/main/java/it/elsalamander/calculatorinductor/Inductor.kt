package it.elsalamander.calculatorinductor

import android.content.Context
import androidx.fragment.app.Fragment
import it.elsalamander.calculatorinductor.layout.FragmentIndutance
import it.elsalamander.loaderclass.AbstractLoadClass

class Inductor : AbstractLoadClass(MyOperation()) {

    override fun getTitle(): String {
        return "Calculator Inductor"
    }

    override fun getDescription(): String {
        return "Specializzata per induttanze"
    }

    override fun getFragment(context: Context): Fragment {
        return FragmentIndutance(context)
    }
}