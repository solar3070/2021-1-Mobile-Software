package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBManager {

    DBHelper helper = null;
    Cursor cursor = null;

    public DBManager(Context context) {
        helper = new DBHelper(context);
    }

    public ArrayList<MyData> getAllRecord() {
        ArrayList myDataList = new ArrayList();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + helper.TABLE_NAME, null);

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(helper.COL_ID));
            String imgName = cursor.getString(cursor.getColumnIndex(helper.COL_IMG));
            String restaurant = cursor.getString(cursor.getColumnIndex(helper.COL_RESTAURANT));
            String menu = cursor.getString(cursor.getColumnIndex(helper.COL_MENU));
            String date = cursor.getString(cursor.getColumnIndex(helper.COL_DATE));
            String time = cursor.getString(cursor.getColumnIndex(helper.COL_TIME));
            String area = cursor.getString(cursor.getColumnIndex(helper.COL_AREA));

            myDataList.add(new MyData(id, imgName, restaurant, menu, date, time, area));
        }

        cursor.close();
        helper.close();
        return myDataList;
    }

    public ArrayList<MyData> searchResult(String newText) {
        ArrayList searchResultList = new ArrayList();
        SQLiteDatabase db = helper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + helper.TABLE_NAME + " WHERE " + helper.COL_RESTAURANT + "=", null);

        String selection = helper.COL_RESTAURANT + " LIKE ?";
        String[] selectArgs = new String[] { "%" + newText + "%" };
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, selection, selectArgs, null, null, null, null);


        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(helper.COL_ID));
            String imgName = cursor.getString(cursor.getColumnIndex(helper.COL_IMG));
            String restaurant = cursor.getString(cursor.getColumnIndex(helper.COL_RESTAURANT));
            String menu = cursor.getString(cursor.getColumnIndex(helper.COL_MENU));
            String date = cursor.getString(cursor.getColumnIndex(helper.COL_DATE));
            String time = cursor.getString(cursor.getColumnIndex(helper.COL_TIME));
            String area = cursor.getString(cursor.getColumnIndex(helper.COL_AREA));

            searchResultList.add(new MyData(id, imgName, restaurant, menu, date, time, area));
        }

        cursor.close();
        helper.close();
        return searchResultList;
    }

    public boolean addNewRecord(MyData newRecord) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put(helper.COL_IMG, newRecord.getImgName());
        row.put(helper.COL_RESTAURANT, newRecord.getRestaurant());
        row.put(helper.COL_MENU, newRecord.getMenu());
        row.put(helper.COL_AREA, newRecord.getArea());
        row.put(helper.COL_TIME, newRecord.getTime());
        row.put(helper.COL_DATE, newRecord.getDate());

        long count = db.insert(helper.TABLE_NAME, null, row);

        if (count > 0) return true;
        return false;
    }

    public boolean updateRecord(MyData myData) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put(helper.COL_RESTAURANT, myData.getRestaurant());
        row.put(helper.COL_MENU, myData.getMenu());
        row.put(helper.COL_AREA, myData.getArea());
        row.put(helper.COL_TIME, myData.getTime());
        row.put(helper.COL_DATE, myData.getDate());

        String whereClause = helper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(myData.get_id()) };
        int result = db.update(helper.TABLE_NAME, row, whereClause, whereArgs);

        helper.close();

        if (result > 0) return true;
        return false;
    }

    public boolean removeRecord(long id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String whereClause = helper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };

        int result = db.delete(helper.TABLE_NAME, whereClause, whereArgs);

        helper.close();
        if (result > 0) return true;
        return false;
    }

}
