package ylc.love.wxj.com.utils

import android.content.Context
import android.graphics.Typeface

object FontCustom {
    //  fontUrl 自定义字体分类的名称
    const val fontUrl = "STXINGKA.TTF"

    //Typeface是字体，这里我们创建一个对象
    private var tf: Typeface? = null

    /**
     * 设置字体
     */
    fun setFont(context: Context): Typeface? {
        if (tf == null) {
            //给它设置你传入的自定义字体文件，再返回回来
            tf = Typeface.createFromAsset(context.assets, fontUrl)
        }
        return tf
    }
}