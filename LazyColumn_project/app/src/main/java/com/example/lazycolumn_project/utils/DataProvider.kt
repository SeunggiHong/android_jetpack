package com.example.lazycolumn_project.utils

data class UserModel(
    var userPhoto: String  = "https://image.flaticon.com/icons/png/512/4874/4874907.png",
    var userName : String  = "seunggiHong",
    var userEmail: String? = "tmdrl1026@naver.com",
    var userPhone: String? = "010-1234-4552"
)


object DataProvider {
    val userList = List<UserModel>(200) { UserModel() }
}