package com.example.vodaaccounttask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vodaaccounttask.databinding.ProductRowBinding
import com.example.vodaaccounttask.model.Account


internal class AccountRecyclerAdapter(var accountList: List<Account>) :
    RecyclerView.Adapter<AccountRecyclerAdapter.AccountViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val productRowBinding: ProductRowBinding =
            ProductRowBinding.inflate(layoutInflater, parent, false)
        return AccountViewHolder(productRowBinding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val account: Account = accountList[position]
        holder.productRowBinding.account = account
        holder.productRowBinding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return accountList.size
    }
    var defaultIndex = 0
    internal inner class AccountViewHolder(var productRowBinding: ProductRowBinding) :
        RecyclerView.ViewHolder(productRowBinding.root) {

        init {
            productRowBinding.activeButton.setOnClickListener {
                //first set not default for the old defaultIndex
                accountList[defaultIndex].isDefault = false
                notifyItemChanged(defaultIndex)
                accountList[adapterPosition].isDefault = !accountList[adapterPosition].isDefault
                defaultIndex = adapterPosition
                notifyItemChanged(adapterPosition)
            }
        }
    }

}
