package com.example.databindingsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingsample.databinding.PlayerRowBinding


//RecyclerView.Adapter 'den extend edecek.


class PlayerAdapter(private val context: Context, private val list: MutableList<Player>?) : RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    //Adapter oluşturulduğunda ViewHolder’ı başlatıyor.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: PlayerRowBinding = DataBindingUtil.inflate(inflater, R.layout.player_row,parent,false)
        return MyViewHolder(binding)
    }

    //Listemizin eleman sayısını veriyor.
    override fun getItemCount(): Int {
        if(list == null){
            return 0
        }
        return list.size
    }

    //onCreateViewHolder’dan dönen verilerin bağlama işlemini gerçekleştiriyor.
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.player = list?.get(position)
    }

    //RecyclerView.ViewHolder extend edecektir.
    class MyViewHolder(val itemBinding: PlayerRowBinding) : RecyclerView.ViewHolder(itemBinding.root){

        private var binding : PlayerRowBinding? = null

        init {
            this.binding = itemBinding
        }

    }

}