package com.wantedpreonboardingbackend.error;

import lombok.Getter;

public enum ExceptionCode {
    NOSUCHFOUND(404, "NotFound"),
    ALREADYENROLL(404, "이미 지원했다잉"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
