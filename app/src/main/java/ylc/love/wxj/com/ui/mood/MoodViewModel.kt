package ylc.love.wxj.com.ui.mood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.model.DateBean

class MoodViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    private val _dataList = MutableLiveData<List<DateBean>>()
    val dateList: LiveData<List<DateBean>> = _dataList


    fun getAllMoodBeans() = runOnThread(work = {
//        val dateBeanDao = AppDataBase.instance.eventBeanDao()
//        val list = dateBeanDao.selectAllByType(3)
//        val count= list.size
//        repeat(count) {
//            list[it].needDay = DateUtils.getNeed(list[it].date)
//            list[it].goneDay = DateUtils.getGone(list[it].date)
//        }
//        val resultList = list.sortedBy {
//            it.needDay
//        }
//        setValueOnMain(_dataList, resultList)
    })
}