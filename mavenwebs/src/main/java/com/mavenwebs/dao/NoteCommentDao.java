package com.mavenwebs.dao;

import java.util.List;

import com.mavenwebs.entity.NoteComment;

public interface NoteCommentDao 
{

	int insert(NoteComment comment);

	List<NoteComment> getListByNoteId(Integer page, Integer noteId);
}
