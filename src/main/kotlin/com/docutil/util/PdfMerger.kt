package com.docutil.util

import org.apache.pdfbox.io.MemoryUsageSetting
import org.apache.pdfbox.multipdf.PDFMergerUtility
import java.io.File

object PdfMerger {

    private const val MAX_MEMORY_SIZE = 500L

    fun merge(inputDirectoryPath: String): Unit = File(inputDirectoryPath)
        .listFiles()!!
        .filter { file -> file.extension.toLowerCase() == "pdf" }
        .let { pdfFiles ->
            with(PDFMergerUtility()) {
                val destinationFilePath = getDestinationFilePath(inputDirectoryPath)
                File(destinationFilePath).createNewFile()
                destinationFileName = destinationFilePath
                pdfFiles
                    .sortedBy(File::getName)
                    .forEach(this::addSource)
                println("Merging PDF documents in folder $inputDirectoryPath to $destinationFilePath")
                mergeDocuments(MemoryUsageSetting.setupMixed(MAX_MEMORY_SIZE))
                println("Merged into $destinationFilePath successfully")
            }
        }

    private fun getDestinationFilePath(inputDirectoryPath: String): String = File(inputDirectoryPath)
        .absolutePath
        .plus("/${DateUtils.getFormattedDate()}.pdf")
}
