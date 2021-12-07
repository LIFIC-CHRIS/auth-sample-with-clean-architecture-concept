package com.example.demo.common.vo;

import java.util.Objects;
import java.util.UUID;

public class EntityUUID {
    public String value;

    public EntityUUID() {
        this.value = UUID.randomUUID().toString();
    }

    private EntityUUID(final String value) {
        this.value = value;
    }

    public static EntityUUID of(final String id) {
        checkIsUUID(id);
        return new EntityUUID(id);
    }

    private static void checkIsUUID(final String mayUUID) {
        try {
            UUID.fromString(mayUUID);
        } catch (final IllegalArgumentException e) {
            throw new IllegalArgumentException("id is not UUID format");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityUUID that = (EntityUUID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
