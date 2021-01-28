package ylc.love.wxj.com.ui.aunt

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentAuntBinding

/**
 *@author YLC-D
 *@create on 2021/1/28 15
 *说明:
 */
class AuntFragment:BaseFragment<AuntViewModel,FragmentAuntBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_aunt

    override fun getViewModel(): AuntViewModel = getViewModelProvider(this).get(AuntViewModel::class.java)

    override fun initData() {

    }
}