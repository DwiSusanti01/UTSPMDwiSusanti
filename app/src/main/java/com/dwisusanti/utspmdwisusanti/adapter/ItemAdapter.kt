package com.dwisusanti.utspmdwisusanti.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dwisusanti.utspmdwisusanti.R
import com.dwisusanti.utspmdwisusanti.model.Affirmation
    // ItemAdapter sebagai nama class
    class ItemAdapter(
        // membuat parameter ke konstruktor ItemAdapter yang merupakan val yang disebut context dari jenis Context
        private val context: Context,
        // menambahkan parameter ke ItemAdapter konstruktor yang merupakan val yang disebut dataset jenis List<Affirmation> dan Impor Affirmation
        // dataset hanya akan digunakan dalam class ini,maka dijadikan private.
        private val dataset: List<Affirmation>
        // menambahkan kode untuk memperluas ItemAdapter dari class abstrak RecyclerView.Adapter.
        // ItemAdapter.ItemViewHolder sebagai jenis holder tampilan dalam tanda kurung sudut
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


        // Memberikan referensi ke tampilan untuk setiap item data
        // Item data yang kompleks memerlukan lebih dari satu tampilan per item, dan
        // menyediakan akses ke semua tampilan untuk item data di view holder
        // Setiap item data hanyalah objek Afirmasi.

        // membuat class ItemViewHolder
        // menambahkan private val view dari jenis View sebagai parameter ke konstruktor class ItemViewHolder.
        // ItemViewHolder sebagai subclass dari RecyclerView. ViewHolder dan meneruskan parameter view ke dalam konstruktor superclass.
        class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
            val imageView: ImageView = view.findViewById(R.id.item_image)
            // // dalam ItemViewHolder, menentukan val properti textView yang berjenis TextView. menerapkan tampilan dengan ID item_title yang di tentukan di list_item.xml
            val textView: TextView = view.findViewById(R.id.item_title)
        }
        // Membuat tampilan baru (dipanggil oleh layout manager)
        // Parameter parent, yang merupakan kelompok tampilan item daftar baru sebagai turunan. Induk adalah RecyclerView.
        // Parameter viewType yang menjadi penting saat ada beberapa jenis tampilan item dalam RecyclerView yang sama.
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            // instance LayoutInflater dari konteks yang disediakan (context dari parent).
            // ID resource tata letak XML R.layout.list_item dan kelompok tampilan parent. Argumen boolean ketiga adalah attachToRoot. Argumen ini harus false
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
            // Menampilkan instance ItemViewHolder baru yang tampilan root-nya adalah adapterLayout.
            return ItemViewHolder(adapterLayout)
        }

        //Mengganti isi tampilan (dipanggil oleh layout manager)
        // Metode onBindViewHolder() memiliki dua parameter,
        // ItemViewHolder yang sebelumnya dibuat oleh metode onCreateViewHolder(), dan int yang mewakili item position dalam daftar.
        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = dataset[position]
            holder.textView.text = context.resources.getString(item.stringResourceId)
            holder.imageView.setImageResource(item.imageResourceId)
        }

        // Metode getItemCount() Menampilkan ukuran set data (dipanggil oleh layout manager)
        // aplikasi berada di properti dataset yang diberikan ke konstruktor ItemAdapter dan bisa mendapatkan ukurannya dengan size.
        override fun getItemCount() = dataset.size
    }