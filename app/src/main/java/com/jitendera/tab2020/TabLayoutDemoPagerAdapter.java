/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.jitendera.tab2020;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by hasegawa on 8/5/15.
 */
public class TabLayoutDemoPagerAdapter extends FragmentPagerAdapter {
    private int mPageCount;
    Button bt;
    TextView tv2;

    public TabLayoutDemoPagerAdapter(FragmentManager fm) {
        super(fm);

        addPage();
    }

    @Override
    public Fragment getItem(int position) {
        return ContentFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mPageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Integer.toString(position);
    }

    public void addPage() {
        mPageCount += 1;
        notifyDataSetChanged();
    }

    public void removePage() {
        if (mPageCount <= 1) {
            return;
        }

        mPageCount -= 1;
        notifyDataSetChanged();
    }

    public static class ContentFragment extends Fragment {
        private  static final String ARG_PAGE_NUMBER = "page_number";

        public static ContentFragment newInstance(int pageNumber) {
            ContentFragment fragment = new ContentFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE_NUMBER, pageNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.pager_content_fragment, container, false);
        }



        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            int pageNumber = getArguments().getInt(ARG_PAGE_NUMBER);

            TextView tv = (TextView) view.findViewById(android.R.id.text1);
           final TextView tv2 = (TextView) view.findViewById(android.R.id.text2);
            Button bt = (Button) view.findViewById(R.id.btnOne);
            tv.setText(Integer.toString(pageNumber));
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();

                    tv2.setText("hello");

                }
            });
            if(savedInstanceState!=null){
                //savedInstanceState.getString("he",tv2);
            }

        }

        @Override
        public void onSaveInstanceState( @NonNull Bundle outState) {

            super.onSaveInstanceState(outState);
           //outState.getString("he");

        }


    }
}
