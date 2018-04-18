package com.mavenwebs.dao;

import com.mavenwebs.entity.NoteLike;

public interface NoteLikeDao 
{
	
	NoteLike get(Integer noteId, String memberId);

	int insert(NoteLike noteLike);
	
	int delete(NoteLike noteLike);
}
