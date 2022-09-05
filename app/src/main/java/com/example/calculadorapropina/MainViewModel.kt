package com.example.calculadorapropina

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class MainViewModel : ViewModel() {

    private val _coste = MutableLiveData<Double?>()

    private val _porcentaje = MutableLiveData<Double?>()
    val porcentaje: LiveData<Double?> = _porcentaje

    private val _propina = MutableLiveData<Double>()
    val propina: LiveData<String> = Transformations.map(_propina) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    init {
        inicioAplicacion()
    }

    fun fijarPorentaje(valorable: Double?) {
        _porcentaje.value = valorable
    }

    fun fijarPropina(checked: Boolean, insertCost: String) {
        val convertString = insertCost.toDoubleOrNull()
        if (convertString == null) {
            _coste.value = 0.00
        } else {
            _coste.value = convertString
        }

        if (_porcentaje.value == null) {
            _porcentaje.value = 0.00
        }
        val propinaReal: Double? = _coste.value?.let { _porcentaje.value?.times(it) }

        if (checked) {
            val redondeo = kotlin.math.ceil(propinaReal!!)
            _propina.value = redondeo
        } else {
            _propina.value = propinaReal!!
        }
    }

    fun inicioAplicacion() {
        _coste.value = 0.00
        _porcentaje.value = 0.00
        _propina.value = 0.00
    }
}
