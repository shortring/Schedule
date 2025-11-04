package com.memo.dto;

import lombok.Getter;

@Getter
public class UpdateMemoResponse {
    private final Long id;
    private final String contents;


    public UpdateMemoResponse(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }
}
