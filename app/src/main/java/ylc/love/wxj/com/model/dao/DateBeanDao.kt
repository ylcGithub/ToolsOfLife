package ylc.love.wxj.com.model.dao

import androidx.room.Dao
import androidx.room.Query
import ylc.love.wxj.com.model.DateBean

/**
 * @author YLC-D
 * @create on 2020/10/26 16
 * 说明:
 */
@Dao
interface DateBeanDao:BaseDao<DateBean> {
    /**
     * 根据用户id查找用户信息
     * @param userId 用户id
     */
    @Query("select * from DateBean where id = :id")
    fun selectById(id: Long): DateBean?
}