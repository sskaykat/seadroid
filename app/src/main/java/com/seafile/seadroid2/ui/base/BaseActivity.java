package com.seafile.seadroid2.ui.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.seafile.seadroid2.R;
import com.seafile.seadroid2.framework.helper.NightModeHelper;

/**
 * A base activity that handles common functionality in the app. This includes Action Bar tweaks.
 */
public class BaseActivity extends AppCompatActivity {

    // Primary toolbar and drawer toggle
    private Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (mActionBarToolbar != null) {
                // Depending on which version of Android you are on the Toolbar or the ActionBar may be
                // active so the a11y description is set here.
                mActionBarToolbar.setNavigationContentDescription(getResources().getString(R.string
                        .navdrawer_description_a11y));
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getActionBarToolbar();
    }
}
