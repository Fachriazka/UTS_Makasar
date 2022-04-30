package com.example.abc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.abc.databinding.FragmentHasilBinding;
import com.example.abc.ui.home.HomeFragment;


public class HasilFragment extends Fragment implements View.OnClickListener{
    private FragmentHasilBinding binding;
    private Button btnHome;
    Double a1, a2, hasil;
    Integer i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHasilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backtohome.setOnClickListener(this);

        a1 = getArguments().getDouble("a1");
        a2 = getArguments().getDouble("a2");
        i = getArguments().getInt("operation");

        if(i == 0){
            hasil = a1 + a2;
        }else if(i == 1){
            hasil = a1 - a2;
        }else if(i == 2){
            hasil = a1 * a2;
        }else if(i == 3){
            hasil = a1 / a2;
        }

        binding.hasil.setText(Double.toString(hasil));
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getParentFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        if(view.getId() == R.id.backtohome){
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, homeFragment, HomeFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }
    }
}