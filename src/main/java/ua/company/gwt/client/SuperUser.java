package ua.company.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import ua.company.gwt.client.interfaces.MainContainer;
import ua.company.gwt.client.services.GwtService;

public class SuperUser implements EntryPoint {

    private String msisdn;

    public void onModuleLoad() {
        MainContainer container = new MainContainer();
        GwtService.App.getInstance().storeUserInSession(new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(Void result) {
                GwtService.App.getInstance().getUserFromSession(new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable caught) {

                    }

                    @Override
                    public void onSuccess(String result) {
                        msisdn = result;
                    }
                });
            }
        });

        DOM.getElementById("loading").removeFromParent();
        RootLayoutPanel.get().add(container);

    }
}
