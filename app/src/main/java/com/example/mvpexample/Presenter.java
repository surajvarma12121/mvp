package com.example.mvpexample;

import android.content.Context;

public class Presenter implements Contract.Presenter, Contract.Model.OnFinishedListener {

    private Contract.View mainView;


    private Contract.Model model;
    public Presenter(Contract.View mainView, Contract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }


    @Override
    public void onFinished(String[] data) {
        mainView.setData(data);
        mainView.hideProgress();

    }

    @Override
    public void onButtonClick(Context applicationContext) {

        if (mainView != null) {
            mainView.showProgress();
        }
        model.getNextCourse(this,applicationContext);

    }
}
