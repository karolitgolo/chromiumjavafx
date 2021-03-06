package pl.itgolo.libs.chromium.Actions;

import org.junit.Assert;
import pl.itgolo.libs.chromium.Abstracts.BrowserTest;
import pl.itgolo.libs.chromium.Browser;
import pl.itgolo.libs.chromium.Exceptions.ChromiumException;
import pl.itgolo.libs.chromium.Interfaces.IBrowserTest;
import spark.Spark;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 12.12.2017
 * Time: 12:33
 * Project name: chromium
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class SelectCheckBoxTest extends BrowserTest implements IBrowserTest {

    /**
     * Before.
     */
    @Override
    public void before() {
        Spark.get("/selectCheckBox", (req, res) -> renderContent("pl/itgolo/libs/chromium/Actions/selectCheckBox.html"));
    }

    /**
     * Test.
     *
     * @param browser the browser
     */
    @Override
    public void test(Browser browser) throws ChromiumException {
        browser.actions.navigateTo(sparkUrl("selectCheckBox"));
        browser.actions.selectCheckBox("input[name='vehicle'][value='Car']", true);
        browser.actions.selectCheckBox("input[name='vehicle'][value='Car']", true);
        browser.actions.selectCheckBox("input[name='vehicle'][value='Car']", false);
        browser.actions.selectCheckBox("input[name='vehicle'][value='Bike']", true);
        Boolean hasException = false;
        try {
            browser.actions.selectCheckBox("input[name='vehicle'][value='None']", true);
        } catch (Exception e) {
        hasException = true;
        }
        Assert.assertTrue(hasException);
    }

    /**
     * After all.
     */
    @Override
    public void afterAll() {

    }
}
