package sb.illbethere;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sean on 28/06/2017.
 */

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";
    DatabaseHelper myDatabaseHelper;
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        myListView = (ListView) findViewById(R.id.listview);
        myDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView(){
        Cursor data = myDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        final ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        myListView.setAdapter(listAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();

                Cursor data = myDatabaseHelper.getItemID(name);
                int itemID = -1;
                while (data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if (itemID > -1){
                    Intent editScreenIntent = new Intent(ListDataActivity.this, EditDataActivity.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("name", name);
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("ID = NO");
                }
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
