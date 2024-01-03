package com.example.advnative_waroengujang.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.example.advnative_waroengujang.model.Menu
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListMenuModel: ViewModel() {
    val menusLD = MutableLiveData<ArrayList<Menu>>()

    fun refresh() {
        var gson = Gson()
        val json1 = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Ayam Saus Inggris\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit amet\",\n" +
                "    \"price\": \"25000\",\n" +
                "    \"photo\": \"https://2.bp.blogspot.com/-CJx7QU8WEjM/WBGpdDkt3EI/AAAAAAAAAxA/lNGFehyV3-II_DCW3ZeBvmXIutazfZNMgCLcB/s1600/ayam%2Bbakar2.png\",\n" +
                "    \"category\": \"Main Course\"\n" +
                "  }"
        val json2 = "{\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Ayam Kalasan\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit amet\",\n" +
                "    \"price\": \"25000\",\n" +
                "    \"photo\": \"https://www.dapurkobe.co.id/wp-content/uploads/ayam-kalasan-kremes.jpg\",\n" +
                "    \"category\": \"Main Course\"\n" +
                "  }"
        val json3 = "{\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"Ayam Kremes\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit amet\",\n" +
                "    \"price\": \"25000\",\n" +
                "    \"photo\": \"https://www.jossdelapanbelas.com/wp-content/uploads/2022/02/Nasi-Bakar-Ayam-Kremes_prod-1024x1024.png\",\n" +
                "    \"category\": \"Main Course\"\n" +
                "  }"
        val json4 = "{\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"Es Teh\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit amet\",\n" +
                "    \"price\": \"4000\",\n" +
                "    \"photo\": \"https://order.ayambakarpakde.com/wp-content/uploads/2021/12/ayam-bakar-pak-d-ala-carte-es-teh.png\",\n" +
                "    \"category\": \"Drink\"\n" +
                "  }"
        val json5 = "{\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"Es Jeruk\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit amet\",\n" +
                "    \"price\": \"6000\",\n" +
                "    \"photo\": \"https://order.ayambakarpakde.com/wp-content/uploads/2021/12/ayam-bakar-pak-d-es-jeruk.png\",\n" +
                "    \"category\": \"Drink\"\n" +
                "  }"

        var menu1 = gson.fromJson(json1, Menu::class.java)
        var menu2 = gson.fromJson(json2, Menu::class.java)
        var menu3 = gson.fromJson(json3, Menu::class.java)
        var menu4 = gson.fromJson(json4, Menu::class.java)
        var menu5 = gson.fromJson(json5, Menu::class.java)
        menusLD.value = arrayListOf(menu1, menu2, menu3, menu4, menu5)
    }
}