package it.elsalamander.calculatorinductor.layout.listener

import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import it.elsalamander.calculatorinductor.MyOperation
import it.elsalamander.calculatorinductor.layout.MyFactoryView

class InductorCalculatorListener(val myOperation: MyOperation, val myLayout : MyFactoryView) : View.OnKeyListener{

    /**
     * Called when a hardware key is dispatched to a view. This allows listeners to
     * get a chance to respond before the target view.
     *
     * Key presses in software keyboards will generally NOT trigger this method,
     * although some may elect to do so in some situations. Do not assume a
     * software input method has to be key-based; even if it is, it may use key presses
     * in a different way than you expect, so there is no way to reliably catch soft
     * input key presses.
     *
     * @param v The view the key has been dispatched to.
     * @param keyCode The code for the physical key that was pressed
     * @param event The KeyEvent object containing full information about
     * the event.
     * @return True if the listener has consumed the event, false otherwise.
     */
    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if((event!!.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

            val u = myLayout.value[MyFactoryView.NAME_PERMEABILITY]!!
            val N = myLayout.value[MyFactoryView.NAME_TURNS]!!
            val A = myLayout.value[MyFactoryView.NAME_AREA]!!
            val l = myLayout.value[MyFactoryView.NAME_LENGHT]!!
            val L = myLayout.value[MyFactoryView.NAME_INDUCTOR]!!

            var setOn : EditText? = null
            var check : Boolean = true
            var key : String? = null

            val dataBuilder = myOperation.getHelperFor(listOf("u","N","A","l","L"))!!.createOperationDataParametersBuilder()
            if(u.text != null && u.text.toString() != ""){
                dataBuilder.putValue("u", u.text.toString().toDouble())
            }else{
                setOn = u
                key = "u"
            }

            if(N.text != null && N.text.toString() != ""){
                dataBuilder.putValue("N", N.text.toString().toDouble())
            }else{
                if(setOn != null){
                    return true
                }
                check = true
                setOn = N
                key = "N"
            }

            if(A.text != null && A.text.toString() != ""){
                dataBuilder.putValue("A", A.text.toString().toDouble())
            }else{
                if(setOn != null){
                    return true
                }
                check = true
                setOn = A
                key = "A"
            }

            if(l.text != null && l.text.toString() != ""){
                dataBuilder.putValue("l", l.text.toString().toDouble())
            }else{
                if(setOn != null){
                    return true
                }
                check = true
                setOn = l
                key = "l"
            }

            if(L.text != null && L.text.toString() != ""){
                dataBuilder.putValue("L", L.text.toString().toDouble())
            }else{
                if(setOn != null){
                    return true
                }
                check = true
                setOn = L
                key = "L"
            }

            val res = myOperation.calcola(dataBuilder.build())

            if(check){
                setOn?.setText(res.result[key]?.first().toString())
            }

            return true
        }
        return false
    }

}