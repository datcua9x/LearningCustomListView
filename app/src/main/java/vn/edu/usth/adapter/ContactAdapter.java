package vn.edu.usth.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vn.edu.usth.learningcustomlistview.R;
import vn.edu.usth.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {
    // the screen used this layout
    Activity context;
    // layout for each line that you want to show (custom by your self)
    // resource is item
    int resource;
    // list of information source that you want to show on the screen
    List<Contact> objects;
    public ContactAdapter(Activity context, int resource,List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflater used to build normal layout into java code
        LayoutInflater inflater = this.context.getLayoutInflater();
        // this.resource = item
        View row = inflater.inflate(this.resource,null);

        TextView txtName = row.findViewById(R.id.txtName);
        TextView txtPhone = row.findViewById(R.id.txtPhone);
        ImageButton btnCall = row.findViewById(R.id.btnCall);
        ImageButton btnSms = row.findViewById(R.id.btnSms);
        ImageButton btnDetails = row.findViewById(R.id.btnDetails);

        //return contact hien tai muon ve
        final Contact contact = this.objects.get(position);

        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details(contact);

            }
        });
        return row;
    }

    private void details(Contact contact) {
        Toast.makeText(this.context,"You choose\n" + contact.getName() +"\n "+ contact.getPhone(),
                Toast.LENGTH_LONG).show();
    }
}
