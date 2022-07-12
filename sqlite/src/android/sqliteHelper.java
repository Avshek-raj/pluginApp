package android;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class sqliteHelper extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    //Database name
    private static String DATABASE_NAME = "EmployeeData";
    //Table name
    private static String TABLE_NAME = "Employees";
    //Table column
    private static String KEY_ID = "id";
    private static String EMPLOYEE_NAME = "EmployeeName";
    private static String SALARY = "Salary";
    private static String ADDRESS = "Address";
    private static String PHONE_NUMBER = "contact";
    private static String POST = "post";

    public sqliteHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + KEY_ID + " INTEGER PRIMARY KEY, " + 
        EMPLOYEE_NAME + " TEXT, " + SALARY + " INTEGER, " + ADDRESS + " VARCHAR, " + PHONE_NUMBER + " INTEGER, " + 
        POST + " VARCHAR)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i ,int ii) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertEmployee(Integer id, String name, String salary, String address, Integer contact, String post ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", id);
        contentvalues.put("EmployeeName", name);
        contentvalues.put("Salary", salary);
        contentvalues.put("Address", address);
        contentvalues.put("contact", contact);
        contentvalues.put("post", post);
        long result = db.insertOrThrow(TABLE_NAME, null, contentvalues);
        if(result ==-1){
            return false;
        } else{
            return true;
        }
    }

    public boolean updateEmployee(Integer id, String name, String salary, String address, Integer contact, String post ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", id);
        contentvalues.put("EmployeeName", name);
        contentvalues.put("Salary", salary);
        contentvalues.put("Address", address);
        contentvalues.put("contact", contact);
        contentvalues.put("post", post);
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME+ " WHERE id = "+ id , null);
        if(cursor.getCount() > 0){
        long result = db.update(TABLE_NAME, contentvalues, "id="+ id,null );
            if(result ==-1){
            return false;
            } else{
            return true;
            }
        }else{
            return false;
        }
    }

    public boolean deleteData(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, KEY_ID + " = " +id, null);
        if(result ==-1){
           return  false;
        }else
            return  true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null ); 
        cursor.moveToFirst();
        return cursor;
    }

    public int getDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
 
        // return count
        return cursor.getCount();
    }
}
