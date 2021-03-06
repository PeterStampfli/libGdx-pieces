package com.libgdx.adventure;

/**
 * Created by peter on 11/3/16.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 11/2/16.
 *
 * Collects and disposes items, print log message upon disposal
 */

public class Disposer implements Disposable {

    private final List<Disposable> disposables;
    private final List<String> names;
    private final String TAG;

    /**
     * we might need different disposers for items that are used and disposed at different times
     *
     * @param tag for disposal message
     */
    public Disposer(String tag){
        disposables=new ArrayList<Disposable>();
        names=new ArrayList<String>();
        TAG=tag+" disposes";
    }

    /**
     * add a disposable item to the list
     *
     * @param disposable Item, to be disposed later
     * @param name for logging upon disposal
     */
    public void add(Disposable disposable, String name){
        disposables.add(disposable);
        names.add(name);
    }

    /**
     * dispose all collected items and clear the list
     */
    @Override
    public void dispose(){
        int i;
        String message;
        for (i = disposables.size()-1; i>=0;i--){
            Gdx.app.log(TAG,names.get(i));
            disposables.get(i).dispose();
        }
        disposables.clear();
        names.clear();
    }
}
