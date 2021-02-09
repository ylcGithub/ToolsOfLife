package ylc.love.wxj.com.common

import android.view.View
import androidx.databinding.BindingAdapter
import ylc.love.wxj.com.widget.AppTitle

/**
 *@author YLC-D
 *@create on 2021/2/4 16
 *说明:数据绑定的扩展方法
 */

@BindingAdapter("titleBack")
fun setAppTitleBackClick(titleBar: AppTitle, listener: View.OnClickListener?) {
    titleBar.setClickBackListener(listener)
}