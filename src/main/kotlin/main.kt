import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image

fun main() = Window {
    val mimic = Mimic()
    mimic.processMimicCharacterSet()
    var mimicText by remember { mutableStateOf(TextFieldValue("")) }
    mimicText = TextFieldValue(mimic.mimicCharacters)

    var clickCode by remember { mutableStateOf(TextFieldValue("")) }
    var output by remember { mutableStateOf(TextFieldValue("")) }

    MaterialTheme {
        Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
            Row {
                Image(
                    bevis()
                )
            }
            Row(rowModifier) {
                OutlinedTextField(modifier = inputModifier.align(Alignment.Top),
                    value = mimicText,//   clickCode,
                    onValueChange = {
                        clickCode = it
                    },
                    label = { Text("Code Here") }
                )
            }
            Row(Modifier.preferredHeight(200.dp).padding(8.dp)) {
                TextField(modifier = outputModifier.align(Alignment.Top), value = output, onValueChange = {  })
            }
            Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    //val womLogIt = WomLogIt()
                    //val value = womLogIt.AddWomLogs(clickCode.text)
                    //output = TextFieldValue(value)
                }) {
                Text("Mimic It")
            }
        }
    }
}