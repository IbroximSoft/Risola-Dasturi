package uz.ibrohim.risola.language

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import uz.ibrohim.risola.R

class LanguageAdapter(private val context: Activity, private val arrayList: ArrayList<LanguageList>):
    ArrayAdapter<LanguageList>(context, R.layout.language_item,arrayList) {

    @SuppressLint("InflateParams", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.language_item, null)

        val imageView: ImageView = view.findViewById(R.id.language_img)
        val textView: TextView = view.findViewById(R.id.language_text)
        imageView.setImageResource(arrayList[position].imageId)
        textView.text = arrayList[position].text

        return view
    }
}