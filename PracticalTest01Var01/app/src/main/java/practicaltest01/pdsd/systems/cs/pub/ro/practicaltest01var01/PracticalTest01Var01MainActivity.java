package practicaltest01.pdsd.systems.cs.pub.ro.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01Var01MainActivity extends Activity {

    protected CheckBox check1,check2,check3;
    protected EditText edit_text;
    private int count;

    private  CompoundButton compoundButton = new CompoundButton();
    private ButtonClickListener buttonClickListener = new ButtonClickListener();




    private class ButtonClickListener implements Button.OnClickListener {

        String text = new String();
        boolean phone = ((CheckBox) findViewById(R.id.checkBox)).isChecked();
        boolean email = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();
        boolean msg = ((CheckBox) findViewById(R.id.checkBox3)).isChecked();

        

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button:
                    Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var01SecondaryActivity");
                    intent.putExtra("string_concat", "bla");
                    startActivityForResult(intent, 2014);
                    break;
            }
        }
    }

        private class CompoundButton implements android.widget.CompoundButton.OnCheckedChangeListener {


        @Override
        public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {

                        if(buttonView.isChecked()){
                            count++;
                        }
                        else {
                            count--;
                        }

                         edit_text.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        check1= (CheckBox)findViewById(R.id.checkBox);
        check2= (CheckBox)findViewById(R.id.checkBox2);
        check3= (CheckBox)findViewById(R.id.checkBox3);
        edit_text = (EditText)findViewById(R.id.editText);
        edit_text.setText(String.valueOf(0));
        check1.setOnCheckedChangeListener(compoundButton);
        check2.setOnCheckedChangeListener(compoundButton);
        check3.setOnCheckedChangeListener(compoundButton);
        count=0;

        Button buton = (Button)findViewById(R.id.button);
        buton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            boolean caseta1 = savedInstanceState.getBoolean("phone");
            check1.setChecked(caseta1);
            boolean caseta2 = savedInstanceState.getBoolean("email");
            check2.setChecked(caseta2);
            boolean caseta3 = savedInstanceState.getBoolean("msg");
            check3.setChecked(caseta3);

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        boolean isChecked1 = ((CheckBox) findViewById(R.id.checkBox)).isChecked();
        boolean isChecked2 = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();
        boolean isChecked3 = ((CheckBox) findViewById(R.id.checkBox3)).isChecked();
        savedInstanceState.putBoolean("phone", isChecked1);
        savedInstanceState.putBoolean("email", isChecked2);
        savedInstanceState.putBoolean("msg", isChecked3);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var01_main, menu);
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
