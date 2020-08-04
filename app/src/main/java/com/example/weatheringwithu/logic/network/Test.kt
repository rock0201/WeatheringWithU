package com.example.weatheringwithu.logic.network

interface study{
    fun doHomeWord()
    fun doClass()
}
fun main(){
    doStudy(object :study{//匿名内部类的写法
        override fun doHomeWord() {
            println("do home")
        }

        override fun doClass() {
           println("do class")
        }

    })
}

fun doStudy(study: study){
    study.doHomeWord()
    study.doClass()
}