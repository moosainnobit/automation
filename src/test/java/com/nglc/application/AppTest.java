package com.nglc.application;

import java.io.IOException;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nglc.core.AppDriver;

import com.nglc.screen.ChangePassword;
import com.nglc.screen.ForgotPassword;
import com.nglc.screen.LoginEmail;
import com.nglc.screen.LoginPassword;
import com.nglc.screen.Logout;
import com.nglc.screen.OrganisationAdd;
import com.nglc.screen.OrganisationList;
import com.nglc.screen.OrganisationOverview;
import com.nglc.screen.UserAdd;
import com.nglc.screen.UserList;
import com.nglc.screen.UserDelete;
import com.nglc.screen.UserEdit;
import com.relevantcodes.extentreports.LogStatus;

public class AppTest extends AppDriver {
	LoginEmail le;
	LoginPassword lp;
	ForgotPassword fp;
	ChangePassword cp;
	OrganisationOverview oo;
	OrganisationList ol;
	OrganisationAdd oa;
	Logout logout;
	UserAdd ua;
	UserList ul;
	UserDelete ud;
	UserEdit ue;
	public static Properties Obj = new Properties();

	public AppTest() {
		super();
		le = new LoginEmail();
		lp = new LoginPassword();
		fp = new ForgotPassword();
		oo = new OrganisationOverview();
		ol = new OrganisationList();
		oa = new OrganisationAdd();
		logout = new Logout();
		ul = new UserList();
		ua = new UserAdd();
		ud = new UserDelete();
	}

	@Test(priority = 1, groups = { "Login-Functional" })
	public void login() throws InterruptedException {
		test = extent.startTest("Login_FT_001 - Verify if user is able to login successfully.");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
	}

	@Test(priority=2, groups = { "Login-Functional" })
	public void loginEmptyEmail() throws InterruptedException {
		test = extent.startTest("Login_FT_002 - Verify Login user with empty Email Address");
		test.log(LogStatus.INFO,"Email address is Empty and Click on the Next Button");
	le.verifyLoginAuthScreen();
		le.clickOnNextButton();
		le.validateErrorMessageBlankEmail();
		  
	}
	
	@Test(priority=3, groups = { "Login-Functional" })
	public void loginUnregisteredEmail() throws InterruptedException  {
		test = extent.startTest("Login_FT_003 - Verify Validation Message display if user email is invalid or unregistered");
	le.verifyLoginAuthScreen();
		le.enterUnregisteredUsername();		
		le.clickOnNextButton();
		le.validateErrorMessageUnregisteredEmail();
	}

	
	@Test(priority=4, groups = { "Login-Functional" })
	public void validateErrorCaseSensitivityEmail() throws InterruptedException {
		test = extent.startTest("Login_FT_004 - Check if the login function handles case sensitivity for Username");	
	le.verifyLoginAuthScreen();
		le.enterCaseSensitivityEmail();		
		le.clickOnNextButton();	
		lp.verifyLoginPasswordScreen();
	}

//	// ================Password Screen====================

	@Test(priority=5, groups = { "Login-Functional" })
	public void PasswordBackText() throws InterruptedException {
		test = extent.startTest("Login_FT_005 - Check the back button link is there in the Password screen.");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		Thread.sleep(1000);
		lp.clickOnBackTextBtn();
		
		
	}
	
	
	@Test(priority=7, groups = { "Login-Functional" })
	public void validateEmailAddressInPasswordScreen() throws InterruptedException {
		test = extent.startTest("Login_FT_007 - Verify the email address field on password Screen as enter in login screen.");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		Thread.sleep(1000);
		lp.validateEmailAddress();
	}
	

	@Test(priority=8, groups = {"Login-Functional"})
	public void validateErrorMessageBlankPassword() throws InterruptedException {
	    test = extent.startTest("Login_FT_008 - Test with valid username and empty password and check if login fails");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.clickOnLoginBtn();
		lp.BlankPasswordMessageValidate();
		lp.verifyLoginPasswordScreen();
	}
		
