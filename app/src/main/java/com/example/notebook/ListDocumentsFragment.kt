package com.example.notebook

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.notebook.databinding.FragmentListDocumentsBinding
import com.example.notebook.utils.APP_ACTIVITY

class ListDocumentsFragment : Fragment() {

    private var _binding: FragmentListDocumentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListDocumentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SearchView font nunito_bold.
        val typeface = ResourcesCompat.getFont(requireContext(), R.font.nunito_bold)
        binding.searchView.setTypeFace(typeface)

        binding.fab.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_listDocumentsFragment_to_detailDocumentFragment)
        }
    }

    // SearchView custom font in android.
    private fun SearchView.setTypeFace(typeface: Typeface?) {
        val id = context.resources.getIdentifier("android:id/search_src_text", null, null)
        val searchText = binding.searchView.findViewById(id) as TextView
        searchText.typeface = typeface
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}