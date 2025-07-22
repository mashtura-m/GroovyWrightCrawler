package com.mashtura.crawler.core.crawl;

import com.mashtura.crawler.enums.BrowserOptions;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.List;


public class WrightEngine {

    private Playwright playwright;
    private BrowserType browserType;
    private Browser browserDriver;
    protected BrowserType.LaunchOptions launchOptions;


    public Browser launchBrowser(BrowserOptions browser, List<String> BROWSER_ARGS, boolean headless) {
        playwright = Playwright.create();
        browserType = setBrowserType(browser);
        launchOptions = new BrowserType.LaunchOptions().setArgs(BROWSER_ARGS).setHeadless(headless);
        browserDriver = browserType.launch(launchOptions);
        return browserDriver;
    }

    public BrowserType setBrowserType(BrowserOptions browser) {
        return switch (browser) {
            case CHROMIUM -> playwright.chromium();
            case FIREFOX -> playwright.firefox();
            case WEBKIT -> playwright.webkit();
            default -> throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        };
    }

    public Page getWrightPage(Browser browser, String sourceUrl, int timeouts) {
        Page page = browser.newPage();
        // Wait for full page load (all resources)
        Page.NavigateOptions navigateOptions = new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE).setTimeout(timeouts); // 2min timeout
        page.navigate(sourceUrl, navigateOptions);
        return page;
    }

    public void click(Page page, String xpath) {
        page.locator(xpath).click();
    }

    public String getPageContent(Page page) {
        return page.content();
    }

    public List<Locator> getElements(Page page, String loc, long timeout) {
        waitForSelector(page, loc, timeout);
        return page.locator(loc).all();
    }

    public Locator getElement(Page page, String loc, long timeout) {
        waitForSelector(page, loc, timeout);
        return page.locator(loc);
    }

    public void waitForSelector(Page page, String selector, long timeout) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(timeout));
    }

    public void closeBrowser() {
        if (browserDriver != null) {
            browserDriver.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}