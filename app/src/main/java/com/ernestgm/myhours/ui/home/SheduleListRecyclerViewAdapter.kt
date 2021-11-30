package com.ernestgm.myhours.ui.home

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.ernestgm.myhours.databinding.SheduleListItemBinding
import com.ernestgm.myhours.databinding.SheduleListItemInactiveBinding

import com.ernestgm.myhours.ui.home.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */

private const val INACTIVE = 0
private const val ACTIVE = 1

class SheduleListRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<SheduleListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return if (viewType == ACTIVE) {
            ViewHolder(
                viewType,
                SheduleListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            ViewHolder(
                viewType,
                SheduleListItemInactiveBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            ACTIVE
        } else {
            INACTIVE
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(viewType: Int, binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var idView: TextView
        var contentView: TextView

        init {
            if (viewType == ACTIVE) {
                binding as SheduleListItemBinding
                idView = binding.itemNumber
                contentView = binding.content
            } else {
                binding as SheduleListItemInactiveBinding
                idView = binding.itemNumber
                contentView = binding.content
            }
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}