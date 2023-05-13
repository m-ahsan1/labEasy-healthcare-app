package com.task1.labeasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabDetailsActivity extends AppCompatActivity {
    private String[] [] lab_details1 =
            {
                    {"Doctor Name: Ajit Saste", "Hospital Address : Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Prasad Pawar", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[] [] lab_details2 =
            {
                    {"Doctor Name: Neelam Patil", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Swati Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name: Neeraja Kale", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name: Mayuri Deshmukh", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: Minakshi Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[] [] lab_details3 =
            {
                    {"Doctor Name: Seema Patil", "Hospital Address: Pimpri", "Exp: 4yrs", "Mobile No:9898989898", "200"},
                    {"Doctor Name: Pnkaj Parab", "Hospital Address : Nigdi", "Exp: 5yrs", "Mobile No:7898989898", "300"},
                    {"Doctor Name: Monish Jain", "Hospital Address: Pune", "Exp: 7yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name: Vishal Deshmukh", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Shrikant Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "600"}
            };
    private String[] [] lab_details4 =
            {
                    {"Doctor Name: Amol Gawade", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Nilesh Kale", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshpande", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: Ashok Singh", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[] [] lab_details5 =
            {
                    {"Doctor Name: Amol Gawade", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Nilesh Kale", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshpande", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: Ashok Singh", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
        TextView tv;
        Button btn;
        String[][] lab_details = {};
        HashMap<String, String> item ;
        ArrayList list;
        SimpleAdapter sa;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lab_detail);
            tv = findViewById(R.id.textViewDDTitle);
            btn = findViewById(R.id.buttonDDBack);
            Intent it = getIntent();
            String title = it.getStringExtra( "title");
            tv.setText(title);
            if(title.compareTo("Family Physician")==0)
                lab_details = lab_details1;
            else if(title.compareTo("Dietician")==0)
                lab_details = lab_details2;
            else if(title.compareTo("Dentist")==0)
                lab_details = lab_details3;
            else if(title.compareTo("Surgeon")==0)
                lab_details = lab_details4;
            else if(title.compareTo("Cardeologist")==0)
                lab_details = lab_details5;

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity (new Intent( LabDetailsActivity.this, FindLabsActivity.class));
                     }
            });
            list = new ArrayList();
            for(int i=0;i<lab_details.length; i++) {
                item.put( "line1", lab_details[i][0]);
                item.put( "line2", lab_details[i][1]);
                item.put( "line3", lab_details[i][2]);
                item.put( "line4", lab_details[i][3]);
                item.put( "line5", "Cons Fees: "+lab_details[i][4]+"/-");
                list.add( item );
            }
            sa = new SimpleAdapter( this, list,
                    R.layout.multi_lines,
                    new String[] {"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
            ListView lst= findViewById(R.id.listViewDD);
            lst.setAdapter (sa);


            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it = new Intent( LabDetailsActivity.this, BookAppointmentActivity.class);
                    it.putExtra( "text1", title);
                    it.putExtra( "text2", lab_details[i][0]);
                    it.putExtra( "text3", lab_details[i][1]);
                    it.putExtra("text4", lab_details[i][3]);
                    it.putExtra("text5", lab_details[i][4]);
                    startActivity (it);
                }
            });

        }
}
