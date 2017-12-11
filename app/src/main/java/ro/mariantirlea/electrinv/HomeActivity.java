package ro.mariantirlea.electrinv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import ro.mariantirlea.electrinv.db.AppDatabase;
import ro.mariantirlea.electrinv.db.Location;
import ro.mariantirlea.electrinv.db.Item;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppDatabase database = AppDatabase.getDatabase(getApplicationContext());

        database.itemDao().removeAllItems();

        Location loc1 = new Location(1, "S1", "-");
        Location loc2 = new Location(2, "S2", "-");
        database.locationDao().addLocation(loc1);
        database.locationDao().addLocation(loc2);

        Item itm1 = new Item(loc1.id, "Itm1", "-");
        database.itemDao().addItem(itm1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
