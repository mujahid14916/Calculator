package com.abu.temp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            Toast.makeText(getApplicationContext(), "Method Called", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    Boolean dotUsed = false;
    Boolean dotAnyVar = false;
    double temp, result = 0;
    StringBuilder sb = new StringBuilder();
    char c;

    @Override
    public void onClick(View view) {
        TextView tv = (TextView) findViewById(R.id.textView);
        switch (view.getId()) {
            case R.id.b1:
                tv.append("1");
                sb.append("1");
                break;
            case R.id.b2:
                tv.append("2");
                sb.append("2");
                break;
            case R.id.b3:
                tv.append("3");
                sb.append("3");
                break;
            case R.id.b4:
                tv.append("4");
                sb.append("4");
                break;
            case R.id.b5:
                tv.append("5");
                sb.append("5");
                break;
            case R.id.b6:
                tv.append("6");
                sb.append("6");
                break;
            case R.id.b7:
                tv.append("7");
                sb.append("7");
                break;
            case R.id.b8:
                tv.append("8");
                sb.append("8");
                break;
            case R.id.b9:
                tv.append("9");
                sb.append("9");
                break;
            case R.id.b0:
                tv.append("0");
                sb.append("0");
                break;

            case R.id.bdot:
                if (!dotUsed) {
                    tv.append(".");
                    dotUsed = true;
                }
                break;

            case R.id.bdel:
                if (tv.getText().length() > 0) {
                    tv.setText(tv.getText().toString().toCharArray(), 0, tv.getText().toString().length() - 1);
                    sb.delete(sb.length() - 1, sb.length());
                }
                break;

            case R.id.badd:
                temp = Double.parseDouble(sb.toString());
                dotUsed = false;
                tv.append("+");
                sb.delete(0, sb.length());
                c = '+';
                break;

            case R.id.bsub:
                temp = Double.parseDouble(sb.toString());
                dotUsed = false;
                tv.append("-");
                sb.delete(0, sb.length());
                c = '-';
                break;

            case R.id.bmul:
                temp = Double.parseDouble(sb.toString());
                dotUsed = false;
                tv.append("*");
                sb.delete(0, sb.length());
                c = '*';
                break;

            case R.id.bdiv:
                temp = Double.parseDouble(sb.toString());
                dotUsed = false;
                tv.append("/");
                sb.delete(0, sb.length());
                c = '/';
                break;


            case R.id.beq:

                Log.d("Value1", Double.toString(temp));
                Log.d("Value2", Double.toString(Double.parseDouble(sb.toString())));
                Log.d("Product", Double.toString(temp * Double.parseDouble(sb.toString())));
                switch (c) {
                    case '+':
                        result = temp + Double.parseDouble(sb.toString());
                        break;
                    case '-':
                        result = temp - Double.parseDouble(sb.toString());

                        break;
                    case '*':
                        result = temp * Double.parseDouble(sb.toString());

                        break;
                    case '/':
                        result = temp / Double.parseDouble(sb.toString());

                        break;
                }
                sb.delete(0, sb.length());

                temp = 0.0;
                c = '.';
                if (dotAnyVar)
                    sb.append(String.format("%.2f", result));
                else
                    sb.append(String.format("%.0f", result));
                tv.setText(sb.toString());
                break;
        }
        if(dotUsed)
            dotAnyVar = true;
        Log.d("Builder", sb.toString());
    }
}
