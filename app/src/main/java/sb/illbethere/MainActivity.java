package sb.illbethere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDatabaseHelper;
    private Button btnAdd, btnView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);

        myDatabaseHelper = new DatabaseHelper(this);
    }

    public void AddData(String newEntry){
        boolean insertData = myDatabaseHelper.addData(newEntry);

        if (insertData){
            toastMessage("Data inserted");
        }
        else{
            toastMessage("No");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
