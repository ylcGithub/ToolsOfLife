package ylc.love.wxj.com.ui.bill

import android.app.DatePickerDialog
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_bill.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.base.BaseOneLayoutAdapter
import ylc.love.wxj.com.base.BaseViewHolder
import ylc.love.wxj.com.databinding.BillListItemBinding
import ylc.love.wxj.com.databinding.FragmentBillBinding
import ylc.love.wxj.com.model.DateBean
import ylc.love.wxj.com.utils.DateUtils
import java.util.*

class BillFragment : BaseFragment<BillViewModel,FragmentBillBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_bill

    override fun getViewModel(): BillViewModel = getViewModelProvider(this).get(BillViewModel::class.java)

    override fun initData() {
        rcv_bill.adapter = mAdapter
        rcv_bill.layoutManager = LinearLayoutManager(mContext)
        mViewModel.currTime.postValue(DateUtils.getCurrMonthStartTime())
        tv_look_time.setOnClickListener(this::showDateSelectDialog)
        mViewModel.currTime.observe(this,{
            mViewModel.queryBeans()
        })
    }

    private fun showDateSelectDialog(v:View){
        val calender = Calendar.getInstance()
        val dialog = DatePickerDialog(
            mContext,
            { _, year, month, dayOfMonth ->
                val time = "$year-${month + 1}-$dayOfMonth"
//                tv_event_time.text = time
//                mViewModel.currTime.postValue(DateUtils.getDateFromStr(time, "yyyy-MM"))
            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)
        )
        dialog.show()
    }

    private val mAdapter = object :BaseOneLayoutAdapter<DateBean,BillListItemBinding>(R.layout.bill_list_item){
        override fun itemIsSame(oldItem: DateBean, newItem: DateBean): Boolean = oldItem == newItem

        override fun onBindItem(
            bind: BillListItemBinding,
            item: DateBean,
            holder: BaseViewHolder) {
        }

    }
}