package mk.test.matka_v2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mk.test.matka_v2.R;
import mk.test.matka_v2.activity.WebViewActivity;

public class ContactFragment extends Fragment {
    public static final String TAG = ContactFragment.class.getSimpleName();

    private TextView phoneNumber;
    private ImageView contactCover, busToMatka, taxiToMatka, planeToSkopje, busToSkopje, trainToSkopje;

    public ContactFragment(){}

    public static ContactFragment newInstance(){
        return new ContactFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        phoneNumber = view.findViewById(R.id.phone_number);
        contactCover = view.findViewById(R.id.contact_cover);
        busToMatka = view.findViewById(R.id.busToMatka);
        taxiToMatka = view.findViewById(R.id.taxiToMatka);
        planeToSkopje = view.findViewById(R.id.planeToSkopje);
        busToSkopje = view.findViewById(R.id.busToSkopje);
        trainToSkopje = view.findViewById(R.id.trainToSkopje);

        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                startActivity(intent);
            }
        });

        contactCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com/maps/search/matka/@41.9528457,21.2979605,277m/data=!3m1!1e3";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(intent);
            }
        });

        busToMatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_KEY, "http://jsp.com.mk/PlanskiVozenRed.aspx");
                startActivity(intent);
            }
        });

        taxiToMatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_KEY, "https://zk.mk/taksi-kompanii/skopje");
                startActivity(intent);
            }
        });

        planeToSkopje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_KEY, "http://skp.airports.com.mk/default.aspx?ItemID=345");
                startActivity(intent);
            }
        });

        busToSkopje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_KEY, "http://sas.com.mk/VozenRed.aspx");
                startActivity(intent);
            }
        });

        trainToSkopje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_KEY, "https://mzt.mk/pristigane-vo-skopje/?lang=mk");
                startActivity(intent);
            }
        });
    }
}
