package mk.test.matka_v2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import mk.test.matka_v2.activity.DetailsActivity;
import mk.test.matka_v2.R;
import mk.test.matka_v2.adapter.ExponentsAdapter;
import mk.test.matka_v2.interfaces.ExponentClickInterface;
import mk.test.matka_v2.model.Exponent;
import mk.test.matka_v2.model.ExponentResponse;

public class HomeFragment extends Fragment implements ExponentClickInterface {
    public static final String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView exponentsRecyclerView;
    private ExponentsAdapter adapter;

    private ArrayList<Exponent> exponents = new ArrayList<>();

    Gson gson;

    public HomeFragment(){}

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        exponentsRecyclerView = view.findViewById(R.id.exponents_recycler_view);
        exponentsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        gson = new Gson();
        String json = loadJSONFromAsset();

        ExponentResponse exponentResponse = gson.fromJson(json, ExponentResponse.class);
        exponents = exponentResponse.getExponents();

        adapter = new ExponentsAdapter(getActivity(), exponents, this);
        exponentsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onExponentClick(int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("Exponent", exponents.get(position));
        startActivity(intent);
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getActivity().getAssets().open("exponentsJson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}