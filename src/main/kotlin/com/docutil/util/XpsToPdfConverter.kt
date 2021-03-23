package com.docutil.util

import java.io.File

import com.spire.pdf.FileFormat
import com.spire.pdf.PdfDocument

object XpsToPdfConverter {

    fun convert(inputDirectoryPath: String) = File(inputDirectoryPath).run {
        val outputDirectoryPath = "$absolutePath/output-${DateUtils.getFormattedDate()}/"
        File(outputDirectoryPath).mkdir()
        println("Converting XPS files from folder $inputDirectoryPath to PDF files to folder $outputDirectoryPath")
        listFiles()
            ?.filter { file -> file.extension.toLowerCase() == "xps" }
            ?.forEach { file -> convertXpsToPdf(outputDirectoryPath, file) }
        println("Done converting XPS files to PDF files")
        outputDirectoryPath
    }

    private fun convertXpsToPdf(outputDirectoryPath: String, xpsFile: File) = PdfDocument().apply {
        val absolutePath = xpsFile.absolutePath
        loadFromXPS(absolutePath)
        val destinationFilePath = "$outputDirectoryPath/${getFileName(absolutePath)}.pdf"
        println("Converting file '$absolutePath' to PDF...")
        saveToFile(destinationFilePath, FileFormat.PDF)
    }

    private fun getFileName(sourceFilePath: String) = File(sourceFilePath).nameWithoutExtension
}
