package com.example.duana.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duana.R;
import com.example.duana.ThongtinTk;
import com.facebook.AccessToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTaikhoan extends Fragment {

    ImageView view;
    FirebaseAuth firebaseAuth;
    TextView txtAccount, txtmail;
    ImageView imageView;

    public FragmentTaikhoan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_taikhoan, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        txtAccount = v.findViewById(R.id.txtname);
        imageView = v.findViewById(R.id.imgperson);
//        txtAccount.setText(user.getEmail());
        txtmail = v.findViewById(R.id.txtemail);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri uri = user.getPhotoUrl();
        txtAccount.setText(name);
        txtmail.setText(email);
        Picasso.get().load(uri).into(imageView);

        view = v.findViewById(R.id.xu);
        Animation animFade = AnimationUtils.loadAnimation(getContext(), R.anim.animo);
        view.startAnimation(animFade);
        LinearLayout linearLayout = v.findViewById(R.id.caidat);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ThongtinTk.class));
            }
        });
        return v;
    }

}
