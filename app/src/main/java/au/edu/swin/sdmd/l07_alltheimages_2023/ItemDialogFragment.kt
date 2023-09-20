package au.edu.swin.sdmd.l07_alltheimages_2023

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.edu.swin.sdmd.l07_alltheimages_2023.databinding.FragmentItemDialogBinding

// TODO: Customize parameter argument names
const val ARG_ITEM = "location"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    ItemDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class ItemDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentItemDialogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // This is for a list -- we don't want this
        /*activity?.findViewById<RecyclerView>(R.id.list)?.layoutManager =
            LinearLayoutManager(context)
        activity?.findViewById<RecyclerView>(R.id.list)?.adapter =
            arguments?.getInt(ARG_ITEM_COUNT)?.let { ItemAdapter(it) }*/
        arguments?.let {
            // I'm ignoring the deprecation here
            val data = it.getParcelable<Location>(ARG_ITEM)
            binding.mbsTitle.text = data?.name.toString()
            binding.mbsLatitude.text = data?.latitude.toString()
        }

    }




    companion object {

        // TODO: Customize parameters
        fun newInstance(item: Location): ItemDialogFragment =
            ItemDialogFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_ITEM, item)
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}