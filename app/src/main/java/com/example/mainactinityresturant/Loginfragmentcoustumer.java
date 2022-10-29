package com.example.mainactinityresturant;

import static android.widget.Toast.*;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Loginfragmentcoustumer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Loginfragmentcoustumer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
private EditText etusername;
    private EditText password;
    private Button btnlogin;
    private Button btnsignup;
private ImageView imageView;
private TextView textView;
    public Loginfragmentcoustumer() {
        // Required empty public constructor
    }
private  void instalize(){
        etusername =getView().findViewById(R.id.usernamefrag1);
        password=getView().findViewById(R.id.passwordfrag1);
        btnlogin=getView().findViewById(R.id.button);
        imageView=getView().findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.loginrest);
           textView=getView().findViewById(R.id.textView2);
           textView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //go to change password activity
               }
           });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, etpassword;

                username = etusername.getText().toString();

                etpassword = password.getText().toString();


                if (username.trim().isEmpty() || etpassword.trim().isEmpty()) {
                    Toast.makeText(getContext(), "SOMTHING FAILED ! " +"", Toast.LENGTH_SHORT).show();
                    return;
                    // IF THERE IS NO USER (GO TO SIGNUP OTOMATIC)
                }

            }

//THE COUSTUMER HAVE TWO WAYS TO CREATE USER , THE FIRST WAY "IF THERE IS NI ACOUNT OTOMATIC GO THE CREATE USER" , "CLICK BUTTON SIGN UP"
        });
        // NO USER (CREATE USER)
        btnsignup=getView().findViewById(R.id.btnlogin);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signup, new SignupFragment());
                ft.commit();


            }
        });


//go to the menu


}
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Loginfragmentcoustumer newInstance(String param1, String param2) {
        Loginfragmentcoustumer fragment = new Loginfragmentcoustumer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loginfragment, container, false);
    }


}