package ylc.love.wxj.com.ui.date

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.DateBean

class DateViewModel : BaseViewModel() {

    private val _dataList = MutableLiveData<List<DateBean>>()
    val dateList: LiveData<List<DateBean>> = _dataList

    fun initData(){
        getAllDateBeans()
    }

    private fun getAllDateBeans() = runOnThread(work = {
        val dateBeanDao = AppDataBase.instance.dateBeanDao()
        val selectAll = dateBeanDao.selectAll()
        _dataList.postValue(selectAll)
    })

}