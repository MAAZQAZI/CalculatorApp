package com.example.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import com.example.calculatorapp.ui.theme.Orange


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    btnSpacing: Dp = 8.dp,
    onAction: (CalculatorActions) -> Unit


) {


    Box(modifier = Modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(btnSpacing)


        ) {

            Text(text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                fontWeight = FontWeight.Light,
                fontSize = 84.sp,
                color = Color.Black,
                maxLines = 2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                onTextLayout = {})
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                maxItemsInEachRow = 4

            ) {
                state.buttons.forEach { (symbol, action) ->
                    CalculatorBtn(
                        symbol = symbol,
                        modifier = Modifier
                            .background(
                                if (symbol in listOf(
                                        "AC",
                                        "Del",
                                        ".",
                                        "="
                                    )
                                ) Color.LightGray else if (symbol in listOf(
                                        "/",
                                        "x",
                                        "+",
                                        "-"
                                    )
                                ) Orange else Color.DarkGray
                            )
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(action) }
                    )
                }
            }
        }
    }

}

@Composable
@Preview
fun ShowCalculator() {

    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val buttonSpacing = 8.dp
    Calculator(
        state = state, onAction = viewModel::onAction, modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp),
        btnSpacing = buttonSpacing
    )
}

