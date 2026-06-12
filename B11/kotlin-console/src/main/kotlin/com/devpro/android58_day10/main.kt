package com.devpro.android58_day10

import com.devpro.android58_day10.classtype.data_class.Constants
import com.devpro.android58_day10.classtype.data_class.DemoEnum
import com.devpro.android58_day10.classtype.data_class.DemoSealed
import com.devpro.android58_day10.example.ex1.BankAccount
import com.devpro.android58_day10.example.ex2.ConsoleSender
import com.devpro.android58_day10.example.ex2.TaskServices
import com.devpro.android58_day10.example.ex2.User
import com.devpro.android58_day10.utils.MyExtendFunction.isPrime
import com.devpro.android58_day10.utils.MyExtendFunction.openDoor

/**
 * Demo Kotlin cơ bản - Android58 Day10
 * Nhập xuất dữ liệu từ bàn phím
 */

// ========== MAIN ==========
fun main() {
    println("╔══════════════════════════════════════╗")
    println("║     DEMO KOTLIN CƠ BẢN - DAY 11      ║")
    println("╚══════════════════════════════════════╝")

//    val wallet = Wallet(100.0)
//
//    val dog = Dog("Buddy")
//    dog.makeSound()
//
//    val cardPayment = CardPayment()
//
//    val cashPayment = CashPayment()
//
//    val demoSealed = DemoSealed.Data("Hello, Sealed Class!")
//    when (demoSealed) {
//        is DemoSealed.Data -> println("Data value: ${demoSealed.value}")
//        is DemoSealed.Object -> println("This is an object")
//        is DemoSealed.Regular -> println("Regular number: ${demoSealed.number}")
//    }
//
//    val demoEnum = DemoEnum.B
//    when (demoEnum) {
//        DemoEnum.A -> println("Enum value: A")
//        DemoEnum.B -> println("Enum value: B")
//        DemoEnum.C -> println("Enum value: C")
//    }
//
//    println("Constants: USER_NAME = ${Constants.USER_NAME}, USER_AGE = ${Constants.USER_AGE}")


//    val demoCar = Car("Toyota", "Camry")
//    demoCar.start()
//    demoCar.openDoor()
//
//    val number = 17
//    println("$number is prime: ${number.isPrime()}")

    ex1()
    ex2()
}

fun ex1() {
    println("\n--- Test BankAccount ---")

    // Test 1: initialBalance = -5 → balance = 0
    val bankAccount = BankAccount("HaiNe", -5.0)
    val balanceAfterInit = bankAccount.getBalance()
    println("Test 1 - initialBalance(-5) → balance=0: ${if (balanceAfterInit == 0.0) "✅ PASS" else "❌ FAIL"}")

    // Test 2: deposit(100) thành công
    val depositResult = bankAccount.deposit(100.0)
    println("Test 2 - deposit(100) thành công: ${if (depositResult) "✅ PASS" else "❌ FAIL"}")

    // Test 3: withdraw(30) thành công
    val withdrawResult = bankAccount.withdraw(30.0)
    println("Test 3 - withdraw(30) thành công: ${if (withdrawResult) "✅ PASS" else "❌ FAIL"}")

    // Test 4: withdraw(100) thất bại (số dư chỉ còn 70)
    val withdrawFail = bankAccount.withdraw(100.0)
    println("Test 4 - withdraw(100) thất bại (số dư không đủ): ${if (!withdrawFail) "✅ PASS" else "❌ FAIL"}")

    // Test 5: deposit(0) thất bại
    val depositZero = bankAccount.deposit(0.0)
    println("Test 5 - deposit(0) thất bại: ${if (!depositZero) "✅ PASS" else "❌ FAIL"}")

    // In statement cuối cùng
    println("\n--- Final Statement ---")
    bankAccount.statement()
}

fun ex2() {
    println("\n--- Test TaskServices ---")

    val sender = ConsoleSender()
    val service = TaskServices(sender)
    val user = User("u1", "HaiNe")

    // Test 1: Tạo task thành công + gửi thông báo
    val t1 = service.createTask(user, "1", "Học Kotlin")
    println("Test 1 - createTask thành công: ${if (t1) "✅ PASS" else "❌ FAIL"}")

    // Test 2: Không cho trùng id
    val t2 = service.createTask(user, "1", "Task trùng id")
    println("Test 2 - createTask trùng id thất bại: ${if (!t2) "✅ PASS" else "❌ FAIL"}")

    // Test 3: Title không được rỗng
    val t3 = service.createTask(user, "2", "")
    println("Test 3 - createTask title rỗng thất bại: ${if (!t3) "✅ PASS" else "❌ FAIL"}")

    // Test 4: markDone thành công
    val t4 = service.markDone("1")
    println("Test 4 - markDone(1) thành công: ${if (t4) "✅ PASS" else "❌ FAIL"}")

    // Test 5: markDone thất bại (id không tồn tại)
    val t5 = service.markDone("999")
    println("Test 5 - markDone(999) thất bại: ${if (!t5) "✅ PASS" else "❌ FAIL"}")

    // Tạo thêm task để test listOpenTask
    service.createTask(user, "3", "Làm bài tập OOP")
    service.createTask(user, "4", "Đọc sách Design Pattern")

    // Test 6: listOpenTask chỉ trả về task chưa hoàn thành
    val openTasks = service.listOpenTask()
    println("Test 6 - listOpenTask (2 open tasks): ${if (openTasks.size == 2) "✅ PASS" else "❌ FAIL"}")
    println("  Open tasks:")
    openTasks.forEach { println("    - [${it.id}] ${it.title}") }
}
