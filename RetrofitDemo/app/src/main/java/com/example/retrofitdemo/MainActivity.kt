package com.example.retrofitdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var ratService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ratService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
//        getRequestWithPathParameters()
//        getRequestWithQueryParameter()
        uploadAlbum()


    }

    private fun getRequestWithQueryParameter() {

        val responseLiveData: LiveData<Response<Album>> = liveData {
            val response = ratService.getAlbumsForUserID(3)
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumList: MutableListIterator<AlbumItem>? = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    Log.i("album title", albumItem.title.toString())

                    val result = " " + "Album id : ${albumItem.id}" + "\n" +
                            " " + "Album title : ${albumItem.title}" + "\n" +
                            " " + "User id : ${albumItem.userId}" + "\n\n\n"
                    tv_text.append(result)


                }

            }
        })
    }

    private fun getRequestWithPathParameters() {
        //path parameter
        val pathRespone: LiveData<Response<AlbumItem>> = liveData {
            val responseAlbum = ratService.getAlbum(3)
            emit(responseAlbum)
        }

        pathRespone.observe(this, Observer {
            var title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
        })
    }

    private fun uploadAlbum (){
        val album = AlbumItem(101, "My title",1000)
        val postResponse : LiveData<Response<AlbumItem>> = liveData {
            val response = ratService.uploadAlbub(album)
            emit(response)
        }
        postResponse.observe(this, Observer {
            val recieverAlbumsItem = it.body()
            val result = " " + "Album id : ${recieverAlbumsItem?.id}" + "\n" +
                    " " + "Album title : ${recieverAlbumsItem?.title}" + "\n" +
                    " " + "User id : ${recieverAlbumsItem?.userId}" + "\n\n\n"
            tv_text.append(result)
        })
    }


}
