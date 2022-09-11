package com.vassagame.twochairs.domain.reposytory

interface GameRepository {

    fun setOptions(){
    }

    fun getQuestions() : ArrayList<String>{
        return ArrayList()
    }

}