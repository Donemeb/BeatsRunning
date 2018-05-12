package com.example.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	public DBHelper(Context context) {
        /**
         * ����˵����
         *
         * ��һ�������� ������
         * �ڶ������������ݿ������
         * ������������null�������Ĭ�ϵ��α깤��
         * ���ĸ������������ݿ�İ汾��  ���ݿ�ֻ������,���ܽ���,�汾��ֻ�ܱ���ܱ�С
         */
        super(context, "mintest.db", null, 2);
    }
	/**
     * onCreate�������ݿⴴ����ʱ����õģ���Ҫ������ʼ�����ݱ�ṹ�Ͳ������ݳ�ʼ���ļ�¼
     *
     * �����ݿ��һ�α�������ʱ����õķ���,�ʺ������������������ݿ�ı�ṹ�������.
     * ����ֻ�г����һ�����е�ʱ��Ż�ִ��
     * ������ٿ����������ִ�У�����д�ڳ���Ȼ�����°�װ���app
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table contactinfo (id integer primary key autoincrement, name varchar(20), phone varchar(20))");
    }
    /**
     * �����ݿ���µ�ʱ����õķ���
     * ���Ҫ��ʾ�������������super�������汾�ŷ����ı�ʱ�Ż� ��ӡ  ��super(context, "itheima.db", null, 2); ��
     * ע�⣬���ݿ�İ汾��ֻ���Ա�󣬲��ܱ�С���������ǵ�ǰд�İ汾����3�����У�Ȼ���ָĳ�1�������򱨴����ܱ�С
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table contactinfo add account varchar(20)");
    }


}
