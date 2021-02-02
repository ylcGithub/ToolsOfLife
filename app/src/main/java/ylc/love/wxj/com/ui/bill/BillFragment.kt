package ylc.love.wxj.com.ui.bill

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.base.BaseOneLayoutAdapter
import ylc.love.wxj.com.base.BaseViewHolder
import ylc.love.wxj.com.databinding.BillListItemBinding
import ylc.love.wxj.com.databinding.FragmentBillBinding
import ylc.love.wxj.com.model.EventBean

class BillFragment : BaseFragment<BillViewModel,FragmentBillBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_bill

    override fun getViewModel(): BillViewModel = getViewModelProvider(this).get(BillViewModel::class.java)

    override fun initData() {

    }

    private val mAdapter = object :BaseOneLayoutAdapter<EventBean,BillListItemBinding>(R.layout.bill_list_item){
        override fun itemIsSame(oldItem: EventBean, newItem: EventBean): Boolean = oldItem == newItem

        override fun onBindItem(
            bind: BillListItemBinding,
            item: EventBean,
            holder: BaseViewHolder) {

        }

    }
}