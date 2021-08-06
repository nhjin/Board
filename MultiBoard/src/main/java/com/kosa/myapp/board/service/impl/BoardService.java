package com.kosa.myapp.board.service.impl;

import java.util.List;

import com.kosa.myapp.board.model.Board;
import com.kosa.myapp.board.model.BoardUploadFile;
import com.kosa.myapp.board.service.IBoardService;

public class BoardService implements IBoardService {

	@Override
	public void insertArticle(Board boardId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertArticle(Board boardId, BoardUploadFile file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectArticle(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardUploadFile getFile(int fileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void replyArticle(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyArticle(Board board, BoardUploadFile file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPassword(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticle(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArticle(Board board, BoardUploadFile file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board selectDeleteArticle(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(int boardId, int replyNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectTotalArticleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectTotalArticleCountByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> searchListByContentKeyword(String keyword, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTotalArticleCountByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

}
