package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MhsDatabase(this)



        tambah.setOnClickListener{
            var nama_mhs = nama.text.toString()
            var alamat_mhs = alamat.text.toString()

            hasilnama.setText(nama_mhs)
            hasilalamat.setText(alamat_mhs)


            GlobalScope.launch {

                db.mhsDao().insertAll(MhsEntity(0, nama_mhs, alamat_mhs))
                val data = db.mhsDao().getAll()

                data?.forEach {
                    Log.d("DATABASE", it.toString())
                }
            }
        }

    }
}
