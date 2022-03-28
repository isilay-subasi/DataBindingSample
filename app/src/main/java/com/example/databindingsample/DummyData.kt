package com.example.databindingsample

object DummyData {

    fun getDummyData() : List<Player>{

        val itemModel1=Player(R.drawable.facebook,"facebook")
        val itemModel2=Player(R.drawable.instagram,"instagram")
        val itemModel3=Player(R.drawable.linkedin,"linkedin")
        val itemModel4=Player(R.drawable.twitter,"twitter")
        val itemModel5=Player(R.drawable.youtube,"youtube")
        val itemModel6=Player(R.drawable.telegram,"telegram")
        val itemModel7=Player(R.drawable.snapchat,"snapchat")
        val itemModel8=Player(R.drawable.whatsapp,"whatsapp")
        val itemModel9=Player(R.drawable.skype,"skype")

        val itemList: ArrayList<Player> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)
        itemList.add(itemModel5)
        itemList.add(itemModel6)
        itemList.add(itemModel7)
        itemList.add(itemModel8)
        itemList.add(itemModel9)


        return itemList
    }


}