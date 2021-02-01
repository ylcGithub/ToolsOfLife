package ylc.love.wxj.com.ui.setting

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentSettingBinding

/**
 * @author Administrator
 * @create on 2021/2/1 0001
 * 说明:
 */
class SettingFragment:BaseFragment<SettingViewModel,FragmentSettingBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_setting

    override fun getViewModel(): SettingViewModel = getViewModelProvider(this).get(SettingViewModel::class.java)

    override fun initData() {

    }
}