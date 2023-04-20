package com.goncharenko.musiczoneapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.goncharenko.musiczoneapp.R;
import com.goncharenko.musiczoneapp.activities.MainListener;
import com.goncharenko.musiczoneapp.activities.RegistrationAccountActivity;
import com.goncharenko.musiczoneapp.activities.SendingCodeActivity;
import com.goncharenko.musiczoneapp.validator.InputValidator;

public class EntryFragment extends Fragment {

    private EditText emailInput;
    private EditText passwordInput;

    private Button signInButton;
    private Button recoverPasswordButton;
    private Button signUpButton;

    private MainListener mainListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entry, container, false);

        emailInput = view.findViewById(R.id.email_input);
        passwordInput = view.findViewById(R.id.password_input);

        signInButton = view.findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(v);
            }
        });

        recoverPasswordButton = view.findViewById(R.id.recover_password);
        recoverPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoverPassword(v);
            }
        });

        signUpButton = view.findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp(v);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainListener) {
            mainListener = (MainListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SignInListener");
        }
    }

    public void signIn(View view) {
        if(InputValidator.checkEditText(getActivity(), InputValidator.isValidEmail(emailInput), emailInput) &&
                InputValidator.checkEditText(getActivity(), InputValidator.isValidPassword(passwordInput), passwordInput)) {
            if(isCorrectEmailAndPassword()) {
                AccountFragment accountFragment = new AccountFragment();
                mainListener.onSignedIn(true);
                setNewFragment(accountFragment);
            }
        }
    }

    public void recoverPassword(View view) {
        Intent intent = new Intent(getActivity(), SendingCodeActivity.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        Intent intent = new Intent(getActivity(),  RegistrationAccountActivity.class);
        startActivity(intent);
    }

    private boolean isCorrectEmailAndPassword(){
        return true;
    }

    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment).commit();
    }
}