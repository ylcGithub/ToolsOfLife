package ylc.love.wxj.com.ui.mood

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentMoodBinding

class MoodFragment : BaseFragment<MoodViewModel,FragmentMoodBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_mood

    override fun getViewModel(): MoodViewModel = getViewModelProvider(this).get(MoodViewModel::class.java)

    override fun initData() {

    }

}