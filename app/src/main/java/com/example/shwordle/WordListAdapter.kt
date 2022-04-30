package com.example.shwordle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(
    private val context: Context,
    var dataset: MutableList<String> = mutableListOf<String>()

) : RecyclerView.Adapter<WordListAdapter.ItemViewHolder>() {

    /**
     * Inner class used to store data about each element in the RecyclerView. It inherits from
     * RecyclerView.ViewHolder so it can be used by the RecyclerView.
     */
    // We create references to elements in list_item.xml so we can modify them.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val wordName: TextView = view.findViewById(R.id.word)
        val position: TextView = view.findViewById(R.id.position)
    }

    /**
     * Creates a View to visualize one element in the RecyclerView. We pass in a reference to the
     * [parent] object, in this case MainActivity.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        /**
         * We use an inflater based on the parent (MainActivity) to create the view in the correct
         * position. We then inflate the layout from list_item.xml into that position.
         */
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_words, parent, false)

        // We create and return an ItemViewHolder object using the layout we inflated.
        return ItemViewHolder(adapterLayout)
    }

    /**
     * The function is called whenever the RecyclerView displays a specific element. It provides
     * access to [holder], which is the ItemView holder created to store layout information and
     * a [position] that indicates where the element is in the RecyclerView.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        /**
         * We retrieve the corresponding intersection name from our dataset so it is displayed in
         * the correct position of the RecyclerView
         */
        val item = dataset[position]

        /**
         *  We change the values of the elements in the layout according to the data values. We use
         *  the position parameter to show numbering.
         */
        holder.position.text = (position + 1).toString() + "."
        holder.wordName.text = item
    }

    // Retrieves the amount of data inside our data set.
    override fun getItemCount(): Int = dataset.size
}
