package dev.adi.hybrid_template;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    private NavigationView nav;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        nav = (NavigationView) findViewById(R.id.nav);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String selectedItem = item.getTitle().toString();
                String navLink = NavLinks.links.get(selectedItem);

                changePage(navLink);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        webView = (WebView) findViewById(R.id.main_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        changePage("about");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    private void changePage(String link) {
        webView.loadUrl(String.format("file:///android_asset/%s.html", link));
    }
}