	@Test(priority=9, groups = {"Login-Functional"})
	public void verifyMaskedPassword() throws InterruptedException {
	    test = extent.startTest("Login_FT_009 - Check of the password is masked on the screen i.e., password must be in bullets or asterisks.");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.MaskedPassword();
	}
		

	@Test(priority=10, groups = {"Login-Functional"})	
	public void invalidPassword() throws InterruptedException, IOException {
		test = extent.startTest("Login_FT_010 - Test with valid username and Invalid password and check if login fails");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.enterInvalidPassword();
		lp.clickOnLoginBtn();
		lp.invalidPasswordMessageValidate();
		lp.verifyLoginPasswordScreen();
	}


	@Test(priority=11, groups = {"Login-Functional"})	
	public void validateErrorCaseSensitivityPwd() throws InterruptedException, IOException {
		test = extent.startTest("Login_FT_011 - Check if the login function handles case sensitivity for Password");
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.enterCaseSensitivityPwd();
		lp.clickOnLoginBtn();		
		lp.validateErrorMessageCaseSensitivityPwd();
		lp.verifyLoginPasswordScreen();
	}

	@Test(priority=12, groups = { "Login-Functional" })
	public void forgotPassword() throws InterruptedException {
		test = extent.startTest("Login_FT_012 -	verify when selecting forgot password link it is directing to forgot password page.");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.clickOnForgotPasswordBtn();
		lp.verifyForgotPasswordScreen();
	}
	
	
	@Test(priority=13, groups = { "Login-Functional" })
	public void verifyEmailAddress() throws InterruptedException {
		test = extent.startTest("Login_FT_013 - Verify the Email Address Field.");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.clickOnForgotPasswordBtn();
		fp.validateEmailAddress();
		
	}


	@Test(priority=14, groups = {"Login-Functional" })
	public void validEmailResetPassword() throws InterruptedException {
		test = extent.startTest("Login_FT_014 - To check Send Reset Link button is clickable and message should be dispaly.");
	le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.verifyLoginPasswordScreen();
		lp.clickOnForgotPasswordBtn();
		lp.verifyForgotPasswordScreen();
		fp.clickOnSendResetLinkBtn();
		Thread.sleep(1000);
		fp.verifyNotificationMsgAfterClickOnSendResetBtn();
	}



	/* =============Organization Functional========== */

	 @Test(priority=100, groups = { "Organisation-Functional" })
	public void overviewScreen() throws InterruptedException {
		 test = extent.startTest("Org_FT_100 :: Verify User able to view Organization Overview Screen");
	le.verifyLoginAuthScreen();
			le.enterValidUsername();		
			le.clickOnNextButton();	
			lp.verifyLoginPasswordScreen();
			lp.enterValidPassword();		
			lp.clickOnLoginBtn();
			oo.overviewScreen();
	}
	 
	  @Test(priority=101, groups = { "Organisation-Functional" })
	public void organisationsLink() throws InterruptedException {
		test = extent.startTest("Org_FT_101 :: Verify User able to Redirect to Organization List Page");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.verifyLoginPasswordScreen();
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		
	}
	  
	 @Test(priority=102, groups = { "Organisation-Functional" })
	public void bibliothecaUserLink() throws InterruptedException {
		 test = extent.startTest("Org_FT_102 :: Verify User able to Redirect to Bibliotheca User List Page");	
		le.verifyLoginAuthScreen();
		 le.enterValidUsername();		
			le.clickOnNextButton();	
			lp.verifyLoginPasswordScreen();
			lp.enterValidPassword();		
			lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		
	}
	 
	 
	@Test(priority=103, groups = { "Organisation-Functional" })
	public void notification() throws InterruptedException {
		test = extent.startTest("Org_FT_103 - Verify User able to View and Click Notifications Icon");	
		le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.verifyLoginPasswordScreen();
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnNotificationIcon();
	}
	
	 
	@Test(priority=104, groups = { "Organisation-Functional" })
	public void profileIcon() throws InterruptedException {
		test = extent.startTest("Org_FT_104 - Verify User able to view and click Profile Icon");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.verifyLoginPasswordScreen();
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnProfileIcon();
	}
	
	 
	@Test(priority=105, groups = { "Organisation-Functional" })
	public void logout() throws InterruptedException {
		test = extent.startTest("Org_FT_105 - Verify Logout Functionality");	
		le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.verifyLoginPasswordScreen();
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();	
		oo.overviewScreen();
		oo.clickOnProfileIcon();		
		logout.clickOnLogoutBtn();
		le.verifyLoginAuthScreen();
	}
	
