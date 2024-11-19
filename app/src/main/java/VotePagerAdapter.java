package com.example.home;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class VotePagerAdapter extends FragmentStateAdapter {
    public VotePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MobileFragment();
            case 1:
                return new VoterIDFragment();
            default:
                throw new IllegalArgumentException("Invalid position");
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
