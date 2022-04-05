package com.example.app

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

    private lateinit var insImage: ImageView
    private lateinit var heImage: ImageView
    private lateinit var msImage: ImageView
    private lateinit var contactsRecycler: RecyclerView
    private lateinit var addButton: Button

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: UsersAdapter;
    private lateinit var binding: FragmentBarViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bar_view, container, false)
        val galeryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ::onGaleryResult)

        insImage = view.findViewById(R.id.insImage)
        heImage = view.findViewById(R.id.heImage)
        msImage = view.findViewById(R.id.msImage)
        contactsRecycler = view.findViewById(R.id.contactsRecycler)
        addButton =view.findViewById(R.id.addButton)

        layoutManager = LinearLayoutManager(context)
        contactsRecycler.layoutManager = layoutManager
        contactsRecycler.setHasFixedSize(true)

        adapter = UsersAdapter()
        contactsRecycler.adapter = adapter

        addButton.setOnClickListener {
            print("entro aqui")
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            galeryLauncher.launch(intent)

        }


        return view
    }

    fun onGaleryResult(result: ActivityResult?){

    }

    companion object {
        @JvmStatic
        fun newInstance() = BarViewFragment()
    }
}