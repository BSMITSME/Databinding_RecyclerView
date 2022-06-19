package com.example.databinding_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databinding_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.activity = this@MainActivity
        setRcv()

    }
    fun btnClick(view: View){ //메서드 참조식일 경우 파라미터에 view 기입 -> 리스너 바인딩 방식일 경우 파라미터 기입 안함 (xml상에서는 "()->"식으로 표기)
        Toast.makeText(this,"ButtonClicK",Toast.LENGTH_LONG).show()
    }
    fun setRcv(){
        val profileAdapter = ProfileAdapter(this) //어뎁터 생성
        binding.mainRcv.layoutManager = LinearLayoutManager(this)//layout구성
        binding.mainRcv.adapter = profileAdapter//어뎁터와 이어주기
        profileAdapter.data = listOf( //데이터 입력하기
            ProfileData("Baby", 2),
            ProfileData("SemiBaby", 6)
        )
        profileAdapter.notifyDataSetChanged()//리스트의 크기와 아이템이 둘 다 변경되는 경우에 사용
    }

}