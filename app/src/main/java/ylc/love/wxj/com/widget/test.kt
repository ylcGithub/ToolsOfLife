package ylc.love.wxj.com.widget

import ylc.love.wxj.com.utils.DateUtils
import ylc.love.wxj.com.utils.LogUtil
import java.util.*

/**
 *@author YLC-D
 *@create on 2021/1/29 11
 *说明:
 */
fun main() {
    val time1 = DateUtils.getDateFromStr("2021-01-29 23:55:55","yyyy-MM-dd")
    val time2 = DateUtils.getDateFromStr("2022-01-28","yyyy-MM-dd")
    val diff = (time2 - time1)/(24*60*60*1000)
    println(diff.toInt())
}