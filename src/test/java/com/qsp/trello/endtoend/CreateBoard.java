package com.qsp.trello.endtoend;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;
import com.qsp.trello.pomrepo.TrelloBoardsPage;

public class CreateBoard extends BaseClass {
	@Test
	public void createBoard() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		trelloBoardsPage.getCreateNewBoard().click();
		trelloBoardsPage.getBoardTitle().sendKeys(jsonUtility.readTheDataFromJsonFile("boardtitle"));
		trelloBoardsPage.getCreateOption().click();
	}
}
