package it.elsalamander.calculatorinductor

import it.elsalamander.loaderclass.calculator.Operation
import it.elsalamander.loaderclass.calculator.data.OperationDataHelper
import it.elsalamander.loaderclass.calculator.data.OperationDataParameters
import it.elsalamander.loaderclass.calculator.data.OperationDataResult
import it.elsalamander.loaderclass.calculator.data.builder.OperationDataResultBuilder
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

class MyOperation : Operation() {

    companion object{
        private val uo = 4*PI*10.0.pow(-7)
    }

    private val helpers = ArrayList<OperationDataHelper>()

    init{
        helpers.add(OperationDataHelper("Indutance From u,N,A,L", listOf("u","N","A","l","L")))
    }

    override fun calcola(param: OperationDataParameters): OperationDataResult {
        val u = param.getParameters()["u"]
        val N = param.getParameters()["N"]
        val A = param.getParameters()["A"]
        val l = param.getParameters()["l"]
        val L = param.getParameters()["L"]

        //crea il builder per il risultatto
        val buildRes = OperationDataResultBuilder(param)

        //cerca il calcolo da fare
        if(u != null && N != null && A != null && l != null && L == null){
            buildRes.addResult("L", uo*u*N*N*A/l)
        }
        if(u != null && N != null && A != null && l == null && L != null){
            buildRes.addResult("l", uo*u*N*N*A/L)
        }
        if(u != null && N != null && A == null && l != null && L != null){
            buildRes.addResult("A", L*l/(N*N*uo*u))
        }
        if(u != null && N == null && A != null && l != null && L != null){
            buildRes.addResult("N", sqrt(L*l/(u*uo*A)))
        }
        if(u == null && N != null && A != null && l != null && L != null){
            buildRes.addResult("u", L*l/(N*N*A*uo))
        }

        return buildRes.build()
    }

    override fun getHelperList(): List<OperationDataHelper> {
        return this.helpers
    }
}