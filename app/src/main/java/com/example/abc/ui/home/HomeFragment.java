package com.example.abc.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.abc.OperationFragment;
import com.example.abc.R;
import com.example.abc.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private FragmentHomeBinding binding;
    private EditText b1,b2;
    private Button operasi;
    Double a1,a2;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAwal;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        b1 = binding.edtB1;
        b2 = binding.edtB2;

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.operasi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.operasi){
            OperationFragment operationFragment = new OperationFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            a1 = Double.parseDouble(b1.getText().toString().trim());
            a2 = Double.parseDouble(b2.getText().toString().trim());
            Bundle bundle = new Bundle();
            bundle.putDouble("a1", a1);
            bundle.putDouble("a2", a2);
            operationFragment.setArguments(bundle);
//            Log.e("bundle", String.valueOf(getArguments().getDouble("a1")));
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, operationFragment, OperationFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }else{
            Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
        }
    }
}