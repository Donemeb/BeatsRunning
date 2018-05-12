package com.example.sqlitedemo;
import com.example.sqlitedemo.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 *  ContactInjfoDao  ���ݿ������  dao��׺�Ķ������ݿ������
 *
 *  ���������ÿһ�� ��ɾ�Ĳ� �ķ�����ͨ��getWritableDatabase()ȥʵ������һ�����ݿ�,���������ô��
 *  ��������ȡ ��Ϊһ����Ա����, ���򱨴�,���Ǿ����鷳����ͨ�����巽������Ϊnull�����¸�ֵ
 *
 *  ���� ��ʵdao�����������������ر�򵥣�
 *  1������һ�����췽���������������ȥʵ����һ��  ���ݿ������
 *  2����дdao��Ķ�Ӧ�� ��ɾ�Ĳ� ������
 *
 */
public class ContactInjfoDao {

    private DBHelper mDBHelper;

    /**
     * dao����Ҫʵ�������ݿ�Help��,ֻ�еõ�������Ķ������ǲſ���ʵ���� SQLiteDatabase
     * @param context
     */
    public ContactInjfoDao(Context context) {
        mDBHelper=new DBHelper(context);
    }

    // �����ݿ�򿪰������ʵ������Ȼ�������������
    // ���ùȸ��apiȥ������ɾ�Ĳ�

    // ���ӵķ����𣬷��صĵ���һ��longֵ
    public long addDate(String name,String phone){
        // ��ɾ�Ĳ�ÿһ��������Ҫ�õ����ݿ⣬Ȼ�������ɺ�һ��Ҫ�ر�
        // getWritableDatabase(); ִ�к����ݿ��ļ��Ż�����
        // ���ݿ��ļ�����DDMS���Բ鿴���� data/data/����/databases Ŀ¼�¼��ɲ鿴
        SQLiteDatabase sqLiteDatabase =  mDBHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("name",name);
        contentValues.put("phone", phone);
        // ����,��ʾ��������ڵڼ���
        // �����������������3������,ͻȻɾ��������,Ȼ�������һ�����ݷ��ص���4����3
        // ��Ϊ������
        long rowid=sqLiteDatabase.insert("contactinfo",null,contentValues);

        sqLiteDatabase.close();
        return rowid;
    }


    // ɾ���ķ���������ֵ��int
    public int deleteDate(String name){
        SQLiteDatabase sqLiteDatabase = mDBHelper.getWritableDatabase();
        int deleteResult = sqLiteDatabase.delete("contactinfo", "name=?", new String[]{name});
        sqLiteDatabase.close();
        return deleteResult;
    }

    /**
     * �޸ĵķ���
     * @param name
     * @param newPhone
     * @return
     */
    public int updateData(String name,String newPhone){
        SQLiteDatabase sqLiteDatabase = mDBHelper.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("phone", newPhone);
        int updateResult = sqLiteDatabase.update("contactinfo", contentValues, "name=?", new String[]{name});
        sqLiteDatabase.close();
        return updateResult;
    }

    /**
     * ��ѯ�ķ��������ҵ绰��
     * @param name
     * @return
     */
    public String alterDate(String name){
        String phone = null;

        SQLiteDatabase readableDatabase = mDBHelper.getReadableDatabase();
        // ��ѯ�Ƚ��ر�,�漰�� cursor
        Cursor cursor = readableDatabase.query("contactinfo", new String[]{"phone"}, "name=?", new String[]{name}, null, null, null);
        if(cursor.moveToNext()){
            phone=cursor.getString(0);
        }
        cursor.close(); // �ǵùر� corsor
        readableDatabase.close(); // �ر����ݿ�
        return phone;
    }


}
