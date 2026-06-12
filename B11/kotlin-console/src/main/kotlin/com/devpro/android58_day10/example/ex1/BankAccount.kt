package com.devpro.android58_day10.example.ex1

class BankAccount (private val owner:String, initBalance:Double){
    private var balance = if (initBalance >= 0) initBalance else 0.0

    fun deposit(amount: Double): Boolean {
        if (amount <= 0 ) return false
        balance += amount
        return true
    }

    fun withdraw(amount: Double): Boolean {
        if (amount <= 0 || amount > balance) return false
        balance -= amount
        return true
    }

    fun getBalance(): Double {
        println("Owner: $owner, Balance: $balance")
        return balance
    }

    fun statement(): String {
        val info = "=== Bank Statement ===\nOwner: $owner\nBalance: $balance\n======================"
        println(info)
        return info
    }
}