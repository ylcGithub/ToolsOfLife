package ylc.love.wxj.com.ui.create

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_create_event.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseMvvmActivity
import ylc.love.wxj.com.databinding.ActivityCreateEventBinding
import ylc.love.wxj.com.expand.toast
import ylc.love.wxj.com.model.SelectTypeBean
import ylc.love.wxj.com.utils.DateUtils
import ylc.love.wxj.com.widget.SelectTypePopWindow
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
        initType()
        et_title.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                mViewModel.eventTitle.postValue(s.toString())
            }

        })
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

    var list: List<SelectTypeBean>? = null
    private fun initType() {
        typeListWindow = SelectTypePopWindow(this)
        typeListWindow?.listener = object : SelectTypePopWindow.CustomClickListener {
            override fun onClick(id:Int,type: String) {
                mViewModel.eventType.postValue(id)
                tv_event_type.text = type
            }
        }
        typeListWindow?.setBackgroundColor(Color.TRANSPARENT)
        val array: Array<String> = resources.getStringArray(R.array.event_type_array)
        list = List(array.size) {
            SelectTypeBean(it+1, array[it])
        }
        typeListWindow?.list = list
    }


    var typeListWindow: SelectTypePopWindow? = null

    inner class ClickProxy {

        fun back(){
            finishActivity()
        }

        fun clickEventType() {
            typeListWindow?.showPopupWindow(tv_event_type)
        }

        fun clickBillType(){

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