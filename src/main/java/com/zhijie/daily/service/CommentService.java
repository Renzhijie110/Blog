package com.zhijie.daily.service;

import com.zhijie.daily.po.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 根据游记id查询对应的评论列表
     * @param dailyId
     * @return
     */
    List<Comment> listCommentByDailyId(Long dailyId);
    Comment saveComment(Comment comment);
}
