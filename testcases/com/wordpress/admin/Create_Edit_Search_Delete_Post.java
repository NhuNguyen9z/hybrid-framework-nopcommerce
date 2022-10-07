package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.PageGenerator;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPostPO;

public class Create_Edit_Search_Delete_Post extends BaseTest {

	private String searchPostUrl;
	private String username = "automationfc";
	private String password = "automationfc";
	private int ramdomNumber = generateFakeNumber();
	private String postTitle = "Live Code Title " + ramdomNumber;
	private String postBody = "Live Code Body " + ramdomNumber;
	private String editPostTitle = "Edit Title " + ramdomNumber;
	private String editPostBody = "Edit Body " + ramdomNumber;
	private String authorName = "Automation FC";
	private String urlAdminSite, urlUserSite;
	private String currentDate = getCurrentDate();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdminSite, String urlUserSite) {
		this.urlAdminSite = urlAdminSite;
		this.urlUserSite = urlUserSite;

		log.info("Pre-condition - Step 01: Open browser and Admin site");
		driver = getBrowserDriver(browserName, this.urlAdminSite);
		adminLoginPage = PageGenerator.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Enter to Username textbox with value is '" + username + "'");
		adminLoginPage.inputToUsernameTextbox(username);

		log.info("Pre-condition - Step 03: Enter to Password textbox with value is '" + password + "'");
		adminLoginPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostslink();

		log.info("Create_Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create_Post - Step 03: Click to 'Add new' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Create_Post - Step 05: Enter to post body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Create_Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton("Publish");

		log.info("Create_Post - Step 07: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02: Input to Search textbox");
		adminPostSearchPage.inputToSearchTextboxWithTitle(postTitle);

		log.info("Search_Post - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Search_Post - Step 04: Verify Post title is displayed");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search_Post - Step 05: Verify Post author is displayed");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search_Post - Step 06: Open browser and End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.urlUserSite);

		log.info("Search_Post - Step 07: Verify Post title is displayed at Home page");
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));

		log.info("Search_Post - Step 08: Verify Post current day is displayed at Home page");
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDate));

		log.info("Search_Post - Step 9: Verify Post body is displayed at Home page");
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));

		log.info("Search_Post - Step 10: Verify Post author is displayed at Home page");
		Assert.assertTrue(userHomePage.PostInforDisplayedWithPostAuthor(postTitle, authorName));

		log.info("Search_Post - Step 11: Click to 'Posts title' link");
		userPostDetailPage = userHomePage.clickToPostTitleLink(postTitle);

		log.info("Search_Post - Step 12: Verify Post title is displayed at Post detail page");
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));

		log.info("Search_Post - Step 13: Verify Post current day is displayed at Post detail page");
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDate));

		log.info("Search_Post - Step 14: Verify Post body is displayed at Post detail page");
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle, postBody));

		log.info("Search_Post - Step 15: Verify Post author is displayed at Post detail page");
		Assert.assertTrue(userPostDetailPage.PostInforDisplayedWithPostAuthor(postTitle, authorName));
	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(this.urlAdminSite);

		log.info("Create_Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostslink();

		log.info("Edit_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.inputToSearchTextboxWithTitle(postTitle);

		log.info("Edit_Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Edit_Post - Step 05: Click To Post title link and navigate to Edit Post page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit_Post - Step 06: Enter to edit post title");
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);

		log.info("Edit_Post - Step 07: Enter to edit post body ");
		adminPostAddNewPage.enterToEditPostBody(editPostBody);

		log.info("Edit_Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToUpdateButton("Update");

		log.info("Edit_Post - Step 09: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));

		log.info("Edit_Post - Step 10: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Edit_Post - Step 11: Enter to Search textbox");
		adminPostSearchPage.inputToSearchTextboxWithTitle(editPostTitle);

		log.info("Edit_Post - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Edit_Post - Step 13: Verify Search table contains '" + editPostTitle + "'");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

		log.info("Edit_Post - Step 14: Verify Search table contains '" + authorName + "'");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Edit_Post - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.urlUserSite);

		log.info("Edit_Post - Step 16: Verify Post infor displayed at Home page");
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDate));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		Assert.assertTrue(userHomePage.PostInforDisplayedWithPostAuthor(editPostTitle, authorName));

		log.info("Edit_Post - Step 17: Click to 'Posts title' link");
		userPostDetailPage = userHomePage.clickToPostTitleLink(editPostTitle);

		log.info("Edit_Post - Step 18: Verify Post infor is displayed at Post detail page");
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTitle));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDate));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		Assert.assertTrue(userPostDetailPage.PostInforDisplayedWithPostAuthor(editPostTitle, authorName));

	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open 'Admin' site");
		adminDashboardPage = userPostDetailPage.openAdminSite(this.urlAdminSite);

		log.info("Delete_Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostslink();

		log.info("Delete_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.inputToSearchTextboxWithTitle(editPostTitle);

		log.info("Delete_Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Delete_Post - Step 05: Verify Post title is displayed");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

		log.info("Delete_Post - Step 06: Verify Post author is displayed");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Delete_Post - Step 07: Select Post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);

		log.info("Delete_Post - Step 08: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectMoveToTrashDropdown("Move to Trash");

		log.info("Delete_Post - Step 09: Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();

		log.info("Delete_Post - Step 10: Verify '1 post moved to the Trash.' message is displayed");
		Assert.assertTrue(adminPostSearchPage.isPostMoveToTrashDisplayed("1 post moved to the Trash."));

		log.info("Delete_Post - Step 11: Enter to Search textbox");
		adminPostSearchPage.inputToSearchTextboxWithTitle(editPostTitle);

		log.info("Delete_Post - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Delete_Post - Step 13: Verify 'No posts found.' message is displayed");
		Assert.assertTrue(adminPostSearchPage.isMesssgeNoPostFoundDisplayed("No posts found."));

		log.info("Delete_Post - Step 14: Open 'End User' site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.urlUserSite);

		log.info("Delete_Post - Step 15: Verify Post title is Undisplayed at Home page");
		Assert.assertTrue(userHomePage.isPostTitleUndisplayed(editPostTitle));

		log.info("Delete_Post - Step 16: Enter to Search textbox");
		userHomePage.inputToSearchTextboxWithTitle(editPostTitle);

		log.info("Delete_Post - Step 17: Click to 'Search' button");
		userSearchPostPage = userHomePage.clickToSearchButton();

		log.info("Delete_Post - Step 18: Verify 'Nothing Found' message is displayed");
		Assert.assertTrue(userSearchPostPage.isMesssgeNothingFoundDisplayed("Nothing Found"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetailPage;
	private UserSearchPostPO userSearchPostPage;

}
