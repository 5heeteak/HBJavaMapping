package com.mavenwebs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteView;


public interface NoteDao 
{
/*	@Select("select * from Note order by regDate desc" + 
			" 		limit ${(page-1)*15},15")
	*/
	List<NoteView> getList(Integer page);

	NoteView get(Integer id);

	int insert(Note note);

	int update(Note note);

	Note getPrev(Integer id);

	Note getNext(Integer id);

}
