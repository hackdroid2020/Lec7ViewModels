package edu.tomerbu.lec7viewmodels.ui.main;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.tomerbu.lec7viewmodels.model.main.WordsDataSource;

public class MainViewModel extends ViewModel {
    //model:
    private WordsDataSource ds = new WordsDataSource();
    private String[] words;
    private int i = 0;

    //Live Data: allows us to observe this word (when the word changes -> update)
    private MutableLiveData<String> word = new MutableLiveData<>();

    //ctor:
    public MainViewModel() {
        words = ds.getWords();
        //timer to randomize the current word:
        CountDownTimer cdt = new CountDownTimer(60_000, 2_000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //if (i > words.length) i = 0;
                word.setValue(words[i++ % words.length]);
            }
            @Override
            public void onFinish() {
                word.setValue("Done!");
            }
        };
        //start the timer:
        cdt.start();
    }
    //expose Word as Live Data: (REAL Time)
    //publicly expose word as regular LiveData (Not Mutable)
    public LiveData<String> getWord(){
        return word;
    }
}
