package tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ezztech.retrofitexample.R;

/**
 * Created by Kofil on 9/20/15.
 */
public class EzzePagerAdapter extends FragmentPagerAdapter {

    private String[] titles = {"Search", "Consult", "Profile", "Appointments"};
    private int[] icons = {R.drawable.ic_escape, R.drawable.ic_hotel, R.drawable.ic_bookings, R.drawable.ic_invite};

    public EzzePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new Fragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public int getPageIcon(int position) {
        return icons[position];
    }
}
