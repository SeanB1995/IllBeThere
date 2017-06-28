package sb.illbethere;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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

    }
}
