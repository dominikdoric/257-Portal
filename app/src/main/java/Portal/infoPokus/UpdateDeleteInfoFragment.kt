package Portal.infoPokus

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.update_delete_info_fragment.view.*

@AndroidEntryPoint
class UpdateDeleteInfoFragment: Fragment() {

    private val args by navArgs<UpdateDeleteInfoFragmentArgs>()
    private val infoViewModel: InfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_info_fragment,container,false)

        view.gumbUpdateInfo.setOnClickListener {
            updateItemInfo()
        }

        view.gumbDeleteInfo.setOnClickListener {
            deleteItemInfo()
        }

        return view
    }

    private fun deleteItemInfo() {
        TODO("Not yet implemented")
    }

    private fun updateItemInfo() {
        TODO("Not yet implemented")
    }

}