package ylc.love.wxj.com

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.util.Log
import kotlinx.android.synthetic.main.activity_splash.*
import ylc.love.wxj.com.base.BaseActivity

/**
 *@author YLC-D
 *@create on 2021/1/26 10
 *说明:启动屏页面
 */
class SplashActivity : BaseActivity(){

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initData() {
        anim_logo.addOffsetAnimListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                Log.d("AnimLogoView", "Offset anim end")
            }
        })
        anim_logo.addGradientAnimListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                Log.d("AnimLogoView", "Gradient anim end")
                toNextActivity(MainActivity::class.java)
            }
        })
        anim_logo.startAnimation()
    }
}