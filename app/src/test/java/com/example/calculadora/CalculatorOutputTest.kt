package com.example.calculadora

import com.example.calculadora.calculator.CalculatorOutputInterfaceView
import com.example.calculadora.calculator.CalculatorOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class CalculatorOutputTest {
    private val mPresenter = CalculatorOutputPresenter
    private val  mMockView = Mockito.mock(CalculatorOutputInterfaceView::class.java)

    @Test
    fun `1 plus 1 is 2`(){

        //Given that the view is attached
        mPresenter.attach(mMockView)

        //when a number is added
        mPresenter.add("1")

        //Then the correct equation should be set
        then(mMockView).should().setEquation("1")

        //when an operator is added
        mPresenter.add("+")

        //Then th correct equation should be set
        then(mMockView).should().setEquation("1+")

        //When a number is added
        mPresenter.add("1")

        //Then the correct equation should be set
        then(mMockView).should().setEquation("1+1")

        //Then the correct outcome should be set
        then(mMockView).should().setOutcome("2")

        //Clear presenter
        mPresenter.clear()
    }

    @Test
    fun `2 plus 2 minus 3 is 1`(){

        //Given that the view is attached
        mPresenter.attach(mMockView)

        //when a number is added
        mPresenter.add("2")

        //Then the correct equation should be set
        then(mMockView).should().setEquation("2")

        //when an operator is added
        mPresenter.add("+")

        //Then th correct equation should be set
        then(mMockView).should().setEquation("2+")

        //When a number is added
        mPresenter.add("2")

        //Then the correct equation should be set
        then(mMockView).should().setEquation("2+2")

        //Then the correct outcome should be set
        then(mMockView).should().setOutcome("4")

        //when an operator is added
        mPresenter.add("-")

        //Then th correct equation should be set
        then(mMockView).should().setEquation("2+2-")

        //When a number is added
        mPresenter.add("3")

        //Then the correct equation should be set
        then(mMockView).should().setEquation("2+2-3")

        //Then the correct outcome should be set
        then(mMockView).should().setOutcome("1")

        //Clear presenter
        mPresenter.clear()

    }


}