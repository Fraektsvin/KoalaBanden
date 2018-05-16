package Acquaintance;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public enum AccessLevel {
    SYSTEMADMINISTRATOR(1), SAGSBEHANDLER(2), BORGER(3), VÆRGE(4), PARTSREPRÆSENTANT(5);

    private int code;

    AccessLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static AccessLevel fromInt(int i) {
        for (AccessLevel a : AccessLevel.values()) {
            if (a.getCode() == i) {
                return a;
            }
        }
        throw new ValueException("no access level with code: " + i);
    }
}
