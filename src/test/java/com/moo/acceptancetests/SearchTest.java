package com.moo.acceptancetests;

import com.moo.pageobjects.BusinessCardPage;
import com.moo.pageobjects.MooLandingPage;
import com.moo.pageobjects.SearchListingsPage;
import org.junit.*;

import static org.junit.Assert.*;

public class SearchTest {

    private MooLandingPage mooLandingPage;
    private SearchListingsPage searchListingsPage;

    @Before
    public void setUp() {
        mooLandingPage = new MooLandingPage();
    }

    @Test
    public void testShouldReturnValidProductsWhenSearchIsValid() {
        searchListingsPage = mooLandingPage.searchFor("Business cards");
        String relevantResult = searchListingsPage.findBusinessCardURL();
        assertTrue(relevantResult.contains("business-cards"));
    }

    @Test
    public void testShouldReturnANotFoundMessageWhenSearchIsInvalid() {
        searchListingsPage = mooLandingPage.searchFor("sdjfnjsdfj");
        String productNotFoundMessage = searchListingsPage.findProductNotFoundMessage();
        String expectedMessage = "Sorry we couldn’t find anything. " +
                "Please check the spelling or alternatively chat to our friendly " +
                "customer services team using the chat below.";
        Assert.assertEquals(expectedMessage, productNotFoundMessage);
    }

    @Test
    public void testShouldTakeMeToProductPage() {
        searchListingsPage = mooLandingPage.searchFor("Business cards");
        BusinessCardPage businessCardPage = searchListingsPage.goToBusinessCardsPage();
        String businessCardPagePageURL = businessCardPage.getPageURL();
        String expectedBusinessCardPagePageURL = "https://www.moo.com/uk/products/business-cards.html";
        assertEquals(expectedBusinessCardPagePageURL, businessCardPagePageURL);
    }


    @After
    public void tearDown() {
        searchListingsPage.close();
    }
}
