package no.erlendhall.erlend.brdskalaen


import android.app.Fragment;
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.annotations.Nullable


class HelkornFragment : Fragment() {
    companion object {

        @JvmStatic
        fun newInstance() : HelkornFragment {
            return HelkornFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_helkorn, container, false)
    }

}