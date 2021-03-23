package com.docutil.util

import java.io.File

object PathUtils {

    fun getDestinationDirectoryPath(sourceFilePath: String): String = File(sourceFilePath).parentFile.absolutePath
}
