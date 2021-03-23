package com.docutil.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun getFormattedDate(): String = SimpleDateFormat("dd-MM-yyyy").format(Date())
}
