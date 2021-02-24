package ylc.love.wxj.com.ui.mood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ylc.love.wxj.com.base.BaseViewModel
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.MoodBean

class MoodViewModel : BaseViewModel() {
    private val _dataList = MutableLiveData<MutableList<MoodBean>>()
    val dateList: LiveData<MutableList<MoodBean>> = _dataList
    val createTitle = MutableLiveData(false)

    fun getAllMoodBeans() = runOnThread(work = {
        val dao = AppDataBase.instance.moodBeanDao()
        val list = dao.selectAll()
        list.add(0, MoodBean(0L,"","",0L))
        setValueOnMain(_dataList,list)
    })
}