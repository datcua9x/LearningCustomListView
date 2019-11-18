package vn.edu.usth.learningcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.usth.adapter.ContactAdapter;
import vn.edu.usth.model.Contact;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayList<Contact>listContact;
    ContactAdapter  contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addControl() {
        // LIST VIEW

        lvContact = findViewById(R.id.lvContact);
        // INFORMATION SOURCE

        listContact = new ArrayList<>();
        listContact.add(new Contact(1,"NGUYEN HUU CHI DAT","0857257005"));
        listContact.add(new Contact(2,"NGUYEN THUC HIEN","0385525348"));
        listContact.add(new Contact(3,"TRAN DUY THANH","0968214975"));

        //ADAPTER
        // with normal we use R.layout.simple list item but when custom, we use layout item
        contactAdapter = new ContactAdapter(MainActivity.this,R.layout.item,listContact);

        lvContact.setAdapter(contactAdapter);

    }

    private void addEvent() {
    }
}
