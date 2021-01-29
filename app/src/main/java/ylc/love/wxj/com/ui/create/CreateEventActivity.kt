package ylc.love.wxj.com.ui.create

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_create_event.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseMvvmActivity
import ylc.love.wxj.com.databinding.ActivityCreateEventBinding
import ylc.love.wxj.com.model.EventBean
import ylc.love.wxj.com.model.SelectTypeBean
import ylc.love.wxj.com.widget.SelectTypePopWindow

/**
 *@author YLC-D
 *@create on 2021/1/28 10
 *说明:
 */
class CreateEventActivity : BaseMvvmActivity<CreateEventViewModel, ActivityCreateEventBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_create_event
    override fun getViewModel(): CreateEventViewModel =
        getViewModelProvider(this).get(CreateEventViewModel::class.java)

    override fun initData() {
        mBinding.click = ClickProxy()
        mBinding.vm = mViewModel
        mBinding.eventBean = EventBean(1, "", "", 0L)
        initType()
    }

    var list:List<SelectTypeBean> ? = null
    private fun initType() {
        typeListWindow = SelectTypePopWindow(this)
        typeListWindow?.listener = object : SelectTypePopWindow.CustomClickListener {
            override fun onClick(item: String) {
               tv_event_title.text = item
            }
        }
        typeListWindow?.setBackgroundColor(Color.TRANSPARENT)
        val  array:Array<String> = resources.getStringArray(R.array.event_type_array)
        tv_event_title.text = array[0]
        list = List(array.size){
            SelectTypeBean(it,array[it])
        }
        typeListWindow?.list = list
    }


    var typeListWindow: SelectTypePopWindow? = null

    inner class ClickProxy {

        fun clickEventType() {
            typeListWindow?.showPopupWindow(tv_event_title)
        }
    }

}