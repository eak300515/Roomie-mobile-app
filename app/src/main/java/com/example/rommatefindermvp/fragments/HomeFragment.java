package com.example.rommatefindermvp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rommatefindermvp.MainActivity;
import com.example.rommatefindermvp.R;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {

    private CardView logoutCardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize the CardView for logout
        logoutCardView = view.findViewById(R.id.logout_cardview);

        // Set onClickListener for the logout card
        logoutCardView.setOnClickListener(v -> logOutUser());

        return view;
    }

    private void logOutUser() {
        // Sign out the user from Firebase Authentication
        FirebaseAuth.getInstance().signOut();

        // Show a toast message
        Toast.makeText(getActivity(), "Logged out successfully", Toast.LENGTH_SHORT).show();

        // Redirect to MainActivity (Login screen)
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);  // Clears the back stack
        startActivity(intent);
        getActivity().finish();  // Close the HomeActivity
    }
}
