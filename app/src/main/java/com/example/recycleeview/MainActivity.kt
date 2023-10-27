package com.example.recycleeview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView : RecyclerView
    lateinit var animeList : ArrayList<Name>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.RV)
        val image = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8
        )
        val heading  = arrayOf(
            "Demon Slayer",
            "Tokyo Revengers",
            "Death Note",
            "One Punch Man",
            "Dragon Ball z",
            "One Piece",
            "Jujutsu Kaisen",
            "Naruto"
        )
        val discription = arrayOf(
            "Its based on how a boy named tanjiro kamado becomes a demon slayer and how he fights with demons to save his sister",
            "In this master piece a boy has the ability to travel into the past. ",
            "This anime is based on a book , on which whose name is written shall die.",
            "This is based on a man who gains the power to kill anyone with just one punch.",
            "In this anime the main character is a saiyan who has the power to destroy the whole universe, but he saves it multiple times.",
            "The story follows the adventures of Monkey D. Luffy and his crew, the Straw Hat Pirates, where he explores the Grand Line in search of the mythical treasure known as One Piece to become the new King of the Pirates.",
            "The story follows high school student Yuji Itadori as he joins a secret organization of Jujutsu Sorcerers in order to kill a powerful Curse named Ryomen Sukuna, of whom Yuji becomes the host.",
            "The story is told of Naruto Uzumaki, a young ninja who seeks recognition from his peers and dreams of becoming the Hokage, the leader of his village."
        )
        val content = arrayOf(
            getString(R.string.item1),
            getString(R.string.item2),
            getString(R.string.item3),
            getString(R.string.item4),
            getString(R.string.item5),
            getString(R.string.item6),
            getString(R.string.item7),
            getString(R.string.item8)
        )
        myRecyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        animeList = ArrayList<Name>()
        for(i in image.indices){
            val anime = Name(heading[i],image[i],discription[i])
            animeList.add(anime)
        }
        val adap = MyAdapter(animeList,this)
        myRecyclerView.adapter = adap
        adap.setOnItemClickListener(object : MyAdapter.onClickListner{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("heading",heading[position])
                intent.putExtra("image",image[position])
                intent.putExtra("description",content[position])
                startActivity(intent)
            }
        })
    }
}