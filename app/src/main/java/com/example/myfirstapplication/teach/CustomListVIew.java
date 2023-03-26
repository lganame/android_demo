package com.example.myfirstapplication.teach;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.XiuRen;

public class CustomListVIew extends AppCompatActivity {
    String[] Texts = {"Github", "Gitee", "Gitlab", "Android开源项目命令", "X-1", "P-1", "Hentai", "X-zh-cn", "朱古力", "JAVOUT", "AVGirls", "XNXX"};
    int[] Images = {R.drawable.ic_switch,
            R.drawable.ic_star_black_24dp,
            R.drawable.ic_add_alert_black_24dp,
            R.drawable.ic_view_list_black_24dp,
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_web_black_24dp
    };
    String[] urls = {
            "https://github.com/lganame",
            "https://gitee.com/lganav5",
            "https://gitlab.com/lganame",
            "https://p.codekk.com/",
            "https://www.xvideos.com/tags/sex-movie",
            "https://cn.pornhub.com/",
            "https://www.xvideos.com/tags/hentai",
            "https://www.xvideos.com/?k=%E5%9B%BD%E4%BA%A7&top",
            "https://pigav.com/",
            "https://javout.net/",
            "https://www.helloavgirls.com/hot",
            "https://www.xnxx.com/search/sex-movie"

    };
    ListView listView;
    Toast myToast;
    XiuRen xiuRen = new XiuRen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view);
        listView = findViewById(R.id.listview);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), Texts, Images);
        listView.setAdapter(listViewAdapter);
        final Intent intent = new Intent(this, XiuRen.class);
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (myToast != null)
                    myToast.cancel();
                myToast = Toast.makeText(getApplicationContext(), " You clicked on item " + position, Toast.LENGTH_SHORT);
                myToast.show();
                Intent intent1=intent;
                startActivity(intent1.putExtra("url",urls[position]));
                /*
                switch (position) {
                    case 0: {

                    }
                    case 1: {

                    }
                    case 2: {

                    }
                    case 4: {

                    }
                    case 5: {

                    }
                    case 6: {

                    }
                    case 7: {

                    }
                    case 8: {

                    }
                    default:{
                        startActivity(intent1.putExtra("url",urls[position]));
                        break;
                    }

                }*/
            }
        });

    }

    class ListViewAdapter extends ArrayAdapter {
        String[] textArray;
        int[] imageArray;

        public ListViewAdapter(Context context, String[] texts, int[] images) {
            super(context, R.layout.custom_listview_layout, R.id.item_name, texts);
            this.textArray = texts;
            this.imageArray = images;
        }

        @NonNull
        @Override
        public View getView(int position, View ConvertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.custom_listview_layout, parent, false);
            ImageView mImage = row.findViewById(R.id.item_ic);
            TextView mtext = row.findViewById(R.id.item_name);
            mImage.setImageResource(imageArray[position]);
            mtext.setText(textArray[position]);
            return row;
        }
    }
}
