package com.rever;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "mainview")
public class MainView extends VerticalLayout {
    public MainView() {
        add(new H3("Hello"));
    }
}
