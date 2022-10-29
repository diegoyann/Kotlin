package br.com.mobile.alunosemgrupo

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import br.com.mobile.alunosemgrupo.Ranking
import kotlinx.android.synthetic.main.ranking_item.view.*
import org.w3c.dom.Text


class RankingAdapter (val ranking : List<RankingBuilder>) : RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {


    override fun getItemCount(): Int = ranking.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ranking_item,parent,false )
        return RankingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {

        val context = holder.itemView.context
        val place = ranking[position]



    }
   class  RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(ranking: Ranking) {
            with(ranking){
                //val hash = user.hashCode()
                itemView.txt_user.text = user.first().toString()
                itemView.txt_icon.background = itemView.oval(Color.rgb(0,0,0))
                itemView.txt_user.text = user
                itemView.txt_date.text = date
                itemView.txt_icon.text = position
                itemView.txt_points.text = quantity
                itemView.txt_user.setTypeface(Typeface.DEFAULT, if (newRank) BOLD else NORMAL)
                itemView.txt_points.setTypeface(Typeface.DEFAULT, if (newRank) BOLD else NORMAL)
                itemView.txt_date.setTypeface(Typeface.DEFAULT, if (newRank) BOLD else NORMAL)
            }
        }
    }
}
fun View.oval(@ColorInt color: Int): ShapeDrawable{
    val oval = ShapeDrawable(OvalShape())
    with(oval){
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}