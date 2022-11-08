package br.com.mobile.alunosemgrupo


import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView



class RankingAdapter (val ranking : List<RankingBuilder>) : RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {


    override fun getItemCount(): Int = ranking.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ranking_item,parent,false )
        return RankingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {

        val context = holder.itemView.context
        val place = ranking[position]
        holder.txtUser.text = place.user
        holder.position.text = place.position
        holder.quantity.text = place.quantity



    }
   class  RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
val txtUser : TextView
val position : TextView
val quantity  : TextView

init {
    txtUser = itemView.findViewById(R.id.txt_user)
    position = itemView.findViewById(R.id.txt_icon)
    quantity = itemView.findViewById(R.id.txt_points)
}

}}

fun View.oval(@ColorInt color: Int): ShapeDrawable{
    val oval = ShapeDrawable(OvalShape())
    with(oval){
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}