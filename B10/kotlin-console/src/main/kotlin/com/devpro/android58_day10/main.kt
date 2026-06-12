package com.devpro.android58_day10

/**
 * Demo Kotlin cơ bản - Android58 Day10
 * Nhập xuất dữ liệu từ bàn phím và Giải bài tập về nhà
 */

// ========== MAIN ==========
fun main() {
    println("╔══════════════════════════════════════╗")
    println("║     DEMO KOTLIN CƠ BẢN - DAY 10      ║")
    println("╚══════════════════════════════════════╝")

//    val demoString2: String = "Hello, Kotlin!" // Cách khai báo có kiểu dữ liệu rõ ràng
//    var demoString = "Hello, Kotlin!"
//    demoString = "Hello, Android!" // Lỗi: Val cannot be reassigned
//
//    val demoInt = 42
//    val demoDouble = 3.14
//    val demoBoolean = true
//
////    println("Demo String: "+demoString)
//    println("Demo String: $demoString")
//
//    //Null safety
//    var nonNullString: String? = "I am not null"
////    nonNullString = null
//
//    println("Demo String: ${nonNullString?.length}")
//
//    val elvisString = nonNullString ?: "Default Value"
//    println("Elvis String: $elvisString")
//
//    println("ADD: ${add(5, 20)}")
//
//    println(greet(name = "Đạt", greeting = "Xin chào"))
//
//    if (nonNullString != null) {
//        println("Length: ${nonNullString.length}")
//    } else {
//        println("String is null")
//    }
//
//    // Sử dụng if để tìm số lớn nhất
//    val a = 10
//    val b = 20
//    var maxNumber = if (a > b) a else b
//
//    when(maxNumber) {
//        in 0..10 -> println("Max number is between 0 and 10")
//        in 11..20 -> println("Max number is between 11 and 20")
//        else -> println("Max number is greater than 20")
//    }
//
//    // Sử dụng when để đánh giá điểm số
//    val scope = 99
//    val grade = when(scope){
//        in 90..100 -> "A"
//        in 80..89 -> "B"
//        in 70..79 -> "C"
//        in 60..69 -> "D"
//        else -> "F"
//    }
//
//    println("Grade: $grade")

//    println("isLeapYear: ${isLeapYear(2026)}")

//    tinhSoDien()

//    demoList()

//    demoFor()
//    highOrderFunctionCollection()

    print("from: ")
    val from: Int = readLine()?.toIntOrNull() ?: 0

    print("to: ")
    val to: Int = readLine()?.toIntOrNull() ?: 0

    val listPrime = (from..to).filter { isPrime(it) }
    println("List prime [$from,$to]: $listPrime")

    println("\n╔══════════════════════════════════════╗")
    println("║        BÀI TẬP VỀ NHÀ - DAY 10       ║")
    println("╚══════════════════════════════════════╝")

    // --- Test Bài 1 ---
    println("👉 Bài 1: Compress chuỗi")
    println("aaabbcaaa -> ${compressString("aaabbcaaa")}")
    println("abc -> ${compressString("abc")}")
    println("aabbcc -> ${compressString("aabbcc")}")
    println("----------------------------------------")

    // --- Test Bài 2 ---
    println("👉 Bài 2: Tính giai thừa")
    val n = 5
    println("Giai thừa của $n! = ${tinhGiaiThua(n)}")
    println("----------------------------------------")

    // --- Test Bài 3 ---
    println("👉 Bài 3: Tìm số lớn thứ nhì")
    val listNumbers = listOf(10, 5, 8, 10, 9, 2)
    println("List gốc: $listNumbers")
    println("Số lớn thứ nhì: ${findSecondLargest(listNumbers)}")
    println("----------------------------------------")

    // --- Test Bài 4 ---
    println("👉 Bài 4: Chuỗi liên tiếp tăng dài nhất")
    val sequence = listOf(1, 3, 5, 4, 7, 8, 9, 2)
    println("Mảng: $sequence")
    println("Độ dài chuỗi tăng dài nhất: ${longestIncreasingSubarray(sequence)}")
    println("----------------------------------------")

    // --- Test Bài 5 ---
    println("👉 Bài 5: Chuyển số La Mã thành số nguyên")
    println("XII -> ${romanToInt("XII")}")
    println("IX -> ${romanToInt("IX")}")
    println("LVIII -> ${romanToInt("LVIII")}")
    println("----------------------------------------")
}

private fun highOrderFunctionCollection() {
    val number = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val number2 = listOf(1, 5, 3, 4, 5, 3, 5, 8, 2, 10)
    println("old: $number")

    println("new: ${number.map { it * 2 }}")

    val filter = number.filter { it % 2 == 0 }
    println("Filter: $filter")
    val filter2 = number.filter { it % 2 == 0 }.filter { it > 5 }
    println("Filter2: $filter2")

    val max = number.maxOrNull()
    val min = number.minOrNull()

    println("Max: $max, Min: $min")

    val sort = number2.sorted()
    val reversed = number.reversed()
}

