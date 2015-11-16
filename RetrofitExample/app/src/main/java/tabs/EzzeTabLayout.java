package tabs;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezztech.retrofitexample.R;

/**
 * Created by Kofil on 9/20/15.
 */
public class EzzeTabLayout extends SlidingTabLayout {

    public static final float TAB_DIM_ALPHA = 0.5f;
    private View[] mTabLookup;
    private ViewPager mViewPager;
    private EzzePagerAdapter mAdapter;

    public EzzeTabLayout(Context context) {
        super(context);
        init();
    }

    public EzzeTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EzzeTabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mTabStrip.setBottomBorderColor(0);
        mTabStrip.setIndicatorThicknessDips(3);
        setCustomTabView(R.layout.toolbar_tab, 0);
    }

    public void setViewPager(ViewPager navigationPager) {
        mViewPager = navigationPager;
        mAdapter = (EzzePagerAdapter) navigationPager.getAdapter();
        mTabLookup = new View[mAdapter.getCount()];
        super.setViewPager(navigationPager, new ViewPager.OnPageChangeListener() {

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int pageIndex) {
                for (int i = 0; i < mTabLookup.length; i++) {
                    if (i != pageIndex) {
                        mTabLookup[i].animate().alpha(TAB_DIM_ALPHA).start();
                    } else {
                        mTabLookup[i].animate().alpha(1.0f).start();
                    }
                }
            }

            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    protected void populateView(View tabView, TextView textView, int position) {
        ImageView imageView = (ImageView) tabView;
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), mAdapter.getPageIcon(position)));
        if (position != this.mViewPager.getCurrentItem()) {
            imageView.setAlpha(TAB_DIM_ALPHA);
        }
        imageView.setContentDescription(this.mAdapter.getPageTitle(position));
        this.mTabLookup[position] = tabView;
    }
}
