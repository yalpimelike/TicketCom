package com.melikesivrikaya.notificationservice.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String NO_SAVE = "Notification not save.";
    public static final String ERROR_REPO = "An error occurred while retrieving information from the database.";
}
