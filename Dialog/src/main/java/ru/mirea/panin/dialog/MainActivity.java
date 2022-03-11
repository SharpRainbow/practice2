package ru.mirea.panin.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDialog(View v){
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void timeShowDialog(View v){
        DialogFragment fragment = new MyTimeDialogFragment();
        fragment.show(getSupportFragmentManager(), "Time Picker");
    }

    public void dateShowDialog(View v){
        DialogFragment fragment = new MyDateDialogFragment();
        fragment.show(getSupportFragmentManager(), "Date Picker");
    }

    public void progShowDialog(View v){
        DialogFragment fragment = new MyProgressDialogFragment();
        fragment.show(getSupportFragmentManager(), "Progress");
    }

    void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
        String mins = Integer.toString(minutes);
        if(minutes < 10)
            mins = "0" + mins;
        ((TextView) findViewById(R.id.textView)).setText(hours + ":" + mins);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String mo = Integer.toString(month+1);
        String d = Integer.toString(day);
        if(month < 9)
            mo = "0" + mo;
        if(day < 10)
            d = "0" + d;
        ((TextView) findViewById(R.id.textView)).setText(d + "." + mo + "." + year);
    }
}