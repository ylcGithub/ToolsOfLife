package ylc.love.wxj.com.ui.aunt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.model.DateBean

/**
 *@author YLC-D
 *@create on 2021/1/28 15
 *说明:
 */
class AuntViewModel:BaseViewModel() {

    private val _dataList = MutableLiveData<List<DateBean>>()
    val dateList: LiveData<List<DateBean>> = _dataList


    fun getAllAuntBeans() = runOnThread(work = {
//        val dateBeanDao = AppDataBase.instance.eventBeanDao()
//        val list = dateBeanDao.selectAllByType(4)
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