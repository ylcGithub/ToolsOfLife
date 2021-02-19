package ylc.love.wxj.com.ui.create.mood

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseMvvmActivity
import ylc.love.wxj.com.databinding.ActivityCreateMoodBinding

/**
 *@author YLC-D
 *@create on 2021/2/19 10
 *说明:
 */
class CreateMoodActivity:BaseMvvmActivity<CreateMoodViewModel,ActivityCreateMoodBinding>() {
    override fun getViewModel(): CreateMoodViewModel = getViewModelProvider(this).get(CreateMoodViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.activity_create_mood

    override fun initData() {

    }
}