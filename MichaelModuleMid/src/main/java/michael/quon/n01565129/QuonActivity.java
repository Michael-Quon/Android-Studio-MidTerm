// Michael Quon N01565129
package michael.quon.n01565129;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class QuonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MichaelFragment());
        fragmentList.add(new QuonFragment());
        fragmentList.add(new N01565129Fragment());

        ViewPager2 viewPager = findViewById(R.id.MichaelviewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this, fragmentList));

        // Disable swiping
        viewPager.setUserInputEnabled(false);

        TabLayout tabLayout = findViewById(R.id.MichaeltabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    // change the tab name
                    switch (position) {
                        case 0:
                            tab.setText(R.string.michael);
                            break;
                        case 1:
                            tab.setText(R.string.quon);
                            break;
                        case 2:
                            tab.setText(R.string.n01565129);
                            break;
                    }
                }
        ).attach();
    }
}