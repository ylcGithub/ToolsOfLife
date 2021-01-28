package ylc.love.wxj.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *@author YLC-D
 *@create on 2021/1/28 10
 *说明:
 */
@Entity
data class BillTypeBean(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo
    val type:String
)