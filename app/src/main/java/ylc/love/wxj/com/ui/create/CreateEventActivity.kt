package ylc.love.wxj.com.ui.create

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseMvvmActivity
import ylc.love.wxj.com.databinding.ActivityCreateEventBinding
import ylc.love.wxj.com.model.EventBean

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
    }

    inner class ClickProxy {

    }

}