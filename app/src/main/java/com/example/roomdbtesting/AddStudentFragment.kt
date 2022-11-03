package com.example.roomdbtesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.roomdbtesting.data.Student
import com.example.roomdbtesting.data.StudentRollCallApplication
import com.example.roomdbtesting.data.StudentViewModel
import com.example.roomdbtesting.data.StudentViewModelFactory
import com.example.roomdbtesting.databinding.FragmentAddStudentBinding

class AddStudentFragment : Fragment() {

    private var _binding : FragmentAddStudentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    private val viewModel : StudentViewModel by activityViewModels(){

        lateinit var student : Student

        StudentViewModelFactory(
            (activity?.application as StudentRollCallApplication).database.studentDao()
        )

    }

      fun isEntryValid(first_name : String, last_name : String, age : String): Boolean {
        if (first_name.isBlank() || last_name.isBlank() || age.isBlank()) {
            return false
        }
        return true
    }

     private fun isEntryValid(): Boolean {
        return isEntryValid(
            binding.etFirstName.text.toString(),
            binding.etLastName.text.toString(),
            binding.etAge.text.toString()
        )
    }

    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(
                binding.etFirstName.text.toString(),
                binding.etLastName.text.toString(),
                binding.etAge.text.toString()
            )
            Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener(View.OnClickListener {
            addNewItem()
        })
    }


}