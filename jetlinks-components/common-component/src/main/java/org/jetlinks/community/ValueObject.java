package org.jetlinks.community;

import org.hswebframework.web.bean.FastBeanCopier;
import org.jetlinks.community.utils.TimeUtils;

import java.time.Duration;
import java.util.Date;
import java.util.Optional;

public interface ValueObject {

    Optional<Object> get(String name);

    default Optional<Integer> getInt(String name) {
        return get(name, Integer.class);
    }

    default int getInt(String name, int defaultValue) {
        return getInt(name).orElse(defaultValue);
    }

    default Optional<Long> getLong(String name) {
        return get(name, Long.class);
    }

    default long getLong(String name, long defaultValue) {
        return getLong(name).orElse(defaultValue);
    }

    default Optional<Duration> getDuration(String name) {
        return getString(name)
            .map(TimeUtils::parse);
    }

    default Duration getDuration(String name, Duration defaultValue) {
        return getDuration(name)
            .orElse(defaultValue);
    }

    default Optional<Date> getDate(String name) {
        return get(name, Date.class);
    }

    default Date getDate(String name, Date defaultValue) {
        return getDate(name).orElse(defaultValue);
    }

    default Optional<Double> getDouble(String name) {
        return get(name, Double.class);
    }

    default double getDouble(String name, double defaultValue) {
        return getDouble(name).orElse(defaultValue);
    }

    default Optional<String> getString(String name) {
        return get(name, String.class);
    }

    default String getString(String name, String defaultValue) {
        return getString(name).orElse(defaultValue);
    }

    default Optional<Boolean> getBoolean(String name) {
        return get(name, Boolean.class);
    }

    default boolean getBoolean(String name, boolean defaultValue) {
        return getBoolean(name).orElse(defaultValue);
    }

    default <T> Optional<T> get(String name, Class<T> type) {
        return get(name)
            .map(obj -> FastBeanCopier.DEFAULT_CONVERT.convert(obj, type, FastBeanCopier.EMPTY_CLASS_ARRAY));
    }

}
