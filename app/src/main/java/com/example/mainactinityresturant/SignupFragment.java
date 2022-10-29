package com.example.mainactinityresturant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText etusername;
    private EditText etpassword;
    private EditText etphonenumber;
    private Button btnsignup;
    private Button btnlogin;
    private EditText etemail;
 private EditText etconfirmpassword;
    public SignupFragment() {
        // Required empty public constructor
    }
    private  void instalize(){
        etusername =getView().findViewById(R.id.usernamefrag1);
        etpassword=getView().findViewById(R.id.passwordfrag1);
        etphonenumber=getView().findViewById(R.id.phonenumber);
        etconfirmpassword=getView().findViewById(R.id.confirmpassword);
        etemail=getView().findViewById(R.id.email);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, username, phonenumber, password, confirmpassword;
                email = etemail.getText().toString();
                username = etusername.getText().toString();
                phonenumber = etphonenumber.getText().toString();
                password = etpassword.getText().toString();
                confirmpassword = etconfirmpassword.getText().toString();

                if (email.trim().isEmpty() || username.trim().isEmpty() || phonenumber.trim().isEmpty() || password.trim().isEmpty() || confirmpassword.trim().isEmpty()) {

                    return;
                }
                if (!isValidEmail(email)) {

                    return;
                }


                if (password.equals(confirmpassword)) {

                }
                if(!isValidPhoneNumber(phonenumber))
                {

                }



            }
        });
btnlogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //الانتقال الى فراغمينت اللوج ان
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.signup, new Loginfragmentcoustumer());
        ft.commit();
    }
    //go to the menu
});




    }
    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }




    public static boolean isValidPhoneNumber(CharSequence target) {
        if (target == null || target.length() != 10) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
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
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }
}