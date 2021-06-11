package dev.zotov.todoapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dev.zotov.todoapp.R
import dev.zotov.todoapp.data.models.Priority
import dev.zotov.todoapp.data.models.TodoData
import dev.zotov.todoapp.data.viewmodels.TodoViewModel
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    private val viewModel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        view.findViewById<Button>(R.id.confirm_Button).setOnClickListener { insertDataToDb() }

        return view;
    }

    private fun insertDataToDb() {
        val title = title_EditText.text.toString()
        val priority = priority_Spinner.selectedItem.toString()
        val description = description_EditText.text.toString()

        val validation = verifyData(title, description)
        if (validation) {
            val data = TodoData(
                1,
                title,
                stringToPriority(priority),
                description
            )
            viewModel.insertData(data)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment);
        } else {
            Toast.makeText(requireContext(), "Fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyData(title: String, description: String): Boolean {
        return !TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)
    }

    private fun stringToPriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> {
                Priority.HIGH
            }
            "Medium Priority" -> {
                Priority.MEDIUM
            }
            "Low Priority" -> {
                Priority.LOW
            }
            else -> Priority.LOW
        }
    }
}