private fun demoFor() {
    val fruitList = mutableListOf("Táo", "Cam", "Xoài")

    for (fruit in fruitList) {
        println(fruit)
    }

    for (i in fruitList.indices) {
        println("fruit index $i: ${fruitList[i]}")
    }

    for (i in 1..5) {
        println(i)
    }

    for (i in 1 until 5) {
        println(i)
    }

    for (i in 5 downTo 1) {
        println(i)
    }

    for (i in 1..10 step 2) {
        println(i)
    }
}

private fun demoList() {
    val helloList = listOf("Hello", "Im", "Hai")
    println("Immutable list: $helloList")

    val fruitList = mutableListOf("Táo", "Cam", "Xoài")
    fruitList.add("Bưởi")
    println("Mutable list: $fruitList")

    val firstItemHelloList = helloList.first()
    val lastItemHello = helloList.last()
    val firstItemFruitList = fruitList.getOrNull(100)

    val fruitSubList = fruitList.subList(0, 2)
    println("fruitSubList: $fruitSubList")

    val fruitDrop = fruitList.drop(2)
    println("fruitDrop: $fruitDrop")

    val fruitTakeLast = fruitList.takeLast(2)
    println("fruitTakeLast: $fruitTakeLast")

    val checkFruitEmpty = fruitList.isEmpty()
}

private fun tinhSoDien() {
    print("Nhập số điện: ")
    val kwh: Int? = readLine()?.toIntOrNull()
    if (kwh == null) {
        println("Số điện không hợp lệ!")
        return
    }

    val total = when {
        kwh <= 0 -> 0
        kwh <= 50 -> kwh * 1984L
        kwh <= 100 -> (50 * 1984L) + ((kwh - 50) * 2050)
        kwh <= 200 -> (50 * 1984L) + (50 * 2050) + ((kwh - 100) * 2380L)
        kwh <= 300 -> (50 * 1984L) + (50 * 2050) + (100 * 2380L) + ((kwh - 200) * 2998L)
        kwh <= 400 -> (50 * 1984L) + (50 * 2050) + (100 * 2380L) + (100 * 2998L) + ((kwh - 300) * 3350L)
        else -> (50 * 1984L) + (50 * 2050) + (100 * 2380L) + (100 * 2998L) + (100 * 3350L) + ((kwh - 400) * 3460L)
    }

    val result = (total * 1.08).toLong()
    println("Tiền điện (bao gồm VAT): $result")
}

fun add(a: Int, b: Int) = a + b

fun greet(name: String = "Hải", greeting: String? = null): String {
    return "${greeting ?: ""}, $name!"
}

// Sửa lại logic năm nhuận chuẩn (không chia hết cho 100 HOẶC chia hết cho 400)
fun isLeapYear(year: Int): Boolean = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0

fun isPrime(number: Int): Boolean {
    if (number < 2) return false
    for (i in 2..Math.sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) return false
    }
    return true
}

// =============================================================================
// PHẦN GIẢI BÀI TẬP VỀ NHÀ
// =============================================================================

// Bài 1: Compress chuỗi eg: "aaabbcaaa" -> "a3b2ca3"
fun compressString(input: String): String {
    if (input.isEmpty()) return ""

    val result = StringBuilder()
    var count = 1

    for (i in 0 until input.length - 1) {
        if (input[i] == input[i + 1]) {
            count++
        } else {
            result.append(input[i])
            if (count > 1) result.append(count)
            count = 1
        }
    }

    result.append(input.last())
    if (count > 1) result.append(count)

    return result.toString()
}

// Bài 2: Tính giai thừa của một số nguyên dương n (n!)
fun tinhGiaiThua(n: Int): Long {
    if (n < 0) return 0
    var giaThua = 1L
    for (i in 1..n) {
        giaThua *= i
    }
    return giaThua
}

// Bài 3: Tìm số lớn thứ nhì trong list, không sử dụng hàm có sẵn
fun findSecondLargest(list: List<Int>): Int? {
    if (list.size < 2) return null

    var firstMax: Int? = null
    var secondMax: Int? = null

    for (num in list) {
        if (firstMax == null || num > firstMax) {
            secondMax = firstMax
            firstMax = num
        } else if (num < firstMax && (secondMax == null || num > secondMax)) {
            secondMax = num
        }
    }
    return secondMax
}

// Bài 4: Tìm độ dài chuỗi liên tiếp tăng dài nhất
fun longestIncreasingSubarray(arr: List<Int>): Int {
    if (arr.isEmpty()) return 0

    var maxLen = 1
    var currentLen = 1

    for (i in 1 until arr.size) {
        if (arr[i] > arr[i - 1]) {
            currentLen++
        } else {
            if (currentLen > maxLen) {
                maxLen = currentLen
            }
            currentLen = 1
        }
    }
    return if (currentLen > maxLen) currentLen else maxLen
}

// Bài 5: Chuyển số La Mã thành số nguyên
fun romanToInt(s: String): Int {
    val romanMap = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50,
        'C' to 100, 'D' to 500, 'M' to 1000
    )

    var total = 0
    var i = 0

    while (i < s.length) {
        val currentVal = romanMap[s[i]] ?: 0

        if (i + 1 < s.length) {
            val nextVal = romanMap[s[i + 1]] ?: 0
            if (currentVal < nextVal) {
                total += (nextVal - currentVal)
                i += 2
                continue
            }
        }

        total += currentVal
        i++
    }
    return total
}