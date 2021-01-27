package ylc.love.wxj.com.ui.mood

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentCreateMoodBinding

/**
 *@author YLC-D
 *@create on 2021/1/27 13
 *说明:
 */
class CreateMoodFragment: BaseFragment<CreateMoodViewModel, FragmentCreateMoodBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_create_mood

    override fun getViewModel(): CreateMoodViewModel = getViewModelProvider(this).get(CreateMoodViewModel::class.java)

    override fun initData() {

    }
}