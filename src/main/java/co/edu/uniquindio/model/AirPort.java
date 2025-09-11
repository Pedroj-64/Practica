package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public final class AirPort {

    private String name;
    private List<Fly> flies;
    private static AirPort instance;

    private AirPort(String name) {
        this.name = name;
        flies = new ArrayList<>();

    }

    public static AirPort getInstance(String name) {
        if (instance == null) {
            instance = new AirPort(name);
            return instance;
        }

        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
