package ylc.love.wxj.com.ui.create

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_create_event.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseMvvmActivity
import ylc.love.wxj.com.databinding.ActivityCreateEventBinding
import ylc.love.wxj.com.expand.toast
import ylc.love.wxj.com.utils.DateUtils
import java.util.*

/**
 *@author YLC-D
 *@create on 2021/1/28 10
 *说明:
 */
class CreateEventActivity : BaseMvvmActivity<CreateEventViewModel, ActivityCreateEventBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_create_event
    override fun getViewModel(): CreateEventViewModel =
        getViewModelProvider(this).get(CreateEventViewModel::class.java)

    override fun initData() {
        mBinding.click = ClickProxy()
        mBinding.vm = mViewModel
        val time = DateUtils.getCurDateStr("yyyy-MM-dd")
        tv_event_time.text = time
        mViewModel.eventDate.postValue(DateUtils.getDateFromStr(time, "yyyy-MM-dd"))

        mViewModel.saveState.observe(this, {
            if (it) {
                "保存成功".toast()
                finishActivity()
            } else {
                "保存失败".toast()
            }
        })
    }

    inner class ClickProxy {

        fun back() {
            finishActivity()
        }

        @SuppressLint("SetTextI18n")
        @RequiresApi(Build.VERSION_CODES.N)
        fun selectDate() {
            val calender = Calendar.getInstance()
            val dialog = DatePickerDialog(
                this@CreateEventActivity,
                { _, year, month, dayOfMonth ->
                    val time = "$year-${month + 1}-$dayOfMonth"
                    tv_event_time.text = time
                    mViewModel.eventDate.value = DateUtils.getDateFromStr(time, "yyyy-MM-dd")
                },
                calender.get(Calendar.YEAR),
                calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH)
            )
            dialog.show()
        }

        fun saveEvent() {
            mViewModel.saveEvent()
        }
    }

}