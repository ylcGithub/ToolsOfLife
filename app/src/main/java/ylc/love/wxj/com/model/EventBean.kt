package ylc.love.wxj.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *@author YLC-D
 *@create on 2021/1/27 12
 *说明:日期时间 数据表
 */
@Entity
data class EventBean(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    //事件类型
    @ColumnInfo
    val type: Int,
    @ColumnInfo
    var title: String?,
    @ColumnInfo
    var des: String?,
    @ColumnInfo
    var date: Long,
    @ColumnInfo
    var createDate: Long,
    //账单类型
    @ColumnInfo
    var billType: String? = null,
    //账单金额
    @ColumnInfo
    var amount: Float? = null,

    //还需要多久到这个纪念日
    var needDay: Int = 0,
    //距离这个纪念日已经多少天了
    var goneDay: Int = 0,
)
