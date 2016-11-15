package com.libgdx.adventure;

/**
 * Created by peter on 11/9/16.
 */

import com.badlogic.gdx.Gdx;

/**
 * create a platform specific service implementing an interface Service
 * uses the simple factory pattern for creation and the strategy pattern for its use
 */

public class SpecialServiceFactory {

    public Service getService(){
        switch (Gdx.app.getType()) {
            case Android:
                return new AndroidService();
            case Desktop:
                return new DesktopService();
            case HeadlessDesktop:
                break;
            case Applet:
                break;
            case WebGL:
                break;
            case iOS:
                break;
        }
        return new NullService();
    }

    public class DesktopService implements Service{

        @Override
        public void execute(){
            Gdx.app.log("Service: ", "for desktop");
        }
    }

    public class AndroidService implements Service{

        @Override
        public void execute(){
            Gdx.app.log("Service: ", "for android");
        }
    }

    public class NullService implements Service{

        @Override
        public void execute(){}
    }
}

/* how to do:

    declare the service:
	public Service service;

    create:
	service=(new SpecialServiceProvider()).getService();

    use:
	service.execute();
*/