package ylc.love.wxj.com.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import ylc.love.wxj.com.R
import ylc.love.wxj.com.config.ParamsKey
import ylc.love.wxj.com.utils.AppManager
import java.lang.ref.WeakReference

/**
 *@author YLC-D
 *@create on 2021/1/26 11
 *说明:
 */
abstract class BaseActivity : AppCompatActivity() {
    private var isCreated: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //解决键盘遮挡输入框的问题
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        AppManager.addActivity(this)
        isCreated = true
        if (getLayoutId() != -1) {
            setContentView(getLayoutId())
        }
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()

    override fun onResume() {
        super.onResume()
        if (isCreated) {
            initData()
            isCreated = false
        }
    }

    protected fun toNextActivity(cls: Class<out Activity>, bundle: Bundle? = null) {
        val intent = Intent(this, cls)
        intent.putExtra(ParamsKey.ACTIVITY_TO_ACTIVITY_DATA_KEY, bundle)
        AppManager.start(WeakReference(this), intent)
    }
}