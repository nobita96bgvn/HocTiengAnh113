package com.nvh.hoannguyen.hoctienganh;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.view.PagerAdapter;


import com.nvh.hoannguyen.hoctienganh.cauhoi.DBHelper;
import com.nvh.hoannguyen.hoctienganh.hoctap.AnhvietFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.HoctuvungFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.HocvideoFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.HomeFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.KiemtratonghopFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.LuyenngheFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.NgheFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.TracnghiemFragment;
import com.nvh.hoannguyen.hoctienganh.hoctap.VietFragment;
import android.support.v4.view.PagerAdapter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        // PermissionClass.checkAndRequestPermissions(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();

        DBHelper db = new DBHelper(this);

        // Phương thức xoa database viết vào hàm MainActivity
//               try {
//            db.deleteDataBase();
//           Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//       } catch (SQLException e) {
//          e.printStackTrace();
//           Toast.makeText(this, "bi loi rui", Toast.LENGTH_SHORT).show();
//        }

        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

            HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,homeFragment,homeFragment.getTag()).commit();
            // Handle the camera action
        } else if (id == R.id.tuvung) {
            HoctuvungFragment hoctuvungFragment = new HoctuvungFragment();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,hoctuvungFragment,hoctuvungFragment.getTag()).commit();

        } else if (id == R.id.video) {
            HocvideoFragment hocvideoFragment = new HocvideoFragment();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,hocvideoFragment,hocvideoFragment.getTag()).commit();
        } else if (id == R.id.luyennghe) {
            LuyenngheFragment luyenngheFragment = new LuyenngheFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, luyenngheFragment, luyenngheFragment.getTag()).commit();
        }
         else if (id == R.id.tracnghiem) {
                 PermissionClass.checkAndRequestPermissions(this);
                TracnghiemFragment tracnghiemFragment = new TracnghiemFragment();
                FragmentManager manager= getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_main,tracnghiemFragment,tracnghiemFragment.getTag()).commit();
        }
      else if (id == R.id.viet) {
            VietFragment vietFragment = new VietFragment();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,vietFragment,vietFragment.getTag()).commit();
        } else if (id == R.id.nghe) {
            NgheFragment ngheFragment = new NgheFragment();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,ngheFragment,ngheFragment.getTag()).commit();
        }else if (id == R.id.anhviet) {
            AnhvietFragment anhvietFragment = new AnhvietFragment();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,anhvietFragment,anhvietFragment.getTag()).commit();
        }else if (id == R.id.kiemtratonghop) {
            KiemtratonghopFragment kiemtratonghopFragment= new KiemtratonghopFragment();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,kiemtratonghopFragment,kiemtratonghopFragment.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
