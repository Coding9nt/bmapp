package com.baseballmanager.bmapp.util.type;

public enum ControllerType {
    STADIUM_MENU(new String[] {
            "야구장등록",
            "야구장목록"
    }),





    ;

    private final String[] controllerType;

    ControllerType(String[] controllerType) {
        this.controllerType = controllerType;
    }

    public String[] getControllerType() {
        return controllerType;
    }

}
