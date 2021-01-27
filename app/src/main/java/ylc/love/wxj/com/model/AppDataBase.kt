package ylc.love.wxj.com.model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ylc.love.wxj.com.base.LifeApplication
import ylc.love.wxj.com.model.dao.DateBeanDao

/**
 * @author Administrator
 * @create on 2020/4/12 0012
 * 说明: 数据声明
 */
@Database(entities = [DateBean::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun dateBeanDao(): DateBeanDao

    companion object {
        val instance: AppDataBase
            get() = Room.databaseBuilder(
                LifeApplication.getAppContext(),
                AppDataBase::class.java, "tools_of_life_db"
            ).allowMainThreadQueries().build()
    }
}