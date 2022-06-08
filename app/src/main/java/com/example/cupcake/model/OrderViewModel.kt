package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel : ViewModel() {

    val dateOptions = getPickupOptions()

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


    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calender = Calendar.getInstance()
        // Create a list of dates starting with the current date and the following 3 dates
        repeat(4) {
            options.add(formatter.format(calender.time))
            calender.add(Calendar.DATE, 1)
        }
        return options
    }
}