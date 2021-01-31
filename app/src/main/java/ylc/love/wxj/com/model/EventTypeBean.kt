package ylc.love.wxj.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Administrator
 * @create on 2021/1/31 0031
 * 说明:
 */
@Entity
data class EventTypeBean(
    @PrimaryKey
    val id:Int,
    @ColumnInfo
    val type:String
)