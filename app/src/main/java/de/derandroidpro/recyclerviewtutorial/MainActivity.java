package de.derandroidpro.recyclerviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView1;
    RecyclerView.Adapter rvadapter1;
    RecyclerView.LayoutManager rvLayoutManager1;

   static ArrayList<String> itemTexte;
   static ArrayList<Integer> itemFotoIDs;

    static TextView tv1;

    Button btn_add;
    EditText et_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemTexte = new ArrayList<>();
        itemFotoIDs = new ArrayList<>();

        itemTexte.addAll(Arrays.asList("Wecker", "Mensch", "Profilbild", "hinzufügen", "Android", "Benachrichtigung",
                "Archivieren", "Statistik", "Fahne", "Büroklammer", "Musik", "Zeichen löschen",
                "Cloud_Upload", "Bluetooth", "Helligkeit", "Kamera", "Abbrechen", "Stift", "E-Mail", "Ordner"));

        itemFotoIDs.addAll(Arrays.asList(
                R.drawable.ic_access_alarm_grey600_18dp
                ,R.drawable.ic_accessibility_grey600_18dp
                ,R.drawable.ic_account_box_grey600_18dp
                ,R.drawable.ic_add_to_photos_grey600_18dp
                ,R.drawable.ic_android_grey600_18dp
                ,R.drawable.ic_announcement_grey600_18dp
                ,R.drawable.ic_archive_grey600_18dp
                ,R.drawable.ic_assessment_grey600_18dp
                ,R.drawable.ic_assistant_photo_grey600_18dp
                ,R.drawable.ic_attach_file_grey600_18dp
                ,R.drawable.ic_audiotrack_grey600_18dp
                ,R.drawable.ic_backspace_grey600_18dp
                ,R.drawable.ic_backup_grey600_18dp
                ,R.drawable.ic_bluetooth_audio_grey600_18dp
                ,R.drawable.ic_brightness_6_grey600_18dp
                ,R.drawable.ic_camera_alt_grey600_18dp
                ,R.drawable.ic_cancel_grey600_18dp
                ,R.drawable.ic_create_grey600_18dp
                ,R.drawable.ic_drafts_grey600_18dp
                ,R.drawable.ic_folder_grey600_18dp
        ));

        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview1);
        rvLayoutManager1 = new GridLayoutManager(this,3);
        recyclerView1.setLayoutManager(rvLayoutManager1);

        rvadapter1 = new RvAdapterKlasse();
        recyclerView1.setAdapter(rvadapter1);


        tv1 = (TextView) findViewById(R.id.textView);


        add_items_setup();

    }

    public void add_items_setup() {
        btn_add = (Button) findViewById(R.id.button_add);
        et_add = (EditText) findViewById(R.id.editText_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_add.getText().length() >0){

                    itemTexte.add(et_add.getText().toString());
                    itemFotoIDs.add(R.drawable.ic_access_alarm_grey600_18dp);
                    rvadapter1.notifyDataSetChanged();
                    et_add.setText(null);
                    recyclerView1.smoothScrollToPosition(itemTexte.size());

                }
            }
        });



    }

}