	@Test(priority=106, groups = { "Organisation-Functional" })
	public void redirectAddOrganisationScreen() throws InterruptedException {
		test = extent.startTest("Org_FT_106 - Verify Add Organization Button");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.verifyLoginPasswordScreen();
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();	
	oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		ol.clickOnAddAnOrganisationBtn();
	}
	

	@Test(priority=107, groups = { "Organisation-Functional" })
	public void redirectOrganisationDetailScreen() throws InterruptedException {
		test = extent.startTest("Org_FT_107 - Verify Organization Details View Page");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();
	oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		Thread.sleep(2000);
		ol.clickOnLibraryListView();
	}

	
	
	@Test(priority=109, groups = { "Organisation-Functional" })
	public void countryDropdownVisible() throws InterruptedException {
		test = extent.startTest("Org_FT_109 - Verify the Country dropdown is enabled and visible in the organisation List Screen.");	
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();
	oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		ol.isEnableCountry();
		
	}
	
	@Test(priority=112, groups = { "Organisation-Functional" })
	public void searchIconClickable() throws InterruptedException {
		test = extent.startTest("Org_FT_112 - Verify that Search Icon is clickable in Organisation List Screen");
	le.verifyLoginAuthScreen();
		le.enterValidUsername();		
		le.clickOnNextButton();	
		lp.enterValidPassword();		
		lp.clickOnLoginBtn();
	oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		ol.clickOnSearchIcon();		
	}
	
	
	@Test(priority = 113, groups = { "Organisation-Functional" })
	public void searchExistingOrganisation() throws InterruptedException {
		test = extent.startTest("Org_FT_113 - Verify Search Functionality in Organisation List Screen");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		ol.clickOnSearchIcon();
		ol.validSearchData();

	}

	
	@Test(priority = 114, groups = { "Organisation-Functional" })
	public void searchNonExistingOrganisation() throws InterruptedException {
		test = extent.startTest(
				"Org_FT_114 - Verify that non Existing Data would be not visible in Organisation List Screen");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		ol.clickOnSearchIcon();
		ol.invalidSearchData();

	}

	// need to work
	@Test(priority = 115, groups = { "Organisation-Functional" })
	public void CreateOrganisation() throws InterruptedException {
		test = extent.startTest("Org_FT_115 - Verify Create Organization Functionality");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		ol.clickOnAddAnOrganisationBtn();
		oa.CreateAnOrganisationFilledAllRequiredData();
		Thread.sleep(2000);
		oa.clickOnCreateOrganisationButton();
	}

	// need to work
	@Test(priority = 116, groups = { "Organisation-Functional" })
	public void BlankDataCreateOrganisation() throws InterruptedException {
		test = extent.startTest("Org_FT_116 -Verify Validation Messages for Required Fields in Add Organization Screen");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnOrganisationsLink();
		ol.clickOnAddAnOrganisationBtn();
		oa.clickOnCreateOrganisationButton();
		oa.CreateAnOrganisationBlankRequiredData();
	}

