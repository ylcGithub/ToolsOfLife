package ylc.love.wxj.com.utils

import ylc.love.wxj.com.model.AppDataBase

/**
 * @author Administrator
 * @create on 2021/1/31 0031
 * 说明:
 */
object EventTypeUtil {

    val dao = AppDataBase.instance.eventTypeBeanDao()
    fun getType(typeString: String?): Int {
        return dao.selectTypeByStr(typeString)?.id ?: 1
    }

    fun getTypeString(type: Int?): String {
        return dao.selectTypeById(type)?.type ?: ""
    }
}