package com.example.calculatorapp

sealed class CalculatorOperation (val symbol: String) {
    object  Add : CalculatorOperation("+")
    object  Subtract : CalculatorOperation("-")
    object  Multiply : CalculatorOperation("x")
    object  Divide : CalculatorOperation("/")
    object  Clear : CalculatorOperation("C")
    object  Equal : CalculatorOperation("=")
}