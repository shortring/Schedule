package com.memo.service;

import com.memo.dto.*;
import com.memo.entity.Memo;
import com.memo.repository.MemoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    // 속성
    private final MemoRepository memoRepository;
    // 생성자

    // 기능
    @Transactional
    public CreateMemoResponse save(CreateMemoRequest request) {
        Memo memo = new Memo(request.getContents());
        Memo savedMemo = memoRepository.save(memo);
        return new CreateMemoResponse(
                savedMemo.getId(),
                savedMemo.getContents()
        );
    }

    @Transactional(readOnly = true)
    public GetMemoResponse findOne(Long memoId) {
        memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("없는 메모입니다")
        );
        return new GetMemoResponse(
                memo.getId(),
                memo.getContents()
        );
    }

    @Transactional(readOnly = true)
    public List<GetMemoResponse> findAll() {
        List<Memo> memos = memoRepository.findAll();

        List<GetMemoResponse> dtos = new ArrayList<>();
        for (Memo memo : memos) {
            GetMemoResponse dto = new GetMemoResponse(
                    memo.getId(),
                    memo.getContents()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public UpdateMemoResponse update(Long memoId, UpdateMemoRequest request) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("없는 메모입니다")
        );

        memo.updateContents(request.getContents());
        return new UpdateMemoResponse(
                memo.getId(),
                memo.getContents()
        );
    }

    @Transactional
    public void delete(Long memoId) {
        boolean existence = memoRepository.existsById(memoId);

        // 존재하지 않으면!
        if (!existence) {
            throw new IllegalStateException("없는 메모입니다.");
        }

        // 존재하면!
        memoRepository.deleteById(memoId);
    }
}
