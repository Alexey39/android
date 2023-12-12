package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Api.AdapterNews
import com.example.myapplication.Api.ApiRequest
import com.example.myapplication.Model.NewsItem
import com.example.myapplication.databinding.FragmentAnalizBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
private var _binding: FragmentAnalizBinding?=null
private val adapterNews = AdapterNews()
    // TODO: Rename and change types of parameters

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentAnalizBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = FragmentAnalizBinding.inflate(layoutInflater)


        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnalizBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_analiz, container, false)
        news()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }

    fun news() {
        val api = Retrofit.Builder()
            .baseUrl("https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getNews().awaitResponse()
                if(response.isSuccessful)
                {
                    val data = response.body()!!
                    activity?.runOnUiThread { initNews(data) }
                    Log.d("MainActivity", data.toString())
                }
            }
            catch (e: Exception){
                withContext(Dispatchers.Main)
                {
                    Log.d("MainActivity", e.toString())
                }
            }
        }
    }

    fun initNews(data: ArrayList<NewsItem>)
    {
        with(binding) {
            viewL.layoutManager = LinearLayoutManager(
                activity as Context,
                LinearLayoutManager.HORIZONTAL,
                false
            ) // Настраиваем наш list
            viewL.adapter =  adapterNews// Добавляем к листу адаптер

            val listNews: ArrayList<NewsItem> = data// Получаем лист объектов
            if (listNews.isNotEmpty()) {
                for (element in listNews) {
                    adapterNews.updateData(element) // Добавляем по очередно в адаптер
                }
            }
        }

    }

}
