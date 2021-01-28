package ylc.love.wxj.com.widget

import android.R.id.message
import android.annotation.SuppressLint
import android.app.KeyguardManager
import android.content.Context
import android.content.Context.FINGERPRINT_SERVICE
import android.content.Context.KEYGUARD_SERVICE
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import razerdp.basepopup.BasePopupWindow
import ylc.love.wxj.com.R
import ylc.love.wxj.com.databinding.PopWindowFingerPrintBinding


/**
 * @author Administrator
 * @create on 2021/1/28 0028
 * 说明: 指纹验证弹窗
 */
class FingerPrintPopWindow(context: Context) : BasePopupWindow(context), View.OnClickListener {
    private lateinit var bind: PopWindowFingerPrintBinding
    override fun onCreateContentView(): View {
        val view = createPopupById(R.layout.pop_window_finger_print)
        bind = DataBindingUtil.bind(view)!!
        bind.ivCancel.setOnClickListener(this)
        bind.ivFingerPrint.setOnClickListener(this)
        return bind.root
    }

    init {

    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkFinger(): Boolean {
        // Keyguard Manager
        val keyguardManager = context.getSystemService(KEYGUARD_SERVICE) as KeyguardManager?
        // Fingerprint Manager
        val fingerprintManager =
            context.getSystemService(FINGERPRINT_SERVICE) as FingerprintManager?

        try {
            // Check if the fingerprint sensor is present
            if (!fingerprintManager?.isHardwareDetected!!) {
                // Update the UI with a message
                bind.msg.text = "不支持指纹验证"
                return false
            }
            if (!fingerprintManager.hasEnrolledFingerprints()) {
                bind.msg.text = "该手机没有设置指纹"
                return false
            }
            if (!keyguardManager!!.isKeyguardSecure) {
                bind.msg.text = "没有开启指纹功能"
                return false
            }
        } catch (se: SecurityException) {
            se.printStackTrace()
            return false
        }
        return true
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.iv_cancel->{

            }
            R.id.iv_finger_print->{

            }
        }
    }
}