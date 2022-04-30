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
import android.widget.Toast;

import com.example.abc.databinding.FragmentOperationBinding;

public class OperationFragment extends Fragment implements View.OnClickListener{
    private FragmentOperationBinding binding;
    private Button btnPlus, btnMin, btnDiv, btnMulti;
    Double a1,a2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOperationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.plusText.setOnClickListener(this);
        binding.minText.setOnClickListener(this);
        binding.multiText.setOnClickListener(this);
        binding.divText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        HasilFragment hasilFragment = new HasilFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        a1 = getArguments().getDouble("a1");
        a2 = getArguments().getDouble("a2");
        Bundle bundle = new Bundle();
        bundle.putDouble("a1", a1);
        bundle.putDouble("a2", a2);
        if(view.getId() == R.id.plus_text){
            bundle.putInt("operation", 0);
        }else if(view.getId() == R.id.min_text){
            bundle.putInt("operation", 1);
        }else if(view.getId() == R.id.multi_text){
            bundle.putInt("operation", 2);
        }else if(view.getId() == R.id.div_text){
            bundle.putInt("operation", 3);
        }else{
            Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
        }
        hasilFragment.setArguments(bundle);
        fragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, hasilFragment, HasilFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }
}