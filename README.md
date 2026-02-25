# GroovyWrightCrawler

GroovyWrightCrawler is a lightweight Java/Groovy toolkit for building Playwright-powered crawlers and exporting structured entity data to JSON.

## Features

- Playwright browser launcher with support for Chromium, Firefox, and WebKit
- Utility methods for navigation, element lookup, clicks, and selector waits
- Entity record model for storing scraped data
- JSON export utility with pretty-printed output
- Groovy scraper script support under `src/main/scrapers`

## Tech Stack

- Java 17
- Groovy 4
- Maven
- Microsoft Playwright for Java
- Jackson (JSON serialization)

## Project Structure

```text
src/main/java/com/mashtura/crawler/
├── core/
│   ├── crawl/WrightEngine.java        # Browser lifecycle and page interaction helpers
│   ├── exceptions/ScrapingException.java
│   └── utils/io/ExportToJson.java     # Writes EntityRecords to JSON files
├── entity/
│   ├── EntityData.java                # Contract for entity data
│   └── EntityRecords.java             # Entity data implementation
└── enums/
    ├── BrowserOptions.java
    └── BrowserPreferences.java

src/main/scrapers/
└── scrapper1.groovy                   # Example Groovy scraper script
```

## Prerequisites

- JDK 17+
- Maven 3.9+
- Internet access (Playwright browser binaries download on first use)

## Getting Started

### 1) Clone and build

```bash
git clone https://github.com/mashtura-m/groovywrightcrawler.git
cd groovywrightcrawler
mvn clean test
```

### 2) Basic Java usage

```java
import com.mashtura.crawler.core.crawl.WrightEngine;
import com.mashtura.crawler.enums.BrowserOptions;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import java.util.List;

public class Example {
  public static void main(String[] args) {
    WrightEngine engine = new WrightEngine();
    Browser browser = engine.launchBrowser(BrowserOptions.CHROMIUM, List.of("--disable-blink-features=AutomationControlled"), true);

    try {
      Page page = engine.getWrightPage(browser, "https://example.com", 120_000);
      String html = engine.getPageContent(page);
      System.out.println("Page content length: " + html.length());
    } finally {
      engine.closeBrowser();
    }
  }
}
```

### 3) Export scraped records to JSON

```java
import com.mashtura.crawler.core.utils.io.ExportToJson;
import com.mashtura.crawler.entity.EntityRecords;

import java.util.List;

EntityRecords records = new EntityRecords();
records.setEntityId("12345");
records.setEntityName("Test Entity");
records.setEntityType("Organization");
records.setAddress(List.of("123 Test St, Test City"));
records.setSourceUrls(List.of("https://example.com/source"));

ExportToJson exporter = new ExportToJson();
exporter.export(records, "testfile", "output/");
```

This creates `output/testfile.json`.

## Running the Groovy scraper script

The repository includes an example scraper at:

- `src/main/scrapers/scrapper1.groovy`

You can run it with Groovy once dependencies are available in your environment, or adapt it as a template for your own scrapers.

## Notes and current limitations

- `EntityRecords.findById(...)` and `EntityRecords.updateEntity(...)` are placeholders and currently return `null`.
- `src/main/resources/wright.yml` is present for future configuration but currently empty.
- The sample Groovy script currently uses a Windows-style absolute output path; consider changing to a relative path (for example, `output/`) for portability.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE).
