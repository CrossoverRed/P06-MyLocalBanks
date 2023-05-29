package sg.edu.rp.c326.id22015010.p06_mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView DBS;
    TextView OCBC;
    TextView UOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.DBStext1);
        OCBC = findViewById(R.id.OCBCtext);
        UOB = findViewById(R.id.UOBtext);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.chineseSelection) {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
            Toast.makeText(MainActivity.this, "Chinese is chosen", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            DBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact");
        menu.add(0, 2, 2, "Favourite");
        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { // Check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) { // Check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + 18001111111l));
                startActivity(intentCall);
            } else if (item.getItemId() == 2) {
                if (DBS.getCurrentTextColor() == Color.RED) {
                    DBS.setTextColor(Color.WHITE);
                } else {
                    DBS.setTextColor(Color.RED);
                }
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { // Check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if (item.getItemId() == 1) { // Check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + 18003633333l));
                startActivity(intentCall);
            } else if (item.getItemId() == 2) {
                if (OCBC.getCurrentTextColor() == Color.RED) {
                    OCBC.setTextColor(Color.WHITE);//Black cannot be seen clearly on my background
                } else {
                    OCBC.setTextColor(Color.RED);
                }
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) { // Check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) { // Check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + 18002222121l));
                startActivity(intentCall);

            } else if (item.getItemId() == 2) {
                if (UOB.getCurrentTextColor() == Color.RED) {
                    UOB.setTextColor(Color.WHITE);//Black cannot be seen clearly on my background
                } else {
                    UOB.setTextColor(Color.RED);
                }
            }
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}