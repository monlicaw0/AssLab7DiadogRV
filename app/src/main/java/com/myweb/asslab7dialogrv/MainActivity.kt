package com.myweb.asslab7dialogrv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*


class MainActivity : AppCompatActivity() {
    val employeeList  = arrayListOf<Employee>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testEmployeeData()
        recycler_view.adapter = EmployeeAdapter(this.employeeList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext) as RecyclerView.LayoutManager?
        recycler_view.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

    }

    fun addEmployee(v:View){

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        //show dialog
        val  mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener{
           // Toast.makeText(applicationContext,"Test", Toast.LENGTH_LONG).show()
            var  radioGroup: RadioGroup = mDialogView.radioGroup  // findViewById(R.id.radioGroup)

            var  selectedId : Int = radioGroup.checkedRadioButtonId

            var  radioButton : RadioButton = mDialogView.findViewById(selectedId)

          //  Toast.makeText(applicationContext,radioButton.text.toString(), Toast.LENGTH_LONG).show()

            employeeList.add( Employee( mDialogView.edit_name.text.toString(), radioButton.text.toString(),
                mDialogView.edit_email.text.toString(),mDialogView.edit_salary.text.toString().toInt()))

         //   var employ = Employee( mDialogView.edit_name.text.toString(),radioButton.text.toString(),
          //      mDialogView.edit_email.text.toString(), mDialogView.edit_salary.text.toString().toInt())
         //   employeeList.add(employ)


            // var employ = Employee("ddd","Male", "dfg@kk", 34566)
           // employeeList.add(employ)




         //   Toast.makeText(applicationContext,employ.toString(), Toast.LENGTH_LONG).show()

           recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext,"The student is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }

        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }

    fun testEmployeeData(){
        employeeList.add(Employee("Danny", "Male", "danny@kku.ac.th", 30000))
        employeeList.add(Employee("Sara", "Female", "sara@kku.ac.th", 34000))
    }
}
