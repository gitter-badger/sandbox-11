package net.hogedriven;

import net.hogedriven.i18n.SimplePage;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }

    @Test
    public void homepageRendersSuccessfully() {
        //start and render the test page
        tester.startPage(HomePage.class);

        //assert rendered page class
        tester.assertRenderedPage(HomePage.class);
    }

    @Test
    public void testVersion() {
        tester.startPage(HomePage.class);

        tester.assertLabel("version", "6.19.0");
    }

    @Test
    public void linkHomePageToSimplePage() {
        tester.startPage(HomePage.class);
        tester.clickLink(tester.getComponentFromLastRenderedPage("simplePage"));

        tester.assertRenderedPage(SimplePage.class);
    }
}
