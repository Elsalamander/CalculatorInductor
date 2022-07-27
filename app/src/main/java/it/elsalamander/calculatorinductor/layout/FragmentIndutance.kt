package it.elsalamander.calculatorinductor.layout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentIndutance(val cont: Context) : Fragment() {
    val layout = MyFactoryView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return layout.createLayout(cont)
    }
}