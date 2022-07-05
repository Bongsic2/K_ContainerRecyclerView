package org.techtown.k_containerrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.k_containerrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data: MutableList<Memo> = loadData()

        // 어댑터 생성하고 어댑터의 listData 변수에 생성한 데이터 목록 저장
        var adapter = CustomAdapter()
        adapter.listData = data


        // recyclerView 위젯의 adapter 속성에 생성할 어댑터 연결
        binding.recyclerView.adapter = adapter


        // 화면에 보여주는 형태를 결정하는 레이아웃 매니저저
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    // MutableList<Memo>를 반환하는 loadData(메서드)
    fun loadData(): MutableList<Memo> {
        val data: MutableList<Memo> = mutableListOf()
        for (no in 1..100) {
            val title = "이것이 안드로이드다 ${no}"
            // 스마트폰의 현재 시간
            val date = System.currentTimeMillis()
            var memo = Memo(no, title, date)
            data.add(memo)
        }
        return data
    }
}