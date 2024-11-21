package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Biodata(modifier: Modifier = Modifier){
    Column (modifier = Modifier.fillMaxSize())
    {
        HeaderSection()
        InputData()

    }
}

@Composable
fun HeaderSection(){
    Box(modifier = Modifier.fillMaxWidth().background(Color.Blue)){
        Row (modifier = Modifier.fillMaxWidth().padding(16.dp))
        {
            Box(contentAlignment = Alignment.BottomEnd){
                Image(painter = painterResource(id = R.drawable.cp), contentDescription = null,
                    modifier = Modifier.clip(CircleShape))                                                                              //agar gambarnya jadi bulet
                Icon(
                    Icons.Filled.Check, contentDescription = null, modifier = Modifier.size(30.dp).background(Color.Blue)               //kasih tanda ceklis
                )
            }
            Column (modifier = Modifier.padding(14.dp))
            {
                Text(text = "Halo")
                Text(text = "Ikhda Akmalia Putri")
            }
        }
    }
}

@Composable
fun InputData(modifier: Modifier = Modifier){

        var Email by remember { mutableStateOf("") }
        var Alamat by remember { mutableStateOf("") }
        var NoTelp by remember { mutableStateOf("") }
        var Tahun by remember { mutableStateOf("") }
        var dataTahun = listOf("2020", "2021", "2022")

        var confEmail by remember { mutableStateOf("") }
        var confNoTelp by remember { mutableStateOf("") }
        var confAlamat by remember { mutableStateOf("") }
        var confTahun by remember { mutableStateOf("") }

        Column (modifier = modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            TextField(
                value = Email,
                onValueChange = {Email = it},                            // it = memanggil Email sesuai yg di tulis pada Email(value)
                label = {
                    Text(text = "Email")
                },
                placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                    Text(text = "isi email anda")                        //hint
                },
                modifier = Modifier.fillMaxWidth().padding(5.dp), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            TextField(
                value = NoTelp,
                onValueChange = {NoTelp = it},                            //it = memanggil NoTelp sesuai yg di tulis pada NoTelp(value)
                label = {
                    Text(text = "NoTelp")
                },
                placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                    Text(text = "isi NoTelp anda")                       //hint
                },
                modifier = Modifier.fillMaxWidth().padding(5.dp), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = Alamat,
                onValueChange = {Alamat = it},                            //it = memanggil Alamat sesuai yg di tulis pada Alamat(value)
                label = {
                    Text(text = "Alamat")
                },
                placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                    Text(text = "isi alamat anda")                        //hint
                },
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )
            Row (modifier = modifier.fillMaxWidth()){                       //looping untuk radio
                dataTahun.forEach{selectedTahun ->
                    Row(verticalAlignment = Alignment.CenterVertically){
                        RadioButton(
                            selected = Tahun == selectedTahun,
                            onClick = {Tahun = selectedTahun}
                        )
                        Text(text = selectedTahun)}
                }
            }
            Button(onClick = {                                          //button kliknya
                confEmail = Email
                confNoTelp = NoTelp
                confAlamat = Alamat
                confTahun = Tahun
            }){
                Text(text = "Submit")
            }
            TampilData(
                param = "Email",
                argum = confEmail)
            TampilData(
                param = "Phone",
                argum = confNoTelp)
            TampilData(
                param = "Address",
                argum = confAlamat)
            TampilData(
                param = "Year",
                argum = confTahun)
    }
}
@Composable
fun TampilData(param : String, argum: String)
{
    Box(modifier = Modifier.fillMaxWidth().background(Color.Gray)){
        Column (modifier = Modifier.padding(16.dp))
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = param,
                    modifier = Modifier.weight(0.8f))
                Text(
                    text = ":",
                    modifier = Modifier.weight(0.2f))
                Text(
                    text = argum,
                    modifier = Modifier.weight(2f))
            }
        }
    }

}
