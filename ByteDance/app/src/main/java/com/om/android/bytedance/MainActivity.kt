package com.om.android.bytedance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.om.android.bytedance.databinding.ActivityMainBinding
import com.om.android.bytedance.models.Component
import com.om.android.bytedance.models.FileComponent
import com.om.android.bytedance.models.FolderComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
        binding.componentList.apply {
            adapter = ComponentAdapter(generateComponents())
            layoutManager = LinearLayoutManager(this.context)
        }
    }

    private fun generateComponents(): List<Component> {
        val fileComponent1 = FileComponent("File1")
        val fileComponent2 = FileComponent("File2")
        val fileComponent3 = FileComponent("File3")
        val folderComponent1 = FolderComponent("Folder1", listOf(fileComponent1))
        val folderComponent3 = FolderComponent("Folder3", listOf(fileComponent2))
        val folderComponent2 = FolderComponent("Folder2", listOf(folderComponent3))
        return listOf(folderComponent1, folderComponent2, fileComponent3)
    }
}