package com.example.loginapplication.ui.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domain.model.Employee
import com.example.loginapplication.databinding.ItemEmployeeBinding

class EmployeeAdapter () : RecyclerView.Adapter<EmployeeViewHolder>() {

    private val items = ArrayList<Employee>()
    fun setItems(items: List<Employee>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding: ItemEmployeeBinding = ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) = holder.bind(items[position])
}

class EmployeeViewHolder(private val itemBinding: ItemEmployeeBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var employee: Employee

    fun bind(item: Employee) {
        this.employee = item
        itemBinding.textMemberName.text= item.firstName
      /*  Glide.with(itemBinding.root)
            .load(item.image)
            .transform(CircleCrop())
            .into(itemBinding.image)*/
    }


}