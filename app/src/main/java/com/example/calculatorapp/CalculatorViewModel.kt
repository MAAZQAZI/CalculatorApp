package com.example.calculatorapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set





        fun onAction(action: CalculatorActions) {
            when (action) {
                is CalculatorActions.Number -> enterNumber(action.number)
                is CalculatorActions.Operation -> enterOperation(action.operation)
                is CalculatorActions.Clear -> clear()
                is CalculatorActions.Equal -> calculate()
                is CalculatorActions.Deletion -> Deletion()
                is CalculatorActions.Add -> enterOperation(CalculatorOperation.Add)
                is CalculatorActions.Subtract -> enterOperation(CalculatorOperation.Subtract)
                is CalculatorActions.Multiply -> enterOperation(CalculatorOperation.Multiply)
                is CalculatorActions.Divide -> enterOperation(CalculatorOperation.Divide)
                is CalculatorActions.Decimal -> enterDecimal()
            }
        }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            state = state.copy(number1 = state.number1 + number)
        } else {
            state = state.copy(number2 = state.number2 + number)

        }}

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
            //if operation is not null
            //add the in try catch block

        }
    }

    private  fun Deletion() {
        if (state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1.dropLast(1))
        } else if (state.operation != null) {
            state = state.copy(operation = null)
        } else if (state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2.dropLast(1))
        }
    }


    private fun clear() {
        state = CalculatorState()


    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()

        val number2= state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {

            val result=   when (state.operation) {
                CalculatorOperation.Add -> number1+number2
                CalculatorOperation.Subtract -> number1-number2
                CalculatorOperation.Multiply -> number1*number2
                CalculatorOperation.Divide -> number1/number2
                else -> null

            }
            state=state.copy(number1=result.toString().take(10) , number2="", operation=null)
        }



    }

    private fun enterDecimal() {
        if (state.operation == null) {
            if (!state.number1.contains(".")) {
                state = state.copy(number1 = state.number1 + ".")
            }
        } else {
            if (!state.number2.contains(".")) {
                state = state.copy(number2 = state.number2 + ".")
            }
        }

    }

    //add
    private fun add() {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            val result = state.number1.toDouble() + state.number2.toDouble()
            state = state.copy(number1 = result.toString(), number2 = "", operation = null)
        }

    }


    //subtract
    private fun subtract2() {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            val result = state.number1.toDouble() - state.number2.toDouble()
            state = state.copy(number1 = result.toString(), number2 = "", operation = null)
        }

    }
    private fun subtract1() {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            val result = state.number1.toDouble() - state.number2.toDouble()
            state = state.copy(number1 = result.toString(), number2 = "", operation = null)
        }

    }

    public fun subtract3() {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            val result = state.number1.toDouble() - state.number2.toDouble()
            state = state.copy(number1 = result.toString(), number2 = "", operation = null)
        }

    }

    //multiply
    private fun multiply() {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            val result = state.number1.toDouble() * state.number2.toDouble()
            state = state.copy(number1 = result.toString(), number2 = "", operation = null)
        }
    }

    //divide
    private fun divide() {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            val result = state.number1.toDouble() / state.number2.toDouble()
            state = state.copy(number1 = result.toString(), number2 = "", operation = null)
        }


    }
}