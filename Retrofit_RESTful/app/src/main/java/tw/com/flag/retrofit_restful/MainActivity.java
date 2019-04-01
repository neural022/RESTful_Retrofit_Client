package tw.com.flag.retrofit_restful;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    TextView txv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findView();

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

    public void findView() {
        txv1 = (TextView) findViewById(R.id.txv1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        MyApiService apiService = RetrofitManager.getClient().create(MyApiService.class);
        switch (v.getId())
        {
            case R.id.btn1:
                //  get + parameter
                // apiService.getString("你好嗎").enqueue(new Callback<List<Datas>>() {
                //  get
                apiService.getData().enqueue(new Callback<List<Datas>>() {
                    @Override
                    public void onResponse(Call<List<Datas>> call, Response<List<Datas>> response) {
                        StringBuffer sb = new StringBuffer();
                        List<Datas> list = response.body();
                        for(Datas d : list) {
                            sb.append(d.getHello());
                            sb.append("\n");
                        }
                        txv1.setText(sb.toString());
                    }

                    @Override
                    public void onFailure(Call<List<Datas>> call, Throwable t) {

                    }
                });
                break;
            case R.id.btn2:
                //  post
                apiService.postData(3).enqueue(new Callback<List<Datas>>() {
                    @Override
                    public void onResponse(Call<List<Datas>> call, Response<List<Datas>> response) {
                        StringBuffer sb = new StringBuffer();
                        List<Datas> list = response.body();
                        for(int i=0;i<list.size();i++) {
                            Datas d;
                            d = list.get(i);
                            sb.append(d.getValue());
                            sb.append("\n");
                        }
                        txv1.setText(sb.toString());
                    }

                    @Override
                    public void onFailure(Call<List<Datas>> call, Throwable t) {

                    }
                });
                break;
        }
    }
}
