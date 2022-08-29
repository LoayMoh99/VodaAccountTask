package com.example.vodaaccounttask

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.vodaaccounttask.databinding.ProductRowBinding
import com.example.vodaaccounttask.model.Account


internal class AccountRecyclerAdapter(var accountList: ArrayList<Account>) :
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
            // click listener for edit button
            productRowBinding.editButton.setOnClickListener {
                Log.d("Edit", "Edit Button is clicked -> Open new modal for example!")
            }
            // click listener for remove button
            productRowBinding.removeButton.setOnClickListener {
                // remove this device from backend if needed at first then remove it from UI
                if (adapterPosition == defaultIndex) {
                    Toast.makeText(this.productRowBinding.root.context, "Can't Remove your default account", Toast.LENGTH_LONG).show()
                } else {
                    // remove this account
                    accountList.removeAt(adapterPosition)
                    if (defaultIndex > adapterPosition){
                        defaultIndex-=1
                    }
                    notifyItemRemoved(adapterPosition)
                }

            }
            // click listener for checkbox
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
