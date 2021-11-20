package lession8.enums;

import java.io.IOException;

public enum Unit {

    C;

    public static Unit forValue(String value) throws IOException {
        if (value.equals("C")) return C;
        throw new IOException("Cannot deserialize Unit");
    }

    public String toValue() {
        switch (this) {
            case C:
                return "C";
        }
        return null;
    }
}
