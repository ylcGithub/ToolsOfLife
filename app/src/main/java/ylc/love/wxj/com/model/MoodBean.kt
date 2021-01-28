package ylc.love.wxj.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *@author YLC-D
 *@create on 2021/1/27 12
 *说明:心情 数据表
 */
@Entity
data class MoodBean(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var des: String,
    @ColumnInfo
    var crateDate: Long
)