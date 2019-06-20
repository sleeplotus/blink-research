package com.tiger.blink.configuration.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Created by SleepLotus on 2019-06-20
 */
@Getter
@Setter
@SuppressWarnings("WeakerAccess")
public class Application {
    private Profiles profiles;

    @Getter
    @Setter
    public static class Profiles {
        private String active;
    }
}


