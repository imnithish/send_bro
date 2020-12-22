package com.imnstudios.sendbro.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.imnstudios.sendbro.data.models.Media
import com.imnstudios.sendbro.databinding.FragmentImagesBinding
import com.imnstudios.sendbro.ui.adapters.MediaAdapter

class ImagesFragment : Fragment() {
    private var _binding: FragmentImagesBinding? = null
    private val binding get() = _binding!!

    lateinit var mediaAdapter: MediaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupRecyclerView() {
        mediaAdapter = MediaAdapter()
        binding.imageGallery.apply {
            adapter = mediaAdapter
//            layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        mediaAdapter.setOnItemClickListener {
//            val bundle = Bundle().apply {
//                putSerializable("media", it)
//            }
//            findNavController().navigate(
//              destination,
//                bundle
//            )
            Toast.makeText(requireContext(), "${it.uri}", Toast.LENGTH_SHORT).show()
        }

        val l = listOf(
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/mobile/munnar20180720141650_202_1.jpg"
            ),
            Media(
                "https://www.keralatourism.org/images/destination/large/munnar20140104114824_202_1.jpg"
            ),

            )
        mediaAdapter.differ.submitList(l)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}