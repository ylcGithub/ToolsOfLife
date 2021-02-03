package ylc.love.wxj.com.ui.bill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.EventBean

class BillViewModel : BaseViewModel() {

    private val _dataList = MutableLiveData<List<EventBean>>()
    val dateList: LiveData<List<EventBean>> = _dataList
    val currTime:MutableLiveData<Long> = MutableLiveData(0L)

    fun queryBeans() = runOnThread(work = {
        val dateBeanDao = AppDataBase.instance.eventBeanDao()
        val list = dateBeanDao.selectBeansByTime(2,currTime.value?:0L)
        val count= list.size
        val resultList = list.sortedByDescending {
            it.date
        }
        setValueOnMain(_dataList, resultList)
    })
}