package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "eat_out.db";

    public final static String TABLE_NAME = "eat_out_table";
    public final static String COL_ID = "_id";
    public final static String COL_IMG = "img";
    public final static String COL_RESTAURANT = "restaurant";
    public final static String COL_MENU = "menu";
    public final static String COL_DATE = "date";
    public final static String COL_TIME = "time";
    public final static String COL_AREA = "area";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_IMG + " TEXT, " + COL_RESTAURANT + " TEXT, " + COL_MENU + " TEXT, " +
                COL_DATE + " TEXT, " + COL_TIME + " TEXT, " + COL_AREA + " TEXT )";

        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food1', '육가구이구이', '제육덮밥', '2021/6/10', '점심', '월곡');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food2', '누들아한타이', '소고기숙주볶음면', '2021/6/9', '점심', '월곡');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food3', '로니로티', '목살스테이크샐러드', '2021/5/31', '점심', '월곡');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food4', '누들아한타이', '매운소고기쌀국수', '2021/5/27', '점심', '건대');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food5', '미도인', '스테이크덮밥', '2021/5/19', '점심', '강납');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food6', '역전할머니맥주', '치즈라볶이범벅', '2021/5/18', '저녁', '월곡');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food7', '라공방', '마라탕', '2021/5/3', '점심', '혜화');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food8', '미소야', '우삼겹우동전골', '2021/4/21', '저녁', '월곡');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food9', '도마', '돼지목살숯불구이정식', '2021/4/10', '점심', '종로');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food10', '육가구이구이', '콩나물뚝배기덮밥', '2021/3/16', '점심', '월곡');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '@mipmap/food11', '제나키친', '돈가스오므라이스', '2021/3/12', '점심', '월곡');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
