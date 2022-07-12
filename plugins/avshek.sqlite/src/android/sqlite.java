package avshek.sqlite;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.database.Cursor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.sqliteHelper;
import java.util.ArrayList;
import java.util.List;


/**
 * This class echoes a string called from JavaScript.
 */
public class sqlite extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        sqliteHelper db = new sqliteHelper(cordova.getContext());

        if (action.equals("insert")) {
            int id = args.getInt(0);
            String name = args.getString(1);
            String salary = args.getString(2);
            String address = args.getString(3);
            int contact = args.getInt(4);
            String post = args.getString(5);
            try {
                db.insertEmployee(id, name, salary, address, contact, post);
                callbackContext.success("Data inserted");
            } catch (Exception e) {
                callbackContext.error("error: "+ e);
            }
            // boolean status = db.insertEmployee(id, name, salary, address, contact, post);
            // if (status) {
            //     callbackContext.success("Transaction Succesful");
            // } else {
            //     callbackContext.error("Error occured");
            // }
        } else if (action.equals("update")) {
            int id = args.getInt(0);
            String name = args.getString(1);
            String salary = args.getString(2);
            String address = args.getString(3);
            int contact = args.getInt(4);
            String post = args.getString(5);
            boolean status = db.updateEmployee(id, name, salary, address, contact, post);
            if (status) {
                callbackContext.success("Transaction Succesful");
            } else {
                callbackContext.error("Error occured");
            }
        } else if (action.equals("delete")) {
            int id = args.getInt(0);
            boolean status = db.deleteData(id);
            if (status) {
                callbackContext.success("Transaction Succesful");
            } else {
                callbackContext.error("Error occured");
            }
        } else if (action.equals("getData")) {
           Cursor cursor = db.getData();
        //    List employeeList = new ArrayList();
           JSONArray employeeJsonArray = new JSONArray();
           String[] names ;
            do{
                JSONObject employee = new JSONObject();
                employee.put("Id", cursor.getInt(0));
                employee.put("EmployeeName", cursor.getString(1));
                employee.put("Salary", cursor.getString(2));
                employee.put("Address", cursor.getString(3));
                employee.put("Contact", cursor.getInt(4));
                employee.put("Post", cursor.getString(5));
                // employeeList.add(employee);
                employeeJsonArray.put(employee);
            } while(cursor.moveToNext());
            if (cursor.getCount() >= 0){
                callbackContext.success(employeeJsonArray);
            }else{
                callbackContext.error("No datas");
            }

        }else if (action.equals("getDataCount")) {
            int result = db.getDataCount();
            if (result >= 0){
                callbackContext.success(result);
            }else{
                callbackContext.error("No datas");
            }

        } else {
            return false;
        }
        return false;
    }

}

