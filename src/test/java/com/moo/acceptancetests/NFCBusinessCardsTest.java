package com.moo.acceptancetests;

import com.moo.pageobjects.BusinessCardPlusPage;
import com.moo.pageobjects.MooLandingPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NFCBusinessCardsTest {

    private MooLandingPage mooLandingPage;
    private BusinessCardPlusPage businessCardPlusPage;

    @Before
    public void setUp() {
        mooLandingPage = new MooLandingPage();
    }

    @Test
    public void testShouldNavigateToNFCBusinessCardsPage() {
        businessCardPlusPage = mooLandingPage.clickNFCBusinessCard();
        String actualPageURL = businessCardPlusPage.getPageURL();
        String expectedPageURL = "https://www.moo.com/uk/products/nfc/business-cards-plus.html";
        Assert.assertEquals(expectedPageURL, actualPageURL);
    }

    @After
    public void tearDown() {
        businessCardPlusPage.close();

    }
}
