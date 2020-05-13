package com.javacourse.view;

public class Page {
    String viewLocation;
    DispatchType dispatchType;

    public Page(String viewLocation, DispatchType dispatchType) {
        this.viewLocation = viewLocation;
        this.dispatchType = dispatchType;
    }

    public String getViewLocation() {
        return viewLocation;
    }

    public void setViewLocation(String viewLocation) {
        this.viewLocation = viewLocation;
    }

    public DispatchType getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(DispatchType dispatchType) {
        this.dispatchType = dispatchType;
    }

    public enum DispatchType{
        FORWARD,
        REDIRECT
    }
}
