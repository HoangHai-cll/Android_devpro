package com.devpro.android58_day10.example.ex2

class TaskServices(private val notificationSender: NotificationSender) {
    private val listTask = mutableListOf<Task>()

    fun createTask(user: User, id: String, title: String):Boolean {
        // title không được rỗng
        if (title.isBlank()) return false
        // Không cho trùng id
        if (listTask.any { it.id == id }) return false
        // Tạo task và thêm vào danh sách
        val task = Task(id, title)
        listTask.add(task)
        // Gửi thông báo khi tạo thành công
        notificationSender.sendNotification(user, "Task '$title' (id=$id) đã được tạo thành công!")
        return true
    }

    fun markDone(id:String): Boolean{
        val task = listTask.find { it.id == id } ?: return false
        task.markDone()
        return true
    }

    fun listOpenTask(): List<Task>{
        return listTask.filter { !it.isComplete() }
    }
}