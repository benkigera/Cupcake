package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>(0)
    val quantity: LiveData<Int> = _quantity

    //setter method
    fun setQuantity(numberCupCakes: Int) {
        _quantity.value = numberCupCakes
    }

    private val _flavor = MutableLiveData<String>("")
    val flavor: LiveData<String> = _flavor

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    private val _date = MutableLiveData<String>("")
    val date: LiveData<String> = _date

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }

    private val _price = MutableLiveData<Double>(0.0)
    val price: LiveData<Double> = _price


    fun hasNoFlavorSet() : Boolean{
        return _flavor.value.isNullOrEmpty()
    }
}