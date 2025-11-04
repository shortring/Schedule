package com.memo.dto;

import lombok.Getter;

@Getter
public class CreateMemoResponse {
    private final Long id;
    private final String contents;

    public CreateMemoResponse(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }
}
