package com.madtitan94.expmgr.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.madtitan94.expmgr.R
import com.madtitan94.expmgr.databinding.FragmentDashboardBinding
import com.madtitan94.expmgr.databinding.TransactionBottomsheetBinding

import com.madtitan94.expmgr.utils.TranasctionType

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dashboard, container, false)
        val root: View = binding.root
        // Inflate the layout for this fragment

        binding.fabBottomSheet.setOnClickListener {

            /*val dialog = BottomSheetDialog(requireContext())
*/
            showDialogOne()


        }

        return root
    }



    fun showDialogOne() {

        val dialog = BottomSheetDialog(requireContext())
        val sheetBinding = DataBindingUtil.inflate<TransactionBottomsheetBinding>(
            layoutInflater,
            R.layout.transaction_bottomsheet,
            null,
            false
        )
        dialog.setContentView(sheetBinding.root)

        sheetBinding.addDetailTV.setOnClickListener {
            sheetBinding.detailLayout.visibility = View.VISIBLE
            sheetBinding.addDetailTV.visibility = View.GONE
        }
        //sheetBinding.tvEdit.text = "Hello"
        /*
        dialog.setContentView(R.layout.sample_dialog_one)
        val btnEdit= dialog.findViewById<RelativeLayout>(R.id.rl_edit)
        val btnDelete= dialog.findViewById<RelativeLayout>(R.id.rl_delete)
        val btnAdd= dialog.findViewById<RelativeLayout>(R.id.rl_add)

        btnEdit?.setOnClickListener {
            Toast.makeText(this, "Clicked on Edit", Toast.LENGTH_SHORT).show()
        }
        btnDelete?.setOnClickListener {
            Toast.makeText(this, "Clicked on Delete", Toast.LENGTH_SHORT).show()
        }
        btnAdd?.setOnClickListener {
            Toast.makeText(this, "Clicked on Add", Toast.LENGTH_SHORT).show()
        }*/
        dialog.show()
    }

}