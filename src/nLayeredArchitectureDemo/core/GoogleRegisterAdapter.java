package nLayeredArchitectureDemo.core;

import Google.GoogleRegisterManager;

public class GoogleRegisterAdapter implements GoogleRegisterService{
    @Override
    public void registerToSystem(String message) {
        GoogleRegisterManager googleRegisterManager = new GoogleRegisterManager();
        googleRegisterManager.send(message);
    }
}
