package com.kosa.myapp.board.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosa.myapp.board.model.Board;
import com.kosa.myapp.board.model.BoardUploadFile;
import com.kosa.myapp.board.service.IBoardService;

@Service
public class BoardService implements IBoardService {
	
//	@Autowired
//	Iqwerty qwerty;
	Board board = new Board();
	
	
	@Transactional
	public void insertArticle(Board boardId) {
		board.setBoardId(qwerty.selectMaxArticleNo()+1);
		qwerty.insertArticle(board);
	}

	@Transactional
	public void insertArticle(Board boardId, BoardUploadFile file) {
		board.setBoardId(qwerty.selectMaxArticleNo()+1);
		qwerty.insertArticle(board);
		if(file != null && file.getFileName() != null &&
	!file.getFileName().equals("")) {
			file.setBoardId(board.getBoardId());
			file.setFileId(qwerty.selectMaxFileId()+1);
			qwerty.insertFileData(file);
	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId, int page) {
		int start = (page-1) *10;
		return qwerty.selectArticleListByCategory(categoryId, start, start+10);
	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId) {
		return qwerty.selectArticleListByCategory(categoryId, 0, 100);
	}

	@Transactional
	public Board selectArticle(int boardId) {
		qwerty.updateReadCount(boardId);
		return qwerty.selectArticle(boardId);
	}

	@Override
	public BoardUploadFile getFile(int fileId) {
		return qwerty.getFile(fileId);
	}

	@Transactional
	public void replyArticle(Board board) {
		qwerty.updateReplyNumber(board.getMasterId(), board.getReplyNumber());
		board.setBoardId(qwerty.selectMaxArticleNo()+1);
		board.setReplyNumber(board.getReplyNumber()+1);
		board.setReplyStep(board.getReplyStep()+1);
		qwerty.replyArticle(board);
	}

	@Transactional
	public void replyArticle(Board board, BoardUploadFile file) {
		qwerty.updateReplyNumber(board.getMasterId(), board.getReplyNumber());
		board.setBoardId(qwerty.selectMaxArticleNo()+1);
		board.setReplyNumber(board.getReplyNumber()+1);
		board.setReplyStep(board.getReplyStep()+1);
		qwerty.replyArticle(board);
		if(file != null && file.getFileName() != null &&
	!file.getFileName().equals("")) {
			file.setBoardId(board.getBoardId());
			qwerty.insertFileData(file);
		}
	}

	@Override
	public String getPassword(int boardId) {
		return qwerty.getPassword(boardId);
	}

	@Override
	public void updateArticle(Board board) {
		qwerty.updateArticle(board);
	}

	@Transactional
	public void updateArticle(Board board, BoardUploadFile file) {
		qwerty.updateArticle(board);
		if(file != null && file.getFileName() != null &&
	!file.getFileName().equals("")) {
			file.setBoardId(board.getBoardId());
			
			if(file.getFileId()>0) {
				qwerty.updateFileData(file);
			} else {
				qwerty.insertFileData(file);
			}
		}
	}

	@Override
	public Board selectDeleteArticle(int boardId) {
		return qwerty.selectDeleteArticle(boardId);
	}

	@Transactional
	public void deleteArticle(int boardId, int replyNumber) {
		if(replyNumber>0) {
			qwerty.deleteReplyFileData(boardId);
			qwerty.deleteArticleByBoardId(boardId);
		} else if(replyNumber==0) {
			qwerty.deleteFileData(boardId);
			qwerty.deleteArticleByBoardId(boardId);
		} else {
			throw new RuntimeErrorException("WRONG_REPLYNUMBER");
		}
	}

	@Override
	public int selectTotalArticleCount() {
		return qwerty.selectTotalArticleCount();
	}

	@Override
	public int selectTotalArticleCountByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return qwerty.selectTotalArticleCountByCategoryId(categoryId);
	}

	@Override
	public List<Board> searchListByContentKeyword(String keyword, int page) {
		int start = (page-1) * 10;
		return qwerty.searchListByContentKeyword("%"+keyword+"%", start, start+10);
	}

	@Override
	public int selectTotalArticleCountByKeyword(String keyword) {
		return qwerty.searchListByContentKeyword("%"+keyword+"%");
	}

}
