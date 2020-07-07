package cc.tanjin.wuliu.com.tanjin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tanjin on 2019/10/14.
 */
public class UserService {
    private DbHelper dbHelper;

    public UserService(Context context){
        dbHelper = new DbHelper(context);
    }

    public boolean Login(String username, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String sql = "select * from user where username = ? and password = ?";
        Cursor rawQuery = sqLiteDatabase.rawQuery(sql, new String[] { username,
                password });
        if (rawQuery.moveToFirst() == true) {
            rawQuery.close();
            return true;
        }
        return false;
    }

    public boolean Register(User user) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String sql = "insert into user (username,password) values (?,?)";
        Object obj[] = { user.getUsername(), user.getPassword() };
        sqLiteDatabase.execSQL(sql, obj);
        return true;
    }
}
