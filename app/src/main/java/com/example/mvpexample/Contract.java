package com.example.mvpexample;

import android.content.Context;

public interface Contract {
    public interface Model{
        interface OnFinishedListener{
            void onFinished(String[] data);
        }
        void getNextCourse(OnFinishedListener onFinishedListener, Context applicationContext);

    }
    public interface View{

        //to show pg
        void showProgress();
        //to hide pg
        void hideProgress();

        void setData(String [] data);

    }
    public interface Presenter{
        void onButtonClick(Context applicationContext);

       


    }


}
