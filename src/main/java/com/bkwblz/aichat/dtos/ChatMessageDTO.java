package com.bkwblz.aichat.dtos;

import javax.validation.constraints.NotNull;

public record ChatMessageDTO(@NotNull String message) {
}
