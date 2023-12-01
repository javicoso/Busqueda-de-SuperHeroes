package com.CoboSoft.androidprimerproyecto.ToDoApp

sealed class TaskCategory (var isSelected:Boolean=true){

    object  Personal :TaskCategory()
    object  Business : TaskCategory()
    object  Other: TaskCategory()

}