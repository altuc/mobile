package com.om.android.bytedance.models

data class FolderComponent(
    override val componentName: String,
    val subComponents: List<Component>,
) : Component(componentName)