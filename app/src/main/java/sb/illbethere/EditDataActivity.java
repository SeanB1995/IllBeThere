package sb.illbethere;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sean on 02/07/2017.
 */

public class EditDataActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private Button btnSave, btnDelete;
    private EditText editable_Item;

    DatabaseHelper myDatabaseHelper;

    private String selectedName;
    private int selectedID;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        editable_Item = (EditText) findViewById(R.id.editable_item);
        myDatabaseHelper = new DatabaseHelper(this);

        Intent recievedIntent = getIntent();
        selectedName = recievedIntent.getStringExtra("name");
        selectedID = recievedIntent.getIntExtra("ID", -1);
        editable_Item.setText(selectedName);

    }
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
