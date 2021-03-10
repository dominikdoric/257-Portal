package Portal

import Portal.database.table.ZabavaTable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    val selected = MutableLiveData<ZabavaTable>()

    fun select(zabava: ZabavaTable){
        selected.value = zabava
    }
}