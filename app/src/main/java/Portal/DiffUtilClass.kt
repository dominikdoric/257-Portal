package Portal

import Portal.model.SportTable
import androidx.recyclerview.widget.DiffUtil

class DiffUtilClass(
    private val oldList: List<SportTable>,
    private val newList: List<SportTable>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        TODO("Not yet implemented")
    }

    override fun getNewListSize(): Int {
        TODO("Not yet implemented")
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }
}