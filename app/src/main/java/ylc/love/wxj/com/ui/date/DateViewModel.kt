package ylc.love.wxj.com.ui.date

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.EventBean

class DateViewModel : BaseViewModel() {

    private val _dataList = MutableLiveData<List<EventBean>>()
    val dateList: LiveData<List<EventBean>> = _dataList

    fun getAllDateBeans() = runOnThread(work = {
        val dateBeanDao = AppDataBase.instance.eventBeanDao()
        val list = dateBeanDao.selectAll()
        setValueOnMain(_dataList, list)
    })

}