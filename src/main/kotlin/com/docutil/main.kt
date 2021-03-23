package com.docutil

import com.docutil.util.PdfMerger
import com.docutil.util.XpsToPdfConverter

fun main(args: Array<String>) =
    if (args.isEmpty()) println("Fen esm el folder yasta?")
    else PdfMerger.merge(XpsToPdfConverter.convert(args[0]))
