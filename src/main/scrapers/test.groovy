import com.mashtura.crawler.core.crawl.WrightEngine
import com.mashtura.crawler.core.utils.io.ExportToJson
import com.mashtura.crawler.entity.EntityRecords
import com.mashtura.crawler.enums.BrowserOptions
import groovy.transform.Field

// URL of the source page to scrape
@Field
String sourceUrl = "https://register.fca.org.uk/s/prohibited-individual?predefined=PI"

/*// List of browser arguments to configure the browser instance
List<String> argsList = Arrays.asList(
        "--disable-gpu", // Disables GPU hardware acceleration
        "--window-size=1238,768" // Sets the browser window size
);

// Initialize the WrightEngine instance for browser automation
WrightEngine engine = new WrightEngine()

// Launch the browser with the specified options
def driver = engine.launchBrowser(BrowserOptions.CHROMIUM, argsList, false)

// Open the specified URL in the browser and wait for the page to load
def page = engine.getWrightPage(driver, sourceUrl, 120000)

// Click on a specific element identified by its XPath
engine.click(page, "//*[@id=\"top-of-page-stuff\"]/section/div/header/button/lightning-primitive-icon")

// Retrieve the HTML content of the current page
def html = engine.getPageContent(page)
// The HTML content can be processed further, e.g., using regex or Playwright

// Close the browser instance
engine.closeBrowser()*/

// Generate the output in JSON format (implementation not shown)
EntityRecords records = new EntityRecords()
records.setSourceUrls(["http//abc"])
records.setEntityName("Test Entity")
records.setEntityType("Organization")
records.setEntityId("12345")
records.setAddress(["123 Test St, Test City, TC 12345"])

// Print the records in JSON format
ExportToJson exportToJson = new ExportToJson()
exportToJson.export(records, "testfile","C:\\Users\\Mashtura\\Documents\\GitHub\\GroovyWrightCrawler\\output\\")