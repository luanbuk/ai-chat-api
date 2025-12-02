package com.bkwblz.aichat.dtos;

import javax.validation.constraints.NotNull;

public record ChatRequestDTO(@NotNull String message) {
}
