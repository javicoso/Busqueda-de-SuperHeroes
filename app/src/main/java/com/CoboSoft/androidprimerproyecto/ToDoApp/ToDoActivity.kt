package com.CoboSoft.androidprimerproyecto.ToDoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.CoboSoft.androidprimerproyecto.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoActivity : AppCompatActivity() {

    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other

    )


    private val tasks = mutableListOf(

        Task("PruebaBusinnes", TaskCategory.Business),
        Task("PruebaPersonal", TaskCategory.Personal),
        Task("PruebaOther", TaskCategory.Other)


    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter


    private lateinit var rvTask: RecyclerView

    private lateinit var tasksAdapter: TaskAdapter


    private lateinit var favAddTask: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        initComponent()
        initUI()
        initListener()


    }

    private fun initListener() {
        favAddTask.setOnClickListener {

            showDialog()
        }
    }

    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {

            val currentTask = etTask.text.toString()

            if (currentTask.isNotEmpty()) {


                val selectedId = rgCategories.checkedRadioButtonId

                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId);

                val currentCategory: TaskCategory = when (selectedRadioButton.text) {

                    getString(R.string.todo_dialog_categories_Bussines) -> TaskCategory.Business
                    getString(R.string.todo_dialog_categories_Personal) -> TaskCategory.Personal

                    else -> TaskCategory.Other

                }
                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()

            }

        }

        dialog.show()
    }


    private fun initComponent() {

        rvCategories = findViewById(R.id.rvCategories)
        rvTask = findViewById(R.id.rvTask)
        favAddTask = findViewById(R.id.favAddTask)
    }

    private fun initUI() {

        categoriesAdapter = CategoriesAdapter(categories){ updateCategories(it)}
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter


        tasksAdapter = TaskAdapter(tasks) { onItemSelected(it) }
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = tasksAdapter


    }

    private  fun onItemSelected(position:Int){
        tasks[position].isSelected=!tasks[position].isSelected
        updateTasks()
    }


    private fun updateTasks() {

        val selectedCategories:List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks=tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks= newTasks
        tasksAdapter.notifyDataSetChanged()


    }

    private  fun updateCategories(position: Int){

        categories[position].isSelected=!categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()

    }

}