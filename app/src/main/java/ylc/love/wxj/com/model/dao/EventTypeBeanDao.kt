package ylc.love.wxj.com.model.dao

import androidx.room.Dao
import androidx.room.Query
import ylc.love.wxj.com.model.EventTypeBean

/**
 * @author Administrator
 * @create on 2021/1/31 0031
 * 说明:
 */
@Dao
interface EventTypeBeanDao : BaseDao<EventTypeBean> {

    @Query("select * from EventTypeBean where id = :id")
    fun selectTypeById(id: Int?): EventTypeBean?

    @Query("select * from EventTypeBean where type = :type")
    fun selectTypeByStr(type: String?): EventTypeBean?

    @Query("select * from EventTypeBean")
    fun selectAll(): List<EventTypeBean>
}