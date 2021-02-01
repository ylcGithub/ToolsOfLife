package ylc.love.wxj.com.ui.bill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.EventBean
import ylc.love.wxj.com.utils.DateUtils

class BillViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _dataList = MutableLiveData<List<EventBean>>()
    val dateList: LiveData<List<EventBean>> = _dataList


    fun getAllBillBeans() = runOnThread(work = {
        val dateBeanDao = AppDataBase.instance.eventBeanDao()
        val list = dateBeanDao.selectAllByType(2)
        val count= list.size
        repeat(count) {
            list[it].needDay = DateUtils.getNeed(list[it].date)
            list[it].goneDay = DateUtils.getGone(list[it].date)
        }
        val resultList = list.sortedBy {
            it.needDay
        }
        setValueOnMain(_dataList, resultList)
    })
}