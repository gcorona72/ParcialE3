package com.example.parciale3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun FarmaciaListScreen(onFarmaciaClick: (Farmacia) -> Unit) {
    var farmacias by remember { mutableStateOf(listOf<Farmacia>()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            farmacias = withContext(Dispatchers.IO) {
                RetrofitHelper.api.getFarmacias()
            }
        } catch (e: Exception) {
            errorMessage = "Error al cargar las farmacias. Intenta más tarde."
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (!errorMessage.isNullOrEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = errorMessage ?: "Error desconocido")
        }
    } else {
        LazyColumn {
            items(farmacias) { farmacia ->
                FarmaciaItem(farmacia = farmacia, onClick = onFarmaciaClick)
            }
        }
    }
}

@Composable
fun FarmaciaItem(farmacia: Farmacia, onClick: (Farmacia) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(farmacia) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_farmacia),
            contentDescription = "Icono de farmacia",
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = farmacia.title)
            Text(text = farmacia.telefono ?: "Teléfono no disponible")
        }
    }
}
