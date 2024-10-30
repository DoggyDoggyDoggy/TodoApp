package denys.diomaxius.todoapp.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import denys.diomaxius.todoapp.MainApplication
import denys.diomaxius.todoapp.data.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {
    val todoDao = MainApplication.todoDatabase.getTodoDao()

    val todList: LiveData<List<Todo>> = todoDao.getAllTodo()

    fun addTodo(title: String) {
        viewModelScope.launch {
            todoDao.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            todoDao.deleteTodo(id)
        }
    }
}