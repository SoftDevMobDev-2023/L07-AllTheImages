package au.edu.swin.sdmd.l07_alltheimages_2023

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: TheAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<RecyclerView>(R.id.locationList)

        linearLayoutManager = LinearLayoutManager(this)
        listView.layoutManager = linearLayoutManager

        val data = initData()

        adapter = TheAdapter(data) { showDialog(it) }
        listView.adapter = adapter
    }

    private fun showDetail(item: Location) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("location", item)
        startActivity(intent)
    }

    private fun showMap(item: Location) {
        val gmmIntentUri = Uri.parse("geo:${item.latitude},${item.longitude}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        // comment this out to become an implicit intent
        //mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun showDialog(item: Location) {
        ItemDialogFragment.newInstance(item).show(supportFragmentManager, "dialog")
    }


    private fun initData(): List<Location> {
        val data = mutableListOf<Location>()
        data.add(Location("Glenferrie Station", "Ada May Plante",
            -37.821539f, 145.036473f, image = R.drawable.station))
        data.add(Location("Swinburne College", "unknown",
            -37.822036f, 145.038875f, image = R.drawable.college))
        data.add(Location("Theatre", "unknown",
            -37.819927f, 145.035722f, image = R.drawable.theatre))
        data.add(Location("Catholic Church", "unknown",
            -37.822435f, 145.035231f))
        data.add(Location("Corner shops", "unknown",
            -37.822520f, 145.035483f))
        data.add(Location("Town Hall", "unknown",
            -37.822821f, 145.035992f))
        data.add(Location("Anglican Church", "unknown",
            -37.823361f, 145.039576f))
        data.add(Location("Hawthorn Hotel", "unknown",
            -37.823027f, 145.039909f))
        data.add(Location("House", "unknown",
            -37.823576f, 145.042800f))
        data.add(Location("Glenferrie Hotel ", "unknown",
            -37.822604f, 145.034480f))
        data.add(Location("Auburn Rd", "unknown",
            -37.823692f, 145.044769f))
        data.add(Location("Hawthorn Station", "unknown",
            -37.821946f, 145.023194f))
        data.add(Location("Office building", "unknown",
            -37.822170f, 145.029600f))
        // just for some extra rows to play with recycling
        for (i in 1..500) data.add(Location("Sarawak", "unknown", 1.5324f, 110.3572f))
        return data
    }
}