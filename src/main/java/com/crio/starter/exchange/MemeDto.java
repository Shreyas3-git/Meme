package com.crio.starter.exchange;

import lombok.NonNull;

public class MemeDto {

    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String caption;
    @NonNull
    private String url;
}