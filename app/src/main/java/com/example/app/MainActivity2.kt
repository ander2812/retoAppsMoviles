package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {

    private lateinit var navigator:BottomNavigationView
    private lateinit var barViewFragment: BarViewFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        barViewFragment = BarViewFragment.newInstance()

        navigator = findViewById(R.id.navigator)

        navigator.setOnItemSelectedListener { menuItem->

            if(menuItem.itemId == R.id.homeitem){
                showFragment(barViewFragment)

            }else if(menuItem.itemId == R.id.searchitem){


            }else if(menuItem.itemId == R.id.videoitem){


            }else if(menuItem.itemId == R.id.storeitem){


            }else if(menuItem.itemId == R.id.profileitem){

            }

            true
        }
    }



    fun showFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()

    }
}