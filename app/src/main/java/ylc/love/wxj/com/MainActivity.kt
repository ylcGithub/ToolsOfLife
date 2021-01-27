package ylc.love.wxj.com

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main_layout.*
import ylc.love.wxj.com.base.BaseActivity

class MainActivity : BaseActivity() {

    private var activityCreated: Boolean = true
    private var lastPageId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.nav_date, R.id.nav_bill, R.id.nav_mood))
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }

    override fun getLayoutId(): Int = R.layout.activity_main_layout

    override fun initData() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (activityCreated) {
                lastPageId = destination.id
                activityCreated = false
            }else{
                if (!inMainPage(lastPageId) && inMainPage(destination.id)) {
                    Log.e("LIFE", "回到主页")
                    startAnim(false)
                }else if(!inMainPage(destination.id)){
                    Log.e("LIFE", "回到主页")
                    startAnim(true)
                }
            }
        }
    }

    private fun startAnim(outPage: Boolean){
        if(outPage){
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_left_out)
            nav_view.animation = animation
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    nav_view.visibility = View.GONE
                }
                override fun onAnimationEnd(animation: Animation) {}
                override fun onAnimationRepeat(animation: Animation) {}
            })
            animation.startNow()
        }else{
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_right_in)
            nav_view.animation = animation
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    nav_view.visibility = View.VISIBLE
                }
                override fun onAnimationEnd(animation: Animation) {}
                override fun onAnimationRepeat(animation: Animation) {}
            })
            animation.startNow()
        }
    }

    private fun inMainPage(currentId: Int): Boolean {
        val inDate = currentId == R.id.nav_date
        val inBill = currentId == R.id.nav_bill
        val inMood = currentId == R.id.nav_mood
        return inDate || inBill || inMood
    }
}