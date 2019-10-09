package com.example.roomforfragments.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomforfragments.R
import com.example.roomforfragments.database.CelebrityDAO
import com.example.roomforfragments.database.CelebrityDatabase
import com.example.roomforfragments.database.CelebrityEntity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    override fun communicateToActivity() {
        Toast.makeText(this, "Fragment B says 'Hello Activity'", Toast.LENGTH_LONG).show()
    }

    override fun communicateToFragmentA() {

        fragmentA.saysHello()
    }

    override fun fragmentAButtonPressed() {
        Toast.makeText(this, "Fragment A says 'Hello Activity'", Toast.LENGTH_LONG).show()
    }

    private val fragmentA = FragmentA()
    private val fragmentB = FragmentB()

    private lateinit var myDAO: CelebrityDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myDAO = Room.databaseBuilder(
            this,
            CelebrityDatabase::class.java,
            "celebrity.db")
            .allowMainThreadQueries()
            .build()


        val celebrity  = CelebrityEntity("Charlie Brown", "Cartoon")
        val celebrity2  = CelebrityEntity("Ramsey Noah", "Actor")
        val celebrity3  = CelebrityEntity("Gordon Ramsey", "Chef")
        val celebrity4  = CelebrityEntity("Bill Gates", "Tech")
        val celebrity5  = CelebrityEntity("Lebron James", "Sports")
        val celebrity6  = CelebrityEntity("Elvis Presley", "Music")

        myDAO.celebrityDAO().insertAllCelebrities(celebrity, celebrity2, celebrity3, celebrity4,celebrity5, celebrity6)

        val guestList = myDAO.celebrityDAO().getAllCelebrities()

        val stringBuilder = StringBuilder()
        guestList.forEach { celeb ->
            stringBuilder.append("\n${celeb.celebName} ${celeb.celebIndustry}")
        }

        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_LONG).show()

        setContentView(R.layout.activity_main)

        load_fragment_button.setOnClickListener { _->
            val bundle = Bundle()
            bundle.putString(FragmentA.valueKey, "Some text goes here.")
            fragmentA.arguments = bundle
            fragmentA.setFragmentAListener(this)

            supportFragmentManager.beginTransaction()
                .add(R.id.my_framelayout, fragmentA)
                .addToBackStack(fragmentA.tag)
                .commit()

//            Fragment B
            val bundleB = Bundle()
            bundle.putString(FragmentA.valueKey, "Some text goes here.")
            fragmentB.setListener(this)
            fragmentB.arguments = bundle
            supportFragmentManager.beginTransaction()
                .add(R.id.my_framelayout_b, fragmentB)
                .commit()

        }
    }
}
