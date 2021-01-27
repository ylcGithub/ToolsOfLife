package ylc.love.wxj.com.ui.date


import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentCreateDateBinding
import ylc.love.wxj.com.expand.toast

/**
 *@author YLC-D
 *@create on 2021/1/27 13
 *说明:
 */
class CreateDateFragment : BaseFragment<CreateDateViewModel, FragmentCreateDateBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_create_date

    override fun getViewModel(): CreateDateViewModel =
        getViewModelProvider(this).get(CreateDateViewModel::class.java)

    override fun initData() {
        mBinding.click = ClickProxy()
        mBinding.vm = mViewModel
    }

    inner class ClickProxy {
        fun save() {

        }

        @RequiresApi(Build.VERSION_CODES.N)
        fun selectDate() {
            val dialog = DatePickerDialog(mContext)
            dialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                "$year-${month + 1}-$dayOfMonth".toast(Toast.LENGTH_LONG)
            }
            dialog.show()
        }
    }
}