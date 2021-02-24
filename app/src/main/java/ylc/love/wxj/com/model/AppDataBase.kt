package ylc.love.wxj.com.model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ylc.love.wxj.com.base.LifeApplication
import ylc.love.wxj.com.model.dao.BillTypeBeanDao
import ylc.love.wxj.com.model.dao.EventBeanDao
import ylc.love.wxj.com.model.dao.MoodBeanDao

/**
 * @author Administrator
 * @create on 2020/4/12 0012
 * 说明: 数据声明
 */
@Database(
    entities = [DateBean::class,  BillTypeBean::class,MoodBean::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun eventBeanDao(): EventBeanDao
    abstract fun moodBeanDao(): MoodBeanDao
    abstract fun billTypeBeanDao(): BillTypeBeanDao

    companion object {
        val instance = Single.sin
    }

    private object Single {
        val sin: AppDataBase = Room.databaseBuilder(
            LifeApplication.getAppContext(),
            AppDataBase::class.java, "tools_of_life_db"
        ).allowMainThreadQueries().build()
    }
}