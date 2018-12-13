package com.example.mohsen.exampletest.connection.retrofit;

import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class AnnotatedConverters {
    public static final class AnnotatedConverterFactory extends Converter.Factory {
        private final Map<Class<? extends Annotation>, Converter.Factory> factories;

        AnnotatedConverterFactory(Map<Class<? extends Annotation>, Converter.Factory> factories) {
            this.factories = new LinkedHashMap<>(factories);
        }

        @Override
        public @Nullable
        Converter<ResponseBody, ?> responseBodyConverter(
                Type type, Annotation[] annotations, Retrofit retrofit) {
            for (Annotation annotation : annotations) {
                Converter.Factory factory = factories.get(annotation.annotationType());
                if (factory != null) {
                    return factory.responseBodyConverter(type, annotations, retrofit);
                }
            }
            return null;
        }

        @Override
        public @Nullable
        Converter<?, RequestBody> requestBodyConverter(Type type,
                                                       Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
            for (Annotation annotation : parameterAnnotations) {
                Converter.Factory factory = factories.get(annotation.annotationType());
                if (factory != null) {
                    return factory.requestBodyConverter(type, parameterAnnotations, methodAnnotations,
                            retrofit);
                }
            }
            return null;
        }

        public static final class Builder {
            private final Map<Class<? extends Annotation>, Converter.Factory> factories =
                    new LinkedHashMap<>();

            public Builder add(Class<? extends Annotation> cls, Converter.Factory factory) {
                if (cls == null) {
                    throw new NullPointerException("cls == null");
                }
                if (factory == null) {
                    throw new NullPointerException("factory == null");
                }
                factories.put(cls, factory);
                return this;
            }

            public AnnotatedConverterFactory build() {
                return new AnnotatedConverterFactory(factories);
            }
        }
    }
}
