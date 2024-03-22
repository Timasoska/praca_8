package com.example.prac_8;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.prac_8.databinding.ActivityDetailBinding;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
public class DetailActivity extends AppCompatActivity {
    public static final String SELECTED_ITEM = "SELECTED_ITEM";
    String selectedItem = "Не выбрано";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            selectedItem = extras.getString(SELECTED_ITEM);
    }
    @Override
    protected void onResume() {
        super.onResume();
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);
        if (fragment != null)
            fragment.setSelectedItem(selectedItem);
    }
}