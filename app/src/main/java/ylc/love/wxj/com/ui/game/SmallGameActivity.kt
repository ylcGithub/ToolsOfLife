package ylc.love.wxj.com.ui.game

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseMvvmActivity
import ylc.love.wxj.com.databinding.ActivitySmallGameBinding

/**
 *@author YLC-D
 *@create on 2021/2/26 17
 *说明:
 */
class SmallGameActivity :BaseMvvmActivity<SmallGameViewModel,ActivitySmallGameBinding>(){
    override fun getViewModel(): SmallGameViewModel = getViewModelProvider(this).get(SmallGameViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.activity_small_game

    override fun initData() {

    }
}