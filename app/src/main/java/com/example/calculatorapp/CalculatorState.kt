package com.example.calculatorapp

data class CalculatorState (
    val number1 : String = "",
    val number2 : String = "",
    val operation : CalculatorOperation? = null,


){
    val buttons = listOf(
        "AC" to CalculatorActions.Clear,
        "Del" to CalculatorActions.Clear,

        "1" to CalculatorActions.Number(1),
        "/" to CalculatorActions.Divide,
        "2" to CalculatorActions.Number(2),
        "3" to CalculatorActions.Number(3),
        "4" to CalculatorActions.Number(4),
        "x" to CalculatorActions.Multiply,
        "5" to CalculatorActions.Number(5),
        "6" to CalculatorActions.Number(6),
        "7" to CalculatorActions.Number(7),
        "+" to CalculatorActions.Add,
        "8" to CalculatorActions.Number(8),
        "9" to CalculatorActions.Number(9),
        "0" to CalculatorActions.Number(0),
        "-" to CalculatorActions.Subtract,
        "." to CalculatorActions.Decimal,
        "=" to CalculatorActions.Equal,
    )
}