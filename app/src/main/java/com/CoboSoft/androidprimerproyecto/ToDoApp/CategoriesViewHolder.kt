package com.CoboSoft.androidprimerproyecto.ToDoApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.CoboSoft.androidprimerproyecto.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if (taskCategory.isSelected) {

            R.color.toDoApp5
        } else {
            R.color.toDoApp4
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context,color))


        itemView.setOnClickListener { onItemSelected(layoutPosition) }


        when (taskCategory) {
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"

                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.resultBajo)
                )

            }

            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.resulNormal)
                )

            }

            TaskCategory.Other -> {
                tvCategoryName.text = "Otros"

                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.resultAlto)
                )

            }

        }

    }


}







