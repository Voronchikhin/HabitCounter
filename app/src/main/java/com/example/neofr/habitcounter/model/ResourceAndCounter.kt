package com.example.neofr.habitcounter.model

import com.example.neofr.habitcounter.model.dto.Resource
import com.example.neofr.habitcounter.model.dto.ResourceCounter

data class ResourceAndCounter (
    val resource: Resource,
    val resourceCounter: ResourceCounter
)