	@Test(priority = 207, groups = { "User-Functional" })
	public void AddingUserwithBlankData() throws InterruptedException {
		test = extent.startTest("User_FT_207 - Verify Validation Messages for Required Fields in Add User Screen");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnAddUserBtn();
		ua.AddUserButtonClick();
		Thread.sleep(2000);
		ua.ReqFullNameBlankInput();
		ua.ReqEmailBlankInput();
		ua.ReqPhoneBlankInput();
		ua.ReqRoleBlankInput();
		ua.ReqLocBlankInput();
		ua.ValidateRedirectiononInvalidUser();
	}

	/* =============User Functional========== */

	@Test(priority = 200, groups = { "User-Functional" })
	public void userlist() throws InterruptedException {
		test = extent.startTest("User_FT_200 - Verify Search icon in User List");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnSearchIcon();
		Thread.sleep(1000);
	}

	@Test(priority = 201, groups = { "User-Functional" })
	public void ValidUserSearch() throws InterruptedException {
		test = extent.startTest("User_FT_201 - Verify Search with Valid User");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnSearchIcon();
		ul.ValidUserSearch();
		Thread.sleep(1000);
	}

	@Test(priority = 202, groups = { "User-Functional" })
	public void InvalidUserSearch() throws InterruptedException {
		test = extent.startTest("User_FT_202 - Verify Search with Invalid User");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnSearchIcon();
		ul.InvalidUserSearch();
		Thread.sleep(1000);
	}

	@Test(priority = 203, groups = { "User-Functional" })
	public void AddUserButton() throws InterruptedException {
		test = extent.startTest("User_FT_203 - Verify Add User Button");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnAddUserBtn();
		Thread.sleep(1000);
	}

	@Test(priority = 204, groups = { "User-Functional" })
	public void UserProfile() throws InterruptedException {
		test = extent.startTest("User_FT_204 - Verify User Profile Page");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnActiveUserCard();
		Thread.sleep(1000);
	}

	@Test(priority = 205, groups = { "User-Functional" })
	public void UserBreadCrumb() throws InterruptedException {
		test = extent.startTest("User_FT_205 - Verify Breadcrumb Click on Add User Screen");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnAddUserBtn();
		Thread.sleep(1000);
		ua.AddUserBreadcrumbClick();
	}

	@Test(priority = 206, groups = { "User-Functional" })
	public void AddingValidUser() throws InterruptedException {
		test = extent.startTest("User_FT_206 - Verify Adding New User");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnAddUserBtn();
		ua.AddValidUser();
		Thread.sleep(1000);
		ua.AddUserButtonClick();
		Thread.sleep(1000);
		ua.ValidateRedirectiononValidUser();
		Thread.sleep(1000);
	}

	@Test(priority = 208, groups = { "User-Functional" })
	public void CancelDeleteUser() throws InterruptedException {
		test = extent.startTest("User_FT_208 - Verify Canceling the deletion of user");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnActiveUserCard();
		ud.ClickonDeleteIcon();
		Thread.sleep(1000);
		ud.ClickonCancelButton();
	}

	@Test(priority = 209, groups = { "User-Functional" })
	public void ConfirmDeleteUser() throws InterruptedException {
		test = extent.startTest("User_FT_209 - Verify deletion of user");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(1000);
		ul.ClickOnInvitedUserCard();
		ud.ClickOnInvitedDeleteIcon();
		Thread.sleep(1000);
		ud.ClickonConfirmButton();
	}

	@Test(priority = 210, groups = { "User-Functional" })
	public void EditValidUser() throws InterruptedException {
		test = extent.startTest("User_FT_210 - Verify Updation of user");
		le.verifyLoginAuthScreen();
		le.enterValidUsername();
		le.clickOnNextButton();
		lp.enterValidPassword();
		lp.clickOnLoginBtn();
		oo.overviewScreen();
		oo.clickOnBibliothecaUsersLink();
		Thread.sleep(2000);
		ul.ClickOnActiveUserCard();
		ue.EditUserName();
		ue.EditUserPhone();
		ue.ClickOnApplyChangesButton();
		ue.ValidateRedirectiononValidEditing();
	}

} /* End AppTest Class Here */
