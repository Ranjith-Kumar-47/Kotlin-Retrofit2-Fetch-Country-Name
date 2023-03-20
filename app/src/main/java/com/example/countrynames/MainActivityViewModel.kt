package com.example.countrynames

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivityViewModel : ViewModel() {

    var mutableLiveData:MutableLiveData<CountryNameModelClass> = MutableLiveData()

    fun getLiveDataObserver():MutableLiveData<CountryNameModelClass>
    {
        return mutableLiveData
    }
    fun apiCall() {
        val apiInstance: ApiCall = ApiInstance.getInstance()
        apiInstance.getCountryList().enqueue(object :retrofit2.Callback<CountryNameModelClass>{
            override fun onResponse(
                call: Call<CountryNameModelClass>,
                response: Response<CountryNameModelClass>
            ) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<CountryNameModelClass>, t: Throwable) {
                mutableLiveData.postValue(null)
            }

        })
    }

}