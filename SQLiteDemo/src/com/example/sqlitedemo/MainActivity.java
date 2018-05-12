package com.example.sqlitedemo;
import com.example.sqlitedemo.ContactInjfoDao;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	private EditText mEtName;
	private EditText mEtPhone;
	private ContactInjfoDao mDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDao=new ContactInjfoDao(MainActivity.this);
	    mEtName= (EditText) findViewById(R.id.mEtName);
	    mEtPhone= (EditText) findViewById(R.id.mEtPhone);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void add(View view){

	       String name=mEtName.getText().toString().trim();
	       String phone=mEtPhone.getText().toString().trim();
	       if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)){
	           Toast.makeText(this,"��д������",Toast.LENGTH_SHORT).show();
	           return;
	       }else{
	           long addLong = mDao.addDate(name, phone);
	           if(addLong==-1){
	               Toast.makeText(this,"���ʧ��",Toast.LENGTH_SHORT).show();
	           }else{
	               Toast.makeText(this,"��������ڵ�  "+addLong+"   ��",Toast.LENGTH_SHORT).show();
	           }

	       }
	   }

	   public void delete(View view){
	       String name=mEtName.getText().toString().trim();


	       if(TextUtils.isEmpty(name)){
	           Toast.makeText(this,"��д������",Toast.LENGTH_SHORT).show();
	           return;
	       }else{
	           int deleteDate = mDao.deleteDate(name);
	           if(deleteDate==-1){
	               Toast.makeText(this,"ɾ��ʧ��",Toast.LENGTH_SHORT).show();
	           }else{
	               Toast.makeText(this,"�ɹ�ɾ��  "+deleteDate+"   ������",Toast.LENGTH_SHORT).show();
	           }

	       }

	   }


	   public void update(View view){

	       String name=mEtName.getText().toString().trim();
	       String phone=mEtPhone.getText().toString().trim();
	       if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)){
	           Toast.makeText(this,"��д������",Toast.LENGTH_SHORT).show();
	           return;
	       }else{
	           int count=mDao.updateData(name, phone);
	           if(count==-1){
	               Toast.makeText(this,"����ʧ��",Toast.LENGTH_SHORT).show();
	           }else{
	               Toast.makeText(this,"���ݸ�����  "+count+"   ��",Toast.LENGTH_SHORT).show();
	           }

	       }
	   }


	   public void query(View view){

	       String name=mEtName.getText().toString().trim();
	       
	       if(TextUtils.isEmpty(name)){
	           Toast.makeText(this,"��д������",Toast.LENGTH_SHORT).show();
	           return;
	       }else{
	           String phoneResult = mDao.alterDate(name);

	           Toast.makeText(this,"�ֻ�����Ϊ:    "+phoneResult,Toast.LENGTH_SHORT).show();


	       }
	   }

}
