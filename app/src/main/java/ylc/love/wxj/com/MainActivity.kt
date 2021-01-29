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
import ylc.love.wxj.com.model.DateBean
import ylc.love.wxj.com.ui.create.CreateEventActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.nav_date, R.id.nav_bill, R.id.nav_mood, R.id.nav_aunt))
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }

    override fun getLayoutId(): Int = R.layout.activity_main_layout

    override fun initData() {
        initBillTypeBean()
        initDateBean()
        create.setOnClickListener {
            toNextActivity(CreateEventActivity::class.java)
        }
    }

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

    private fun initDateBean() = runOnThread(work = {
        val dataBeanDao = AppDataBase.instance.dateBeanDao()
        val list = dataBeanDao.selectAll()
        if (list.isEmpty()) {
            val stringArray = resources.getStringArray(R.array.BillTypeString)
            val id = System.currentTimeMillis()
            repeat(stringArray.count()) {
                val ben = DateBean(
                    id + it,
                    stringArray[it],
                    "${it}现在基本上是个APP，里面都少不了CardView优美的身影，而UI基本上设计出来的都是带着各种颜色的CardView,美其名曰，搭配起来好看。好吧，咱也不敢说，咱也不敢问，搞呗",
                    id - ((it + 1) * 1000 * 60 * 60 * 24),
                    id
                )
                dataBeanDao.insert(ben)
            }
        }
    })
}