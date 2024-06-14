package com.example.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    btn_spacing: Dp = 8.dp,
    onAction:(CalculatorActions)->Unit

) {
    val Orange= Color(0xFFFF9800)

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
               .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.spacedBy(btn_spacing)


        ) {

            Text(text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                fontWeight = FontWeight.Light,
                fontSize = 24.sp,
                color = Color.White,
                maxLines = 2,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp),
                onTextLayout = {})



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btn_spacing)
            ) {
                CalculatorBtn(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }

                )
                CalculatorBtn(
                    symbol = "Del",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )

                CalculatorBtn(
                    symbol = "/",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Divide)
                    }
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btn_spacing)
            ) {
                CalculatorBtn(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }

                )
                CalculatorBtn(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )

                CalculatorBtn(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )
                CalculatorBtn(
                    symbol = "x",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Multiply)
                    }
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btn_spacing)
            ) {
                CalculatorBtn(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }

                )
                CalculatorBtn(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(5))

                    }
                )

                CalculatorBtn(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )
                CalculatorBtn(
                    symbol = "+",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Add)
                    }
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btn_spacing)
            ) {
                CalculatorBtn(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }

                )
                CalculatorBtn(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )

                CalculatorBtn(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )
                CalculatorBtn(
                    symbol = "-",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Subtract)
                    }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btn_spacing)
            ) {
                CalculatorBtn(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }

                )
                CalculatorBtn(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )

                CalculatorBtn(
                    symbol = "=",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Equal)
                    }
                )

            }
        }


    }

}

@Composable
@Preview
fun showCalculator() {

    val viewModel= viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val buttonspacing=8.dp
    Calculator(state = state , onAction = viewModel::onAction, modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
        .padding(16.dp),
        btn_spacing = buttonspacing)
    }

