package ylc.love.wxj.com

import android.util.Log
import ylc.love.wxj.com.base.BaseActivity

/**
 *@author YLC-D
 *@create on 2021/1/26 10
 *说明:启动屏页面
 */
class SplashActivity : BaseActivity(){

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initData() {
        toNextActivity(MainActivity::class.java)
        Log.e("ylc","error")
    }
}