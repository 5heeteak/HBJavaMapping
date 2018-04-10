package com.mavenwebs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mavenwebs.entity.Note;


public interface NoteDao 
{
/*	@Select("select * from Note order by regDate desc" + 
			" 		limit ${(page-1)*15},15")
	*/
	List<Note> getList(Integer page);

	Note get(Integer id);

	int insert(Note note);

	int update(Note note);

}
