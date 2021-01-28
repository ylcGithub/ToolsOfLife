package ylc.love.wxj.com.model

/**
 *@author YLC-D
 *@create on 2021/1/28 10
 *说明: eventType: 1表示日期时间 2表示记账时间 3表示心情事件
 */
data class EventBean(var eventType: Int, var title: String, var des: String, var date: Long)