package com.om.android.bytedance.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.om.android.bytedance.databinding.RowItemFileComponentBinding
import com.om.android.bytedance.databinding.RowItemFolderComponentBinding
import com.om.android.bytedance.models.Component
import com.om.android.bytedance.models.FolderComponent
import java.util.LinkedList

class ComponentAdapter(private val components: List<Component>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        val list = mutableListOf<Component>()
        val queue = LinkedList<Component>()
        for (component in components) {
            queue.add(component)
        }

        while (!queue.isEmpty()) {
            val component = queue.poll()
            list.add(component)
            if (component is FolderComponent) {
                for (subComponent in component.subComponents) {
                    queue.add(subComponent)
                }
            }
        }
        
        return list.size
    }

    inner class FileComponentViewHolder(private val binding: RowItemFileComponentBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    inner class FolderComponentViewHolder(private val binding: RowItemFolderComponentBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    companion object {
        private const val VIEW_TYPE_FILE = 1
        private const val VIEW_TYPE_FOLDER = 2
    }
}