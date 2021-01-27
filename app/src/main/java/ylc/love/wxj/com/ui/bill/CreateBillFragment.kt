package ylc.love.wxj.com.ui.bill

import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentCreateBillBinding

/**
 *@author YLC-D
 *@create on 2021/1/27 13
 *说明:
 */
class CreateBillFragment : BaseFragment<CreateBillViewModel, FragmentCreateBillBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_create_bill

    override fun getViewModel(): CreateBillViewModel =
        getViewModelProvider(this).get(CreateBillViewModel::class.java)

    override fun initData() {

    }
}