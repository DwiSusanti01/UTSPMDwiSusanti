package com.dwisusanti.utspmdwisusanti
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dwisusanti.utspmdwisusanti.adapter.ItemAdapter
import com.dwisusanti.utspmdwisusanti.data.Datasource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //menentukan variabel dengan nama button1 dengan menggunakan kata kunci variabel (val), kemudian mendefinisikan tombol dengan id tombol yang dibuat pada activity_main.xml
        val button1 = findViewById<Button>(R.id.button)
        // mengatur agar tombol bisa di klik dan jika sudah di klik akan menampilkan text "Button Clicked"
        button1.setOnClickListener {
            Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show()
        }

        // Menginisialisasi data
        val myDataset = Datasource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // pengaturan untuk meningkatkan kinerja jika terjadi perubahan dalam konten, tidak mengubah ukuran tata letak RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}