package ylc.love.wxj.com.model.dao

import androidx.room.Dao
import androidx.room.Query
import ylc.love.wxj.com.model.EventBean

/**
 * @author YLC-D
 * @create on 2020/10/26 16
 * 说明:
 */
@Dao
interface EventBeanDao : BaseDao<EventBean> {
    /**
     * 根据用户id查找用户信息
     * @param id id
     */
    @Query("select * from EventBean where id = :id")
    fun selectById(id: Long): EventBean?

    @Query("select * from EventBean")
    fun selectAll(): List<EventBean>
}