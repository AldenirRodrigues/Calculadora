package com.example.calculadora.calculator

import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresenter {
    //Current attached view
    private var mView: CalculatorOutputInterfaceView? = null

    //Current equation
    private var mCurrentEquation: String = ""

    //Current outcome
    private var mCurrentOutcome: String = ""

    private val mInterpreter = Interpreter()

    fun attach(view: CalculatorOutputInterfaceView) {
        mView = view
        updateEquation()
        updateOutcome()
    }

    fun detach() {
        mView = null
    }

    fun add(item: String) {
        mCurrentEquation = mCurrentEquation.plus(item)
        updateEquation()
        calculatorOutcome()
        updateOutcome()

    }

    fun remove() {
        mCurrentEquation = if (mCurrentEquation.length > 1) {
            mCurrentEquation.substring(0, mCurrentEquation.length - 1)
        } else {
            ""
        }
        updateEquation()
        calculatorOutcome()
        updateOutcome()
    }

    fun solve() {
        when {
            mCurrentOutcome.isNotEmpty() -> {
                mCurrentEquation = mCurrentOutcome
                mCurrentOutcome = ""
            }
        }
        updateEquation()
        updateOutcome()
    }

    fun clear() {
        mCurrentEquation = ""
        mCurrentOutcome = ""
        updateEquation()
        updateOutcome()
    }

   fun calculatorOutcome() {
        if (!mCurrentEquation.isNullOrEmpty()) {
            try {
                mInterpreter.eval("result = $mCurrentEquation")
                val result = mInterpreter.get("result")
                if (result != null && result is Int) {
                    mCurrentOutcome = result.toString()
                }
            } catch (e: Exception) {
                mCurrentOutcome = ""
            }
        } else {
            mCurrentOutcome = ""
        }
    }

   private fun updateEquation() {
        mView?.setEquation(mCurrentEquation)
    }

  private  fun updateOutcome() {
        mView?.setOutcome(mCurrentOutcome)
    }

}