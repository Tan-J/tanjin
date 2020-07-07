package cc.tanjin.wuliu.com.tanjin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tanjin on 2019/10/14.
 */
public class DbHelper extends SQLiteOpenHelper {

    private final static String NAME = "user.db";
    private final static int VERSION = 1;

    public DbHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user (id integer primary key autoincrement,username varchar(64),password varchar(64))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
