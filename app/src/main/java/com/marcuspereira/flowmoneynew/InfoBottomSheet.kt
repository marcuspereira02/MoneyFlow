package com.marcuspereira.flowmoneynew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InfoBottomSheet(
    private val title: String,
    private val description: String,
    private val btnText: String,
    private val onClick : () -> Unit
):BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.info_bottom_sheet,container,false)

        val tvTitle = view.findViewById<TextView>(R.id.tv_title_info_bottom_sheet)
        val tvDescription = view.findViewById<TextView>(R.id.tv_info_description)
        val btnAction = view.findViewById<Button>(R.id.btn_info_delete)
        val btnCancel = view.findViewById<Button>(R.id.btn_info_cancel)

        tvTitle.text = title
        tvDescription.text = description
        btnAction.text = btnText

        btnCancel.setOnClickListener {
            dismiss()
        }

        btnAction.setOnClickListener {
            onClick.invoke()
            dismiss()
        }

        return view
    }
}