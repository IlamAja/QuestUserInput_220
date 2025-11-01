package com.example.inputpengguna

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight

data class UserData(
    val nama: String = "",
    val gender: String = "",
    val status: String = "",
    val alamat: String = ""
)

@Composable
fun FormDataDir(modifier: Modifier = Modifier)
{
    var textNama by remember { mutableStateOf(value = "")}
    var textAlamat by remember { mutableStateOf(value = "")}
    var selectedGender by remember { mutableStateOf(value = "")}
    var selectedStatus by remember { mutableStateOf(value = "")}

    var submittedData by remember { mutableStateOf(UserData()) }

    val genders: List<String> = listOf("Laki-laki", "Perempuan")
    val maritalStatuses: List<String> = listOf("Janda", "Lajang", "Duda")
    val primaryColor = Color(0xFF673AB7)

    Column(

        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryColor)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }


        Column(

            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = "NAMA LENGKAP", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Isian nama lengkap") },
                onValueChange = { textNama = it }
            )

            Text(text = "JENIS KELAMIN", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
            Column(Modifier.selectableGroup()) {
                genders.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedGender == item,
                                onClick = { selectedGender = item },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedGender == item,
                            onClick = null
                        )
                        Text(text = item)
                    }
                }
            }

            Text(text = "STATUS PERKAWINAN", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
            Column(Modifier.selectableGroup()) {
                maritalStatuses.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedStatus == item,
                                onClick = { selectedStatus = item },
                                role = Role.RadioButton
                            )
