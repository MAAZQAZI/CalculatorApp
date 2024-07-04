package com.example.calculatorapp

sealed class CalculatorActions {
    object  Add : CalculatorActions()
    object  Subtract : CalculatorActions()
    object  Multiply : CalculatorActions()
    object  Divide : CalculatorActions()
    object  Clear : CalculatorActions()
    object  Equal : CalculatorActions()
    object  Decimal: CalculatorActions()


    object  Deletion: CalculatorActions()
    data class  Number(val number: Int) : CalculatorActions()
    data class  Operation(val operation: CalculatorOperation) : CalculatorActions()
}