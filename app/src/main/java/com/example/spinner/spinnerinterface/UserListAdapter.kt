package com.example.spinner.spinnerinterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class UserListAdapter (var userArray: ArrayList<UserModel>, var clickInterface: ClickInterface ) : BaseAdapter() {
    override fun getCount(): Int {
        return userArray.size
    }

    override fun getItem(position: Int): UserModel {
        return userArray[position]
    }

    override fun getItemId(position: Int): Long {
        return 767
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_base_adapter, parent, false)

        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvCounter: TextView = view.findViewById(R.id.tv_Counter)
        var ivEdit = view.findViewById<ImageView>(R.id.ivEdit)
        var ivDelete = view.findViewById<ImageView>(R.id.ivDelete)
        var ibRemove = view.findViewById<ImageButton>(R.id.ib_remove)
        var ibAdd = view.findViewById<ImageButton>(R.id.ib_add)

        tvName.setText(userArray[position].name)
        tvCounter.setText(userArray[position].qty.toString())
        ivEdit.setOnClickListener {
            clickInterface.editClick(position)
        }
        ivDelete.setOnClickListener {
            clickInterface.deleteClick(position)
        }

        ibRemove.setOnClickListener {
            clickInterface.removeCounter(position)

        }
        ibAdd.setOnClickListener {
            clickInterface.addCounter(position)
        }
        return view
    }}




