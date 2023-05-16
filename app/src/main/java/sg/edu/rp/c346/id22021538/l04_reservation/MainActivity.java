package sg.edu.rp.c346.id22021538.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText phoneNumber;
    EditText noOfGuests;
    CheckBox smoking;
    Button btnDisplayAll;
    Button btnReset;
    TextView tvDisplayAll;
    DatePicker date;
    TimePicker time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameDisplay);
        phoneNumber = findViewById(R.id.phoneDisplay);
        noOfGuests = findViewById(R.id.guestDisplay);
        smoking = findViewById(R.id.checkSmoke);
        btnDisplayAll = findViewById(R.id.confirmButton);
        btnReset = findViewById(R.id.resetButton);
        tvDisplayAll = findViewById(R.id.viewAll);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);

        time.setCurrentHour(19);
        time.setCurrentMinute(30);
        date.init(2020, 6, 1, null);

        btnDisplayAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (smoking.isChecked()) {
                    int hour = time.getCurrentHour();
                    int minute = time.getCurrentMinute();

                    int day = date.getDayOfMonth();
                    int month = date.getMonth() + 1; // Month is zero-based, so adding 1
                    int year = date.getYear();

                    String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                    String selectedDate = String.format(Locale.getDefault(), "%d/%d/%d", day, month, year);
                    String reservationDetails = "Reservation: " + "\n"
                            + "Name: " + name.getText().toString() + "\n"
                            + "Phone Number: " + phoneNumber.getText().toString() + "\n"
                            + "No of Guests: " + noOfGuests.getText().toString() + "\n"
                            + "Smoking Area: Yes" + "\n"
                            + "Date: " + selectedDate + "\n"
                            + "Time: " + selectedTime;

                    tvDisplayAll.setText(reservationDetails);
                } else {
                    int hour = time.getCurrentHour();
                    int minute = time.getCurrentMinute();

                    int day = date.getDayOfMonth();
                    int month = date.getMonth() + 1; // Month is zero-based, so adding 1
                    int year = date.getYear();

                    String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                    String selectedDate = String.format(Locale.getDefault(), "%d/%d/%d", day, month, year);
                    String reservationDetails = "Reservation: " + "\n"
                            + "Name: " + name.getText().toString() + "\n"
                            + "Phone Number: " + phoneNumber.getText().toString() + "\n"
                            + "No of Guests: " + noOfGuests.getText().toString() + "\n"
                            + "Smoking Area: No" + "\n"
                            + "Date: " + selectedDate + "\n"
                            + "Time: " + selectedTime;

                    tvDisplayAll.setText(reservationDetails);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplayAll.setText("");
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
            }
        });
    }
}