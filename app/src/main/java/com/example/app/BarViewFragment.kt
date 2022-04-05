package com.example.app

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ActivityHomeBinding
import com.example.app.databinding.FragmentBarViewBinding
import kotlinx.android.synthetic.main.contactrow.*
import kotlinx.android.synthetic.main.fragment_bar_view.*

class BarViewFragment : Fragment() {

    private lateinit var addimage: ImageView
    private lateinit var heImage: ImageView
    private lateinit var msImage: ImageView
    private lateinit var contactsRecycler: RecyclerView
    private lateinit var addButton: Button
    private lateinit var intent: Intent

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: UsersAdapter;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bar_view, container, false)

        addimage = view.findViewById(R.id.addimage)
        heImage = view.findViewById(R.id.heImage)
        msImage = view.findViewById(R.id.msImage)
        contactsRecycler = view.findViewById(R.id.contactsRecycler)

        layoutManager = LinearLayoutManager(context)
        contactsRecycler.layoutManager = layoutManager
        contactsRecycler.setHasFixedSize(true)

        adapter = UsersAdapter()
        contactsRecycler.adapter = adapter

        addimage.setOnClickListener {



        }




        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = BarViewFragment()
    }
}