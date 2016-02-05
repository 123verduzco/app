package adrdbh.android.curso.ejercicio1.actividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adrdbh.android.curso.ejercicio1.R;

public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView tx2 = (TextView) findViewById(R.id.act2);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final EditText ex2 = (EditText) findViewById(R.id.tx1);
        final ListView lv = (ListView) findViewById(R.id.l1);
        final Bundle bundle = getIntent().getExtras();
        final ArrayList<String> arl = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_layout, arl);

        tx2.setText(bundle.getString("key"));
        lv.setAdapter(adapter);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arl.add(ex2.getText().toString());
                adapter.notifyDataSetChanged();
                ex2.setText(" ");

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "elemento: " + lv.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
