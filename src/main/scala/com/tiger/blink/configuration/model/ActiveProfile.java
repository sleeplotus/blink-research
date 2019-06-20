package com.tiger.blink.configuration.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Created by SleepLotus on 2019-06-20
 */
@Getter
@Setter
@SuppressWarnings("WeakerAccess")
public class ActiveProfile {
    private Kafka kafka;

    @Getter
    @Setter
    public static class Kafka {
        private String bootstrapServers;

        private Audit audit;

        @Getter
        @Setter
        public static class Audit {
            private String groupId;

            private String topic;
        }
    }
}
