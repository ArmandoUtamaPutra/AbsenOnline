package com.example.absenonline.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.BaseAdapter
import com.example.absenonline.R
import com.example.absenonline.adapter.MenuUtamaAdapter
import kotlinx.android.synthetic.main.activity_menu_utama.*
import kotlinx.android.synthetic.main.layout_adapter.view.*

class DataMenuUtama : AppCompatActivity (){

    var adapter: ImageAdapter? = null
    var menuAdapter = ArrayList<MenuUtamaAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_utama)



        // load foods
        menuAdapter.add(MenuUtamaAdapter("Absen", R.drawable.attendance))
        menuAdapter.add(MenuUtamaAdapter("About Company ", R.drawable.factory))
        menuAdapter.add(MenuUtamaAdapter("Gallery", R.drawable.gallery))
        menuAdapter.add(MenuUtamaAdapter("Absen History", R.drawable.clock))
        adapter = ImageAdapter(this, menuAdapter)

        gvHome.adapter = adapter
        gvHome.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                //Toast.makeText(this, "Anda memilih: 0",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DataAbsensi::class.java)
                startActivity(intent)
            } else if (position == 1) {
//                Toast.makeText(this, "Anda memilih: 1", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DataAbout::class.java)
                startActivity(intent)
            } else if (position == 2) {
                //Toast.makeText(this, "Anda memilih: 2", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DataGallery::class.java)
                startActivity(intent)
            } else if (position == 3) {
//                Toast.makeText(this, "Anda memilih: 3", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DataHistoryAbsen::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        startActivity(Intent(this, DataMenuUtama::class.java))
        return super.onOptionsItemSelected(item)
    }


    class ImageAdapter : BaseAdapter {
        var menuAdapter = ArrayList<MenuUtamaAdapter>()
        var context: Context? = null

        constructor(context: Context, menuAdapter: ArrayList<MenuUtamaAdapter>) : super() {
            this.context = context
            this.menuAdapter = menuAdapter
        }

        override fun getCount(): Int {
            return menuAdapter.size
        }

        override fun getItem(position: Int): Any {
            return menuAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val list = this.menuAdapter[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var menuView = inflator.inflate(R.layout.layout_adapter, null)
            menuView.imgList.setImageResource(list.image!!)
            menuView.tvName.text = list.name!!

            return menuView
        }
    }

}
