package Portal

import Portal.model.SportTable
import androidx.recyclerview.widget.DiffUtil

class DiffUtilClass(
    private val oldList: List<SportTable>,
    private val newList: List<SportTable>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].naslov == newList[newItemPosition].naslov
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].naslov != newList[newItemPosition].naslov -> {
                false
            }
            oldList[oldItemPosition].clanak != newList[newItemPosition].clanak -> {
                false
            }
            else -> true
        }
    }
}