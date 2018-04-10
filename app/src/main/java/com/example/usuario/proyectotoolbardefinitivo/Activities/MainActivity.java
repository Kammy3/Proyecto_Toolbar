package com.example.usuario.proyectotoolbardefinitivo.Activities;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.usuario.proyectotoolbardefinitivo.Fragments.FirstFragment;
import com.example.usuario.proyectotoolbardefinitivo.Fragments.SecondFragment;
import com.example.usuario.proyectotoolbardefinitivo.R;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  //para implementarlo

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout);   //se crean los tab
        //Se añaden pestañas.  usamos metodo "addTab" que recibe el nuevo objeto "TabLayout.Tab"
            tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
            tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
            tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //Para crear iconos en las pestañas:
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_boton));

        tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {

                        switch (tab.getPosition()) {
                            case 1:
                                FirstFragment ff=new FirstFragment();
                                break;

                            case 2:
                               SecondFragment sf=new SecondFragment();
                               break;
                        }


                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        Fragment fragment=null;
                        FragmentTransaction replace = ft.replace(android.R.id.content, null);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft.commit();
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                }
        );

        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
            //para que escuche el cambio de pestañas
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  //permite sacar opciones
    getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
