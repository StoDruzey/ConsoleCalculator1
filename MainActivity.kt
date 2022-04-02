package com.example.consolecalculator

import java.util.*
val reader = Scanner(System.`in`)

fun main() {
    val num1 = getInt()
    val num2 = getInt()
    val action = getAction()
    val result = calculator(num1, num2, action)
    println("$num1 $action $num2 = $result")
}

fun getInt(): Int {
    println("enter a number: ")
    val num = if(reader.hasNextInt()) {
        reader.nextInt()
    } else {
        print("wrong number, ")
        reader.next()
        getInt()
    }
    return num
}

fun getAction(): String {
    println("enter an action (+, -, *, / )")
    var action: String = reader.next()
    action = when (val act = action.first().toString()) {
        "*", "/", "+", "-" -> act
        else -> {
            print("wrong action, ")
            getAction()
        }
    }
    return action
}

fun calculator(num1: Int, num2: Int, action: String): Int {
    val result = when (action) {
        "*" -> num1 * num2
        "/" -> num1 / num2
        "+" -> num1 + num2
        "-" -> num1 - num2
        else -> calculator(num1, num2, getAction())
    }
    return result
}
