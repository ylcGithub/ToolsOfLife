package ylc.love.wxj.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *@author YLC-D
 *@create on 2021/1/27 12
 *说明:日期时间 数据表
 */
@Entity
data class DateBean(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var des: String,
    @ColumnInfo
    var date: Long,
    @ColumnInfo
    var createDate:Long
)
