package ylc.love.wxj.com

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main_layout.*
import ylc.love.wxj.com.base.BaseActivity
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.BillTypeBean
import ylc.love.wxj.com.model.EventBean
import ylc.love.wxj.com.model.EventTypeBean
import ylc.love.wxj.com.ui.create.CreateEventActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = findNavController(R.id.nav_host_fragment)
        nav_view.setupWithNavController(navController)
    }

    override fun getLayoutId(): Int = R.layout.activity_main_layout

    override fun initData() {
        initBillTypeBean()
        initEventTypeBean()
        create.setOnClickListener {
            toNextActivity(CreateEventActivity::class.java)
        }
    }

    private fun initEventTypeBean() = runOnThread(work = {
        val eventTypeBeanDao = AppDataBase.instance.eventTypeBeanDao()
        val selectAll = eventTypeBeanDao.selectAll()
        if (selectAll.isEmpty()) {
            val array: Array<String> = resources.getStringArray(R.array.event_type_array)
            repeat(array.count()) {
                val bean = EventTypeBean(it + 1, array[it])
                eventTypeBeanDao.insert(bean)
            }
        }
    })

    private fun initBillTypeBean() = runOnThread(work = {
        val billTypeBeanDao = AppDataBase.instance.billTypeBeanDao()
        val list = billTypeBeanDao.selectAll()
        if (list.isEmpty()) {
            val stringArray = resources.getStringArray(R.array.BillTypeString)
            val id = System.currentTimeMillis()
            repeat(stringArray.count()) {
                val ben = BillTypeBean(id + it, stringArray[it])
                billTypeBeanDao.insert(ben)
            }
        }
    })
}