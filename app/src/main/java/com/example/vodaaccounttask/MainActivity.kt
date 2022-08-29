package com.example.vodaaccounttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.vodaaccounttask.databinding.ActivityMainBinding
import com.example.vodaaccounttask.model.Account

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val accountRecyclerAdapter = AccountRecyclerAdapter(getAccountList())
        activityMainBinding.recyclerView.adapter = accountRecyclerAdapter
        activityMainBinding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun getAccountList(): List<Account> {
        val accountList: MutableList<Account> = ArrayList()
        accountList.add(Account("Account 1", "70",  "https://picsum.photos/id/237/200",true))
        accountList.add(Account("Account 2", "70", "https://picsum.photos/id/238/200"))
        accountList.add(Account("Account 3", "70",  "https://picsum.photos/id/239/200"))
        accountList.add(Account("Account 4", "70",  "https://picsum.photos/id/240/200"))
        accountList.add(Account("Account 5", "70",  "https://picsum.photos/id/241/200"))
        accountList.add(Account("Account 6", "70", "https://picsum.photos/id/238/200"))
        accountList.add(Account("Account 7", "70",  "https://picsum.photos/id/239/200"))
        accountList.add(Account("Account 8", "70",  "https://picsum.photos/id/240/200"))
        return accountList
    }
}