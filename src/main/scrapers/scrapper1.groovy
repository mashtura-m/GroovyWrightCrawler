import com.mashtura.crawler.core.utils.io.ExportToJson
import com.mashtura.crawler.entity.EntityRecords
import groovy.transform.Field

// URL of the source page to scrape

@Field
String sourceUrl = "https://register.fca.org.uk/s/prohibited-individual?predefined=PI"

// Generate the output in JSON format (implementation not shown)
EntityRecords records = new EntityRecords()
records.setSourceUrls(["http//abc"])
records.setEntityName("Test Entity")
records.setEntityType("Organization")
records.setEntityId("12345")
records.setAddress(["123 Test St, Test City, TC 12345"])

// Print the records in JSON format
ExportToJson exportToJson = new ExportToJson()
exportToJson.export(records, "testfile", "C:\\Users\\Mashtura\\Documents\\GitHub\\GroovyWrightCrawler\\output\\")