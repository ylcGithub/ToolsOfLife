package ylc.love.wxj.com.ui.create

import androidx.lifecycle.MutableLiveData
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.expand.toast
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.EventBean
import ylc.love.wxj.com.utils.EventTypeUtil
import ylc.love.wxj.com.utils.LogUtil

/**
 *@author YLC-D
 *@create on 2021/1/28 10
 *说明:
 */
class CreateEventViewModel : BaseViewModel() {
    val eventTitle: MutableLiveData<String> = MutableLiveData()
    val eventType: MutableLiveData<String> = MutableLiveData()
    val isBillType:MutableLiveData<Boolean> = MutableLiveData(false)
    val billType: MutableLiveData<Int> = MutableLiveData()
    val eventDate: MutableLiveData<Long> = MutableLiveData()
    val eventDes: MutableLiveData<String> = MutableLiveData()
    val saveState: MutableLiveData<Boolean> = MutableLiveData()

    fun saveEvent() {
        if (eventTitle.value == null) {
            "请填写事件标题".toast()
            return
        }
        if (eventDate.value == null) {
            "请选择事件时间".toast()
            return
        }

        insertBean()
    }

    private fun insertBean() = runOnThread(work = {
        val eventBeanDao = AppDataBase.instance.eventBeanDao()
        val currMill = System.currentTimeMillis()
        val bean = EventBean(
            currMill,
            EventTypeUtil.getType(eventType.value),
            eventTitle.value,
            eventDes.value,
            eventDate.value ?: currMill,
            currMill
        )
        val insert = eventBeanDao.insert(bean)
        saveState.postValue(insert > 0)
    }, catch = { e -> LogUtil.log(e.message.toString()) })